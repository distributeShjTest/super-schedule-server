package com.su.schedule.model.dto;

/**
 * @author:lph on 2017年3月28日
 */
public class DataSend {
	private String courseName;
	private String teacherName;
	private String className;
	private Integer schoolId;

	public Integer getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	@Override
	public String toString() {
		return "DataSend [courseName=" + courseName + ", teacherName=" + teacherName + ", className=" + className + "]";
	}
	
}
