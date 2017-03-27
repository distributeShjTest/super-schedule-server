package com.su.schedule.spy.resolver;

import com.su.schedule.model.constants.ElementTdLocation;
import com.su.schedule.model.constants.HtmlConstant;
import com.su.schedule.model.constants.HtmlElement;
import com.su.schedule.model.dto.ClassDetail;
import com.su.schedule.spy.connnet.impl.HttpConnect;
import com.su.schedule.spy.connnet.impl.PageParamHeaderSimulate;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by shj on 2017/3/26.
 */
@Component
public class HtmlResolver {
    @Autowired
    private HttpConnect httpConnect;
//    private final int maxReConnect = 5;

    private org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(HtmlResolver.class);
    public List<ClassDetail> resolve(int pageNum)throws Exception{
        List<ClassDetail> classDetails = new ArrayList<ClassDetail>();
        Document document = this.getDocument(pageNum);

        Element table =  document.getElementById(HtmlConstant.TABLE_DOCUMENT_ID);
        Elements tbody = table.getElementsByTag(HtmlElement.TBODY.getName());
        if(tbody.size()>1){
            logger.error("tbody size >1,pageNum is"+pageNum);
            return null;
        }
        for(Element tr:tbody.select(HtmlElement.TR.getName())){
            List<Element> tds = tr.select(HtmlElement.TD.getName());
            if(tds==null)
                continue;
            ClassDetail classDetail = new ClassDetail();
            for(int i=0;i<tds.size();i++){

                insertClassDetail(classDetail,i,tds.get(i).text());
            }
            classDetails.add(classDetail);
        }


        return classDetails;
    }


    public static void insertClassDetail(ClassDetail target,int index,String value)throws InvocationTargetException,IllegalAccessException{
        if(target==null)
            return;
        Class cl = target.getClass();
        String fieldName = ElementTdLocation.getFieldName(index);
        if(fieldName==null)
            return;
        try {
            Field field = cl.getDeclaredField(fieldName);
            field.setAccessible(true);
            Type type = field.getGenericType();
            if(type.equals(String.class)){
                field.set(target,value);
            }else if(type.equals(int.class)){
                field.set(target,Integer.parseInt(value));
            }else{
                field.set(target, Arrays.asList(value.trim().split(",")));
            }


        }catch (NoSuchFieldException e){
            e.printStackTrace();
            return;
        }

    }

    public void setHttpConnect(HttpConnect httpConnect) {
        this.httpConnect = httpConnect;
    }

    private Document getDocument(int pageNum)throws Exception{
        String html = this.getHtml(pageNum);

        if(html==null){
            logger.error("html is null,pageNum is "+pageNum);
        }
        Document document = Jsoup.parse(html);
        Elements titles = document.getElementsByTag(HtmlElement.TITLE.getName());
        for(Element e:titles){
            if(e.text().equals(HtmlConstant.ERROR_PAGE)){
                this.httpConnect.getCookie();
                html = this.getHtml(pageNum);
                break;
            }
        }
        if(html==null){
            logger.error("html is null after reConnect,pageNum is "+pageNum);
        }

        return Jsoup.parse(html);

    }

    private String getHtml(int pageNum)throws Exception{
        if(pageNum==1){
            return this.httpConnect.executeRequest(this.httpConnect.httpPostSimulate(PageParamHeaderSimulate.getFirstPageRequest()),true);
        }else {
            return this.httpConnect.executeRequest(this.httpConnect.httpPostSimulate(PageParamHeaderSimulate.getOtherPageRequest(pageNum)),true);
        }
    }
}
