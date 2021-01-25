package com.elephez.knowSharding.controller;

import com.elephez.knowSharding.bean.Data;
import com.elephez.knowSharding.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhuo
 */
@RestController
@RequestMapping("/data")
public class DataController {

    @Autowired
    private DataService dataService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Object add(@RequestBody Data data){
        dataService.add(data);
        return "true";
    }

    @RequestMapping(value = "/del",method = RequestMethod.POST)
    @ResponseBody
    public Object del(int id){
        dataService.del(id);
        return "true";
    }

    @RequestMapping(value = "/mod",method = RequestMethod.POST)
    @ResponseBody
    public Object mod(@RequestBody Data data){
        dataService.mod(data);
        return "true";
    }

    @RequestMapping(value = "/que",method = RequestMethod.GET)
    @ResponseBody
    public Object que(int id){
        return dataService.que(id);
    }

}
