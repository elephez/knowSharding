package com.elephez.knowSharding.strategy;

import com.google.common.collect.Range;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;
import sun.misc.Cleaner;

import java.text.SimpleDateFormat;
import java.time.temporal.TemporalUnit;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhuo
 */
public class CustomShardingStrategy implements RangeShardingAlgorithm {

    public CustomShardingStrategy(){}

    @Override
    public Collection<String> doSharding(Collection collection, RangeShardingValue rangeShardingValue) {
        Range dataRange = rangeShardingValue.getValueRange();

        Object lowerEndpoint = dataRange.lowerEndpoint();
        Object upperEndpoint = dataRange.upperEndpoint();

        boolean ifIllegalArgs = (dataRange.hasLowerBound() && !(lowerEndpoint instanceof Date)) || (dataRange.hasUpperBound() && !(upperEndpoint instanceof Date));

        if(ifIllegalArgs){
            throw new IllegalArgumentException("range arguments type is illegal! expect java.util.Date!");
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");

        String[] dateBeginSplits = sdf.format((Date)lowerEndpoint).split("-");
        String[] dateEndSplit = sdf.format((Date)upperEndpoint).split("-");

        boolean crossYear = !dateBeginSplits[0].equals(dateEndSplit[0]);
        if(crossYear){
            return collection;
        }

        int monthStart = dataRange.hasLowerBound()?Integer.parseInt(dateBeginSplits[1]):1;
        int monthEnd = dataRange.hasUpperBound()?Integer.parseInt(dateEndSplit[1]):12;

        List list = (List) collection.stream().filter((ele)->{
            int currMonth = Integer.parseInt(ele.toString().substring(5));
            return currMonth>=monthStart&&currMonth<=monthEnd;
        }).collect(Collectors.toList());
        return list;
    }

    public static void main(String[] args) {
        CustomShardingStrategy customShardingStrategy = new CustomShardingStrategy();
        List list = Arrays.asList(new String[]{"test_1","test_2","test_3","test_4","test_5","test_6","test_7","test_8","test_9","test_10","test_11","test_12"});
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH,2);
        Date t1 = calendar.getTime();
        calendar.set(Calendar.MONTH,5);
        Date t2 = calendar.getTime();
        Collection collection = customShardingStrategy.doSharding(list, new RangeShardingValue("test","time",Range.open(t1,t2)));
        for(Object data : collection){
            System.out.println(data);
        }
    }
}
