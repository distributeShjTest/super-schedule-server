package com.su.schedule.model.po;

/**
 * @author:lph on 2017年3月28日
 */
public class Course {
	private Integer id;
	private String name;
	private String period;
	private String score;
	private Integer departmId;
	private Integer schoolId;

	public Course(){
	}

	public Course(Integer id, String name, String peroid, String score, Integer departmId, Integer schoolId){
		this.id = id;
		this.name = name;
		this.period = peroid;
		this.score = score;
		this.departmId = departmId;
		this.schoolId = schoolId;
	}

	@Override
	public String toString(){
		return "Course{" +
                "id=" + id +
                ", name='" + name +'\''+
                ", period='" + period + '\'' +
                ", score='" + score + '\'' +
                ", departmId=" + departmId +
                ", schoolId=" + schoolId +
                '}';
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public Integer getDepartmId() {
		return departmId;
	}
	public void setDepartmId(Integer departmId) {
		this.departmId = departmId;
	}
	
	public Integer getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}
}
