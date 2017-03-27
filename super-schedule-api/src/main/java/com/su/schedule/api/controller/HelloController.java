package com.su.schedule.api.controller;

import com.su.schedule.api.constants.ControllerConstant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by shj on 2017/3/27.
 */

@Controller
@RequestMapping(value = "/hello")
public class HelloController {


    @RequestMapping(value = "getHello",consumes = ControllerConstant.APPLICATION_JSON,method = RequestMethod.POST)

    public @ResponseBody Object getHello(@RequestBody Map map){
        System.out.println(map);
        map.put("hello","hello");
        return map;
    }


}
