package com.su.schedule.model.vo;



import java.io.Serializable;
import java.util.SimpleTimeZone;

/**
 * Created by war on 2017/3/26.
 */

public class TimeTableModel implements Serializable{
    private int id;
    private int startnum;
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
                + ", weeknum=" + weeknum + "]";
    }

    public TimeTableModel() {

    }

    public TimeTableModel(int id, int startnum, int endnum, int week,
                          String starttime, String endtime, String lessonname, String teacher,
                          String classroom, String weeknum) {
        super();
        this.id = id;
        this.startnum = startnum;
        this.endnum = endnum;
        this.week = week;
        this.starttime = starttime;
        this.endtime = endtime;
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

    public String getmClass() {
        return mClass;
    }

    public void setmClass(String mClass) {
        this.mClass = mClass;
    }

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
