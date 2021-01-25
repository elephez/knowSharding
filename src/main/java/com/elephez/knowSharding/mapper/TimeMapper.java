package com.elephez.knowSharding.mapper;

import com.elephez.knowSharding.bean.Data;
import com.elephez.knowSharding.bean.Time;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.Map;

@Mapper
public interface TimeMapper {

    void add(Time time);

    void del(Date date);

    void mod(Date date);

    Object que(Map timeRange);

}
