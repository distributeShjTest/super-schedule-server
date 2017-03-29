package com.su.schedule.model.po;

/**
 * @author:lph on 2017年3月28日
 */
public class Teacher {
	private Integer id;
	private String name;
	private String level;
	private Integer schoolId;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Teacher teacher = (Teacher) o;

		if (id != null ? !id.equals(teacher.id) : teacher.id != null) return false;
		if (name != null ? !name.equals(teacher.name) : teacher.name != null) return false;
		return level != null ? level.equals(teacher.level) : teacher.level == null;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (level != null ? level.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Teacher{" +
				"id=" + id +
				", name='" + name + '\'' +
				", level='" + level + '\'' +
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

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Integer getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}
}
