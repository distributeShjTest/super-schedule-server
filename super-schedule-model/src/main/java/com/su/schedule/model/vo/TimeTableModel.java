package com.su.schedule.model.vo;

<<<<<<< HEAD
=======


>>>>>>> e48aac113d6e8602f79ff654eb164bd0a1d83b55
import java.io.Serializable;
import java.util.SimpleTimeZone;

/**
 * Created by war on 2017/3/26.
 */

public class TimeTableModel implements Serializable{
    private int id;
<<<<<<< HEAD
    private int startnum;   //开始的节次
    private int endnum;     //结束的节次
    private int week;       //周几
    private String lessonname; //课程名
    private String teacher;    //老师
    private String classroom;  //教室
    private String weeknum;   //第几周

    @Override
    public String toString() {
        return "schedule[id=" + id + ", startnum=" + startnum
                + ", endnum=" + endnum + ", week=" + week
                + ", lessonname=" + lessonname
                + ", teacher=" + teacher + ", classroom=" + classroom
=======
    private int startnum;   //寮�濮嬬殑鑺傛
    private int endnum;
    private int week;
    private String starttime=null;
    private String endtime=null;
    private String lessonname=null;
    private String teacher=null;
    private String mClass=null;
    private String classroom=null;
    private String weeknum=null;

    @Override
    public String toString() {
        return "TimeTableModel [id=" + id + ", startnum=" + startnum
                + ", endnum=" + endnum + ", week=" + week + ", starttime="
                + starttime + ", endtime=" + endtime + ", lessonname=" + lessonname
                + ", teacher=" + teacher + ", mClass=" + mClass+", classroom=" + classroom
>>>>>>> e48aac113d6e8602f79ff654eb164bd0a1d83b55
                + ", weeknum=" + weeknum + "]";
    }

    public TimeTableModel() {

    }

<<<<<<< HEAD
    public TimeTableModel(int id, int startnum, int endnum, int week, String lessonname, String teacher,
=======
    public TimeTableModel(int id, int startnum, int endnum, int week,
                          String starttime, String endtime, String lessonname, String teacher,
>>>>>>> e48aac113d6e8602f79ff654eb164bd0a1d83b55
                          String classroom, String weeknum) {
        super();
        this.id = id;
        this.startnum = startnum;
        this.endnum = endnum;
        this.week = week;
<<<<<<< HEAD
=======
        this.starttime = starttime;
        this.endtime = endtime;
>>>>>>> e48aac113d6e8602f79ff654eb164bd0a1d83b55
        this.lessonname = lessonname;
        this.teacher = teacher;
        this.classroom = classroom;
        this.weeknum = weeknum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStartnum() {
        return startnum;
    }

    public void setStartnum(int startnum) {
        this.startnum = startnum;
    }

    public int getEndnum() {
        return endnum;
    }

    public void setEndnum(int endnum) {
        this.endnum = endnum;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

<<<<<<< HEAD
=======
    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

>>>>>>> e48aac113d6e8602f79ff654eb164bd0a1d83b55
    public String getLessonname() {
        return lessonname;
    }

    public void setLessonname(String lessonname) {
        this.lessonname = lessonname;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

<<<<<<< HEAD
=======
    public String getmClass() {
        return mClass;
    }

    public void setmClass(String mClass) {
        this.mClass = mClass;
    }

>>>>>>> e48aac113d6e8602f79ff654eb164bd0a1d83b55
    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getWeeknum() {
        return weeknum;
    }

    public void setWeeknum(String weeknum) {
        this.weeknum = weeknum;
    }
}
