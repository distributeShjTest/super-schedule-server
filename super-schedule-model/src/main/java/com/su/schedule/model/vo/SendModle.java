package com.su.schedule.model.vo;

public class SendModle {
       @Override
	public String toString() {
		return "SendModle [tearcher=" + tearcher + ", lessonname=" + lessonname + ", department=" + department
				+ ", major=" + major + ", classname=" + classname + "]";
	}
      private String tearcher;
      private String lessonname;
      private String department;
       public String getTearcher() {
		return tearcher;
	}
	public void setTearcher(String tearcher) {
		this.tearcher = tearcher;
	}
	public String getLessonname() {
		return lessonname;
	}
	public void setLessonname(String lessonname) {
		this.lessonname = lessonname;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	private String major;
	private String classname;
}
