package com.su.schedule.model.po;

public class Class {
	private Integer id;
	private String name;
	
	public Class(){
	}
	
	public Class(Integer id, String name){
		this.id = id;
		this.name = name;
	}
	
	@Override
	public String toString(){
		return "Class{" +
                "id=" + id +
                ", name='" + name  + '\'' +
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

}
