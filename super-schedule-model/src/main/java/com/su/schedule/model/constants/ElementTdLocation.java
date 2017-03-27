package com.su.schedule.model.constants;

/**
 * Created by shj on 2017/3/27.
 */
public enum ElementTdLocation {
    LESSON(0,"lesson"),CREDIT(1,"credit"),TEACHER_NAME(2,"teacherName"),TITLE(3,"title"),CLASS_NAMES(10,"classNames"),WEEKS(11,"weeks"),SECTIONS(12,"sections"),LOCATION(13,"location"),DEPARTMENT(14,"department");
    private int location;
    private String fieldName;


    ElementTdLocation(int location, String method) {
        this.location = location;
        this.fieldName = method;
    }

    public int getLocation() {
        return location;
    }

    public String getFieldName() {
        return fieldName;
    }

    public static String getFieldName(int location){
        for(ElementTdLocation e:ElementTdLocation.values()){
            if(e.getLocation()==location)
                return e.getFieldName();
        }
        return null;
    }

}
