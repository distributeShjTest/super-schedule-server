package com.su.schedule.model.vo;

import java.io.Serializable;
import java.util.SimpleTimeZone;

/**
 * Created by war on 2017/3/26.
 */

public class TimeTableModel implements Serializable{
    private int id;
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
                + ", weeknum=" + weeknum + "]";
    }

    public TimeTableModel() {

    }

    public TimeTableModel(int id, int startnum, int endnum, int week, String lessonname, String teacher,
                          String classroom, String weeknum) {
        super();
        this.id = id;
        this.startnum = startnum;
        this.endnum = endnum;
        this.week = week;
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
