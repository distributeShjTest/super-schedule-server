package com.su.schedule.model.po;

public class Teacher {
	private Integer id;
	private String name;
	private String level;
	
	@Override
	public String toString(){
		return "Course{" +
                "id=" + id +
                ", name=" + name + '\'' +
                ", level='" + level + '\'' +
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
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	
}
