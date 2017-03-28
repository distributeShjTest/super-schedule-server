package com.su.schedule.client;
import com.su.schedule.model.vo.*;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

import java.io.IOException;
import java.util.List;

import com.squareup.okhttp.*;

import net.sf.json.JSONObject;
import com.su.schedule.model.vo.*;

public class Transformer {
	 MediaType mediatype = MediaType.parse("application/json");
	 public  OkHttpClient mokhttpclient=new OkHttpClient();
	 public List<TimeTableModel> list;
	 public SendModle sendmodle=new SendModle();
     public List<TimeTableModel> findByTeacher(String teacher,String lessonname){
    	       JSONObject myjson=new JSONObject();
    	       sendmodle.setTearcher(teacher);
    	       sendmodle.setLessonname(lessonname);
    	       myjson.put("sendmodle", sendmodle);
        	   RequestBody requestbody=RequestBody.create(mediatype, myjson.toString());
        	   Request request =new Request.Builder().url("http://localhost/find/findbyteacher").post(requestbody).build();
        	   try {
				Response response=mokhttpclient.newCall(request).execute();
				String result=response.body().toString();
				System.out.println(result);
		   	    JSONObject rejson=JSONObject.fromObject(result);
		   	    List list=(List<TimeTableModel>)rejson.get("list");
		   	    System.out.println(list);
				response.body().close();
				//rejson.put(key, value)
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				return list;

      }
}
