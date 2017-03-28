package com.su.schedule.model.po;

public class Course {
	private Integer id;
	private String name;
	private String peroid;
	private String score;
	private Integer departmId;
	
	public Course(){
	}
	
	public Course(Integer id, String name, String peroid, String score, Integer departmId){
		this.id = id;
		this.name = name;
		this.peroid = peroid;
		this.score = score;
		this.departmId = departmId;
	}
	
	@Override
	public String toString(){
		return "Course{" +
                "id=" + id +
                ", name='" + name +'\''+
                ", period='" + peroid + '\'' +
                ", score='" + score + '\'' +
                ", departmId=" + departmId +
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
		return peroid;
	}
	public void setPeriod(String period) {
		this.peroid = period;
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
}
