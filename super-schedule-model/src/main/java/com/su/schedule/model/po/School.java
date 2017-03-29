package com.su.schedule.model.po;

/**
 * @author:lph on 2017年3月29日
 */
public class School {
	private Integer id;
	private String name;

	@Override
	public String toString() {
		return "School{" + 
				"id=" + id + ", name='" + 
				name + '\'' +
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
