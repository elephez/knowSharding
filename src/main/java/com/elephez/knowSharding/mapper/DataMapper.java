package com.elephez.knowSharding.mapper;

import com.elephez.knowSharding.bean.Data;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DataMapper {

    void add(Data data);

    void del(int id);

    void mod(Data data);

    Object que(int id);

}
