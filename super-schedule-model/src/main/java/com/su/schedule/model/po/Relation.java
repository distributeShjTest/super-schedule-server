package com.su.schedule.model.po;

public class Relation {
	private Integer id;
	private Integer weekNo;
	private Integer lessonNo;
	private String buildingName;
	private Integer roomNo;
	private Integer courseId;
	private Integer teacherId;
	
	public Relation(){
	}
	
	@Override
	public String toString(){
		return "Relation{" +
                "id=" + id +
                ", weekNo=" + weekNo +
                ", lessonNo=" + lessonNo +
                ", buildingName='" + buildingName + '\'' +
                ", roomNo=" + roomNo +
                ", courseId=" + courseId +
                ", teacherId=" + teacherId +
                '}';
	}
	
	public Relation(Integer id,Integer weekNo,Integer lessonNo,String buildingName,Integer roomNo,Integer courseId,Integer teacherId){
		this.id = id;
		this.lessonNo = lessonNo;
		this.buildingName = buildingName;
		this.roomNo = roomNo;
		this.courseId = courseId;
		this.teacherId = teacherId;
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

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public Integer getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(Integer roomNo) {
		this.roomNo = roomNo;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	
	

}

