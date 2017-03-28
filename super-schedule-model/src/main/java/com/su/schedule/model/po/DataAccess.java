package com.su.schedule.model.po;

public class DataAccess {
	private Integer id;
	private Integer weekNo;
	private Integer lessonNo;
	private String className;
	private String period;
	private String teacherName;
	private String courseName;
	
	public DataAccess() {
	}
	
	@Override
	public String toString(){
		return "Relation{" +
                "id=" + id +
                ", weekNo=" + weekNo +
                ", lessonNo=" + lessonNo +
                ", className='" + className + '\'' +
                ", period=" + period + '\'' +
                ", teacherName=" + teacherName + '\'' +              
                ", buildingName='" + courseName + '\'' +
                '}';
	}
	
	public DataAccess(Integer id, Integer weekNo, Integer lessonNo, String className, String peroid, String teacherName, String buildingName){
		this.id = id;
		this.weekNo = weekNo;
		this.lessonNo = lessonNo;
		this.className = className;
		this.period = period;
		this.teacherName = teacherName;
		this.courseName = buildingName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getWeekNo() {
		return weekNo;
	}

	public void setWeekNo(Integer weekNo) {
		this.weekNo = weekNo;
	}

	public Integer getLessonNo() {
		return lessonNo;
	}

	public void setLessonNo(Integer lessonNo) {
		this.lessonNo = lessonNo;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getPeroid() {
		return period;
	}

	public void setPeroid(String peroid) {
		this.period = peroid;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getBuildingName() {
		return courseName;
	}

	public void setBuildingName(String buildingName) {
		this.courseName = buildingName;
	}
	
}
