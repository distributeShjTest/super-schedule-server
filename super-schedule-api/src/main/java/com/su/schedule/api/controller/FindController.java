package com.su.schedule.api.controller;
import com.su.schedule.model.dto.DataSend;
import com.su.schedule.model.dto.DataSendExtend;
import com.su.schedule.model.vo.*;
import com.google.gson.JsonObject;
import com.su.schedule.api.constants.ControllerConstant;
import com.su.schedule.business.read.manage.CourseReadManage;
import com.su.schedule.business.read.manage.DataAccessReadManage;
import com.su.schedule.business.read.manage.TeacherReadManage;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.ObjectOutputStream.PutField;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by zhaosy on 2017/3/27.
 */

@Controller
@RequestMapping(value="/find")
public class FindController {
	
	@Autowired
	private DataAccessReadManage dataAccessReadManage;
	@Autowired
	private TeacherReadManage teacherReadManage;
	@Autowired
	private CourseReadManage courseReadManage;
	
	
    @RequestMapping(value = "findbyteacher",consumes = ControllerConstant.APPLICATION_JSON,method = RequestMethod.POST)
    public @ResponseBody Object findByTeacher(@RequestBody Map sendmodle) throws UnsupportedEncodingException{
        System.out.println(sendmodle);
        List<TimeTableModel> list=new LinkedList();
        DataSendExtend datasend=new DataSendExtend();
        if (sendmodle.get("teacher")!=null){
            if(sendmodle.get("teacher").equals(""))
                datasend.setTeacherName(null);
            else {
                datasend.setTeacherName(sendmodle.get("teacher").toString());
            }

        }
        if (sendmodle.get("lessonname")!=null){
            if(sendmodle.get("lessonname").equals("")){
                datasend.setCourseName(null);
            }else {
                datasend.setCourseName(sendmodle.get("lessonname").toString());
            }

         }
        if (sendmodle.get("week")!=null&&(!sendmodle.get("week").toString().trim().equals(""))){
            datasend.setWeekNum((Integer)sendmodle.get("week"));
         }

        try {
			list=dataAccessReadManage.getTimeTableModels(datasend);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        JSONObject myjson=new JSONObject();
        myjson.put("list", list);
        return myjson.toString().getBytes("UTF-8");
    }
    
    @RequestMapping(value = "findallteachers",consumes = ControllerConstant.APPLICATION_JSON,method = RequestMethod.POST)
    public @ResponseBody Object findAllTeacher(@RequestBody Map map)throws Exception{
        System.out.println(map);
////        List<TimeTableModel> list=new LinkedList();
////        TimeTableModel timetable=new TimeTableModel();
////        timetable.setClassroom("中心一楼");
////        timetable.setEndnum(6);
////        timetable.setTeacher("大奔");
//        List<String> list=new LinkedList();
//        list.add("大奔");
//        list.add("小凯");
//        list.add("老吴");
//        list.add("寒剑");
//        list.add("家辉");
//        list.add("朋辉");
        List<String> list =new LinkedList<String>();
        list=teacherReadManage.getAllTeacherNames();
        JSONObject myjson=new JSONObject();
        myjson.put("list", list);
        return myjson.toString().getBytes("UTF-8");
    	
    }
    
    @RequestMapping(value = "findalllessons",consumes = ControllerConstant.APPLICATION_JSON,method = RequestMethod.POST)
    public @ResponseBody Object findAllLessons(@RequestBody Map map)throws Exception{
    	System.out.println(map);
//        List<String> list=new LinkedList();
//        list.add("软件工程");
//        list.add("电影鉴赏");
//        list.add("Dota2");
//        list.add("LOL");
//        list.add("演员的自我修养");
//        list.add("昨天");
    	List<String> list =new LinkedList<String>();
    	list=courseReadManage.getAllCourseNames();
        JSONObject myjson=new JSONObject();
        myjson.put("list", list);
        System.out.println(myjson);
        return myjson.toString().getBytes("UTF-8");
    	
    }
    

}
