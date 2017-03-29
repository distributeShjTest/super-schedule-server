package com.su.schedule.model.po;

/**
 * Created by shj on 2017/3/28.
 */
public class CRRel {
    private int id;
    private int classId;
    private int relationId;
    private Integer schoolId;

	@Override
    public String toString() {
        return "CRRel{" +
                "id=" + id +
                ", classId=" + classId +
                ", relationId=" + relationId +
                ", schoolId=" + schoolId +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CRRel crRel = (CRRel) o;

        if (id != crRel.id) return false;
        if (classId != crRel.classId) return false;
        return relationId == crRel.relationId;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + classId;
        result = 31 * result + relationId;
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getRelationId() {
        return relationId;
    }

    public void setRelationId(int relationId) {
        this.relationId = relationId;
    }

    public Integer getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}
}
