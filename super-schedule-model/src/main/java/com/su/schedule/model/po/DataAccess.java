package com.su.schedule.model.po;

public class DataAccess {
	private Integer id;
	private Integer weekNo;
	private Integer lessonNo;
	private String className;
	private String period;
	private String teacherName;
	private String courseName;
	private Integer courseId;
	private Integer teacherId;

	
	public DataAccess() {
	}


	@Override
	public String toString() {
		return "DataAccess{" +
				"id=" + id +
				", weekNo=" + weekNo +
				", lessonNo=" + lessonNo +
				", className='" + className + '\'' +
				", period='" + period + '\'' +
				", teacherName='" + teacherName + '\'' +
				", courseName='" + courseName + '\'' +
				", courseId=" + courseId +
				", teacherId=" + teacherId +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		DataAccess that = (DataAccess) o;

		if (id != null ? !id.equals(that.id) : that.id != null) return false;
		if (weekNo != null ? !weekNo.equals(that.weekNo) : that.weekNo != null) return false;
		if (lessonNo != null ? !lessonNo.equals(that.lessonNo) : that.lessonNo != null) return false;
		if (className != null ? !className.equals(that.className) : that.className != null) return false;
		if (period != null ? !period.equals(that.period) : that.period != null) return false;
		if (teacherName != null ? !teacherName.equals(that.teacherName) : that.teacherName != null) return false;
		if (courseName != null ? !courseName.equals(that.courseName) : that.courseName != null) return false;
		if (courseId != null ? !courseId.equals(that.courseId) : that.courseId != null) return false;
		return teacherId != null ? teacherId.equals(that.teacherId) : that.teacherId == null;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (weekNo != null ? weekNo.hashCode() : 0);
		result = 31 * result + (lessonNo != null ? lessonNo.hashCode() : 0);
		result = 31 * result + (className != null ? className.hashCode() : 0);
		result = 31 * result + (period != null ? period.hashCode() : 0);
		result = 31 * result + (teacherName != null ? teacherName.hashCode() : 0);
		result = 31 * result + (courseName != null ? courseName.hashCode() : 0);
		result = 31 * result + (courseId != null ? courseId.hashCode() : 0);
		result = 31 * result + (teacherId != null ? teacherId.hashCode() : 0);
		return result;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
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
