package com.su.schedule.model.po;

public class Department {
	private Integer id;
	private Integer no;
	private String name;
	
	@Override
	public String toString(){
		return "Course{" +
                "id=" + id +
                ", no=" + no +
                ", name='" + name + '\'' +
                '}';
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
