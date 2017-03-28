package com.su.schedule.api.controller;
import com.su.schedule.model.vo.*;
import com.google.gson.JsonObject;
import com.su.schedule.api.constants.ControllerConstant;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.ObjectOutputStream.PutField;
import java.util.List;
import java.util.Map;

/**
 * Created by zhaosy on 2017/3/27.
 */

@Controller
@RequestMapping(value="/find")
public class FindController {
      String teacher;
      String lessonname;
      List<TimeTableModel> list;
  //  @RequestMapping(value = "getHello",consumes = ControllerConstant.APPLICATION_JSON,method = RequestMethod.POST)
    @RequestMapping(value = "findbyteacher")
    public @ResponseBody JSONObject findByTeacher(@RequestBody SendModle sendmodle){
        System.out.println(sendmodle);
        this.teacher=sendmodle.getTearcher();
        this.lessonname=sendmodle.getLessonname();
        TimeTableModel timetable=new TimeTableModel();
        timetable.setClassroom("中心一楼");
        timetable.setEndnum(6);
        timetable.setTeacher("王力");
        list.add(timetable);
        JSONObject myjson=new JSONObject();
        myjson.put("list", list);
        return myjson;
    }


}
