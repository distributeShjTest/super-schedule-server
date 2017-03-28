package com.su.schedule.model.po;

public class Class {
	private Integer id;
	private String name;
	
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Class aClass = (Class) o;

		if (id != null ? !id.equals(aClass.id) : aClass.id != null) return false;
		return name != null ? name.equals(aClass.name) : aClass.name == null;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		return result;
	}
}
