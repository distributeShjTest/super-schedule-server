package com.su.schedule.spy.resolver.impl;

import com.su.schedule.model.constants.HtmlElement;
import com.su.schedule.model.dto.ClassDetail;
import com.su.schedule.model.po.Teacher;
import com.su.schedule.model.vo.TimeTableModel;
import com.su.schedule.spy.connnet.HttpConnect;
import com.su.schedule.spy.connnet.PageParamHeaderSimulate;
import com.su.schedule.spy.connnet.impl.PeizhengPageParamHeaderSimulate;
import com.su.schedule.spy.resolver.HtmlResolver;
import org.apache.http.client.methods.HttpGet;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * Created by shj on 2017/3/29.
 */
@Component(value = "peizhengHtmlResolver")
public class PeizhengHtmlResolver implements HtmlResolver{

    @Autowired
    @Qualifier(value = "peizhengHttpConnect")
    private HttpConnect httpConnect;

    @Autowired
    @Qualifier(value = "peizhengPageParamHeaderSimulate")
    private PeizhengPageParamHeaderSimulate pageParamHeaderSimulate;


    public Map<String,Teacher> resolveTeacher(String html)throws Exception{


        Map<String,Teacher> teacherMap = new HashMap<String, Teacher>();
        Document document = Jsoup.parse(html);
        Elements options =  document.select(HtmlElement.OPTION.getName());

        if(ObjectUtils.isEmpty(options.toArray()))
            return teacherMap;


        for(Element o:options){
            if(StringUtils.isEmpty(o.text()))
                continue;
            Teacher teacher = new Teacher();
            teacher.setName(o.text());
            teacher.setLevel(o.attr("value"));
            teacherMap.put(teacher.getName(),teacher);
        }

        return teacherMap;
    }


    public List<TimeTableModel> resolveClassDetail(String html,String teacher,Integer weekNo)throws Exception{
        List<TimeTableModel> timeTableModels = new ArrayList<TimeTableModel>();
        Document document = Jsoup.parse(html);
        Elements elements = document.select("tbody");
//        System.out.println(elements.get(0).select("tbody").select("table").get(2).select("tbody"));
        Elements trList = null;
        try {
           trList  = elements.get(0).select("tbody").select("table").get(2).select("tbody").select("tr");
        }catch (Exception e){

        }
        if(trList==null)
            return null;

            trList.remove(0);
        for(int i=0;i<trList.size();i++){

            Elements tdList =  trList.get(i).select("td");
            for(int j=2;j<tdList.size();j++){
                if(StringUtils.isEmpty(tdList.get(j).text()))
                    continue;
                TimeTableModel timeTableModel = new TimeTableModel();
                this.parseTd(timeTableModel,tdList.get(j).text(),i,j);
                timeTableModel.setTeacher(teacher);
                timeTableModel.setWeeknum(String.valueOf(weekNo));
                timeTableModels.add(timeTableModel);
            }
        }
        return timeTableModels;
    }


    private void parseTd(TimeTableModel timeTableModel,String content,int class_no,int week_no){
        if(timeTableModel==null)
            return;
        List<String> classDetailString = Arrays.asList(content.split(" "));
        System.out.println(classDetailString);
        timeTableModel.setLessonname(classDetailString.get(0));
        timeTableModel.setWeek(week_no);
        timeTableModel.setStartnum(class_no*2);
        timeTableModel.setEndnum(class_no*2+1);
    }








}
