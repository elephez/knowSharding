package com.elephez.knowSharding.service;

import com.elephez.knowSharding.bean.Data;
import com.elephez.knowSharding.mapper.DataMapper;
import org.springframework.stereotype.Service;

@Service
public class DataService {
    private DataMapper dataMapper;

    public DataService(DataMapper mapper){
        this.dataMapper = mapper;
    }

    public void add(Data data){
        dataMapper.add(data);
    }

    public void del(int id){
        dataMapper.del(id);
    }

    public void mod(Data data){
        dataMapper.mod(data);
    }

    public Object que(int id){
        return dataMapper.que(id);
    }
}
