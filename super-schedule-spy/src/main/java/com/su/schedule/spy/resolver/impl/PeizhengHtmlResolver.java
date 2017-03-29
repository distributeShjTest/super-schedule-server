package com.su.schedule.spy.resolver.impl;

import com.su.schedule.model.constants.HtmlElement;
import com.su.schedule.model.dto.ClassDetail;
import com.su.schedule.model.po.Teacher;
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

import java.util.ArrayList;
import java.util.List;

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


    public List<Teacher> resolveTeacher(String html)throws Exception{
//        HttpGet httpGet = this.pageParamHeaderSimulate.getTeacherPages();
//        String html = this.httpConnect.executeRequest(this.httpConnect.httpGetSimulate(httpGet),true);

        List<Teacher> teachers = new ArrayList<Teacher>();
        Document document = Jsoup.parse(html);
        Elements options =  document.select(HtmlElement.OPTION.getName());
        if(ObjectUtils.isEmpty(options.toArray()))
            return teachers;


        for(Element o:options){
            if(StringUtils.isEmpty(o.text()))
                continue;
            Teacher teacher = new Teacher();
            teacher.setName(o.text());
            teachers.add(teacher);
        }

        return teachers;
    }


    public List<ClassDetail> resolveClassDetail(String html)throws Exception{

        Document document = Jsoup.parse(html);
        Elements elements = document.select("table");
        for(Element e:elements){
            System.out.println(e);
        }
        return null;
    }








}
