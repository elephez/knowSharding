package com.elephez.knowSharding.strategy;

import com.google.common.collect.Range;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhuo
 */
public class CustomPreciseShardingStrategy implements PreciseShardingAlgorithm {

    public CustomPreciseShardingStrategy(){}


    @Override
    public String doSharding(Collection availableTargetNames, PreciseShardingValue shardingValue) {
        Object value = shardingValue.getValue();

        System.out.println(value);
        System.out.println(value.getClass());
        return availableTargetNames.toArray()[0].toString();
    }
}
