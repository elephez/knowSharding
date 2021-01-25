package com.elephez.knowSharding.controller;

import com.elephez.knowSharding.bean.Data;
import com.elephez.knowSharding.bean.Time;
import com.elephez.knowSharding.service.DataService;
import com.elephez.knowSharding.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhuo
 */
@RestController
@RequestMapping("/time")
public class TimeController {

    @Autowired
    private TimeService timeService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Object add(@RequestBody Time time){
        timeService.add(time);
        return "true";
    }

    @RequestMapping(value = "/del",method = RequestMethod.POST)
    @ResponseBody
    public Object del(Date date){
        timeService.del(date);
        return "true";
    }

    @RequestMapping(value = "/mod",method = RequestMethod.POST)
    @ResponseBody
    public Object mod(@RequestBody Date date){
        timeService.mod(date);
        return "true";
    }

    @RequestMapping(value = "/que",method = RequestMethod.GET)
    @ResponseBody
    public Object que(Date startTime, Date endTime){
         Map params = new HashMap<>(4);
         params.put("startTime",startTime);
         params.put("endTime",endTime);
        return timeService.que(params);
    }

}
