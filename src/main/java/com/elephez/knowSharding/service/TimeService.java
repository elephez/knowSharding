package com.elephez.knowSharding.service;

import com.elephez.knowSharding.bean.Data;
import com.elephez.knowSharding.bean.Time;
import com.elephez.knowSharding.mapper.DataMapper;
import com.elephez.knowSharding.mapper.TimeMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * @author zhuo
 */
@Service
public class TimeService {
    private TimeMapper timeMapper;

    public TimeService(TimeMapper mapper){
        this.timeMapper = mapper;
    }

    public void add(Time time){
        timeMapper.add(time);
    }

    public void del(Date date){
        timeMapper.del(date);
    }

    public void mod(Date data){
        timeMapper.mod(data);
    }

    public Object que(Map timeRange){
        return timeMapper.que(timeRange);
    }

}
