package com.su.schedule.model.dto;

import java.util.List;

/**
 * Created by shj on 2017/3/27.
 */
public class ClassDetail {
    private String lesson;
    private int credit;
    private String teacherName;
    private String title;
    private List<String> classNames;
    private String weeks;
    private String sections;
    private String location;
    private String department;

    public ClassDetail() {
    }

    public ClassDetail(String lesson, int credit, String teacherName, String title, List<String> classNames, String weeks, String sections, String location, String department) {
        this.lesson = lesson;
        this.credit = credit;
        this.teacherName = teacherName;
        this.title = title;
        this.classNames = classNames;
        this.weeks = weeks;
        this.sections = sections;
        this.location = location;
        this.department = department;
    }


    @Override
    public String
    toString() {
        return "ClassDetail{" +
                "lesson='" + lesson + '\'' +
                ", credit=" + credit +
                ", teacherName='" + teacherName + '\'' +
                ", title='" + title + '\'' +
                ", classNames=" + classNames +
                ", weeks='" + weeks + '\'' +
                ", sections='" + sections + '\'' +
                ", location='" + location + '\'' +
                ", department='" + department + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClassDetail that = (ClassDetail) o;

        if (credit != that.credit) return false;
        if (lesson != null ? !lesson.equals(that.lesson) : that.lesson != null) return false;
        if (teacherName != null ? !teacherName.equals(that.teacherName) : that.teacherName != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (classNames != null ? !classNames.equals(that.classNames) : that.classNames != null) return false;
        if (weeks != null ? !weeks.equals(that.weeks) : that.weeks != null) return false;
        if (sections != null ? !sections.equals(that.sections) : that.sections != null) return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;
        return department != null ? department.equals(that.department) : that.department == null;
    }

    @Override
    public int hashCode() {
        int result = lesson != null ? lesson.hashCode() : 0;
        result = 31 * result + credit;
        result = 31 * result + (teacherName != null ? teacherName.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (classNames != null ? classNames.hashCode() : 0);
        result = 31 * result + (weeks != null ? weeks.hashCode() : 0);
        result = 31 * result + (sections != null ? sections.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (department != null ? department.hashCode() : 0);
        return result;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getClassNames() {
        return classNames;
    }

    public void setClassNames(List<String> classNames) {
        this.classNames = classNames;
    }

    public String getWeeks() {
        return weeks;
    }

    public void setWeeks(String weeks) {
        this.weeks = weeks;
    }

    public String getSections() {
        return sections;
    }

    public void setSections(String sections) {
        this.sections = sections;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
