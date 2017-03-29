package com.su.schedule.model.po;

/**
 * @author:lph on 2017年3月28日
 */
public class Relation {
	private Integer id;
	private Integer weekNo;
	private String lessonNo;
	private String buildingName;
	private Integer roomNo;
	private Integer courseId;
	private Integer teacherId;
	private Integer schoolId;

	public Relation(){
	}

	@Override
	public String toString() {
		return "Relation{" +
				"id=" + id +
				", weekNo=" + weekNo +
				", lessonNo='" + lessonNo + '\'' +
				", buildingName='" + buildingName + '\'' +
				", roomNo=" + roomNo +
				", courseId=" + courseId +
				", teacherId=" + teacherId +
				", schoolId=" + schoolId +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Relation relation = (Relation) o;

		if (id != null ? !id.equals(relation.id) : relation.id != null) return false;
		if (weekNo != null ? !weekNo.equals(relation.weekNo) : relation.weekNo != null) return false;
		if (lessonNo != null ? !lessonNo.equals(relation.lessonNo) : relation.lessonNo != null) return false;
		if (buildingName != null ? !buildingName.equals(relation.buildingName) : relation.buildingName != null)
			return false;
		if (roomNo != null ? !roomNo.equals(relation.roomNo) : relation.roomNo != null) return false;
		if (courseId != null ? !courseId.equals(relation.courseId) : relation.courseId != null) return false;
		return teacherId != null ? teacherId.equals(relation.teacherId) : relation.teacherId == null;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (weekNo != null ? weekNo.hashCode() : 0);
		result = 31 * result + (lessonNo != null ? lessonNo.hashCode() : 0);
		result = 31 * result + (buildingName != null ? buildingName.hashCode() : 0);
		result = 31 * result + (roomNo != null ? roomNo.hashCode() : 0);
		result = 31 * result + (courseId != null ? courseId.hashCode() : 0);
		result = 31 * result + (teacherId != null ? teacherId.hashCode() : 0);
		return result;
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

	public String getLessonNo() {
		return lessonNo;
	}

	public void setLessonNo(String lessonNo) {
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
	
	public Integer getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}
}

