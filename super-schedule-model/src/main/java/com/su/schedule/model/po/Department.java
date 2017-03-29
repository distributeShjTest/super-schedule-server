package com.su.schedule.model.po;

/**
 * @author:lph on 2017年3月28日
 */
public class Department {
	private Integer id;
	private Integer no;
	private String name;
	private Integer schoolId;

	@Override
	public String toString(){
		return "Course{" +
                "id=" + id +
                ", no=" + no +
                ", name='" + name + '\'' +
                ", schoolId=" + schoolId +
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
	
	public Integer getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}
}
