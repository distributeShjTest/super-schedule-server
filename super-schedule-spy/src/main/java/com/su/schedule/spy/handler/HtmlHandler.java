package com.su.schedule.spy.handler;

import com.su.schedule.business.read.dao.ClassReadDao;
import com.su.schedule.business.read.dao.CourseReadDao;
import com.su.schedule.business.read.dao.DepartmentReadDao;
import com.su.schedule.business.read.dao.TeacherReadDao;
import com.su.schedule.business.write.dao.*;
import com.su.schedule.model.dto.ClassDetail;
import com.su.schedule.model.po.*;
import com.su.schedule.model.po.Class;
import com.su.schedule.spy.resolver.HtmlResolver;
import net.sf.cglib.core.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * Created by shj on 2017/3/27.
 */
@Component
public class HtmlHandler {
    @Autowired
    private HtmlResolver htmlResolver;

    @Autowired
    private ClassReadDao classReadDao;
    @Autowired
    private ClassWriteDao classWriteDao;
    @Autowired
    private TeacherReadDao teacherReadDao;
    @Autowired
    private TeacherWriteDao teacherWriteDao;
    @Autowired
    private CourseReadDao courseReadDao;
    @Autowired
    private CourseWriteDao courseWriteDao;
    @Autowired
    private DepartmentReadDao departmentReadDao;
    @Autowired
    private DepartmentWriteDao departmentWriteDao;
    @Autowired
    private RelationWriteDao relationWriteDao;
    private boolean isUpdate;

    Logger logger = Logger.getLogger(HtmlHandler.class);
    @PostConstruct
    public void init(){
        this.isUpdate = true;
    }



    private void handleRosolver(List<ClassDetail> classDetails){
        List<Relation> relations = new ArrayList<Relation>();
        HashMap<String,Teacher> teacherMap = new HashMap();
        HashSet<String> classNames = new HashSet<String>();
        HashSet<String> departmentNames = new HashSet<String>();
        HashMap<String,Course> courseMap  = new HashMap<String, Course>();
        List<Teacher> teachers = null;
        List<Class> classes = null;
        List<Course> courses = null;
        List<Department> departments = null;
        for(ClassDetail c:classDetails){
            if(teacherMap.get(c.getTeacherName())==null){
                Teacher teacher = new Teacher();
                teacher.setLevel(c.getTitle());
                teacher.setName(c.getTeacherName());
            }
            departmentNames.add(c.getDepartment());
            if(courseMap.get(c.getLesson())==null){
                Course course = new Course();
                course.setName(c.getLesson());
                course.setPeriod(c.getWeeks());
                course.setScore(c.getCredit());
//                course.setScore();
            }
//            courseNames.add(new String[]{c.getLesson(),c.getDepartment()});
            if(org.springframework.util.CollectionUtils.isEmpty(c.getClassNames()))
                continue;
            for(String cName:c.getClassNames()){
                classNames.add(cName);
            }
        }
//        List<Relation> relations = new ArrayList<Relation>();
        classes = this.getAllClasses(Arrays.asList((String[])classNames.toArray()));
        departments = this.getAllDepartments(Arrays.asList((String[])departmentNames.toArray()));
        teachers = this.getAllTeachers(teacherMap);
        courses = this.getAllCourses(courseMap,departments);


        for(ClassDetail c:classDetails){
            Relation relation = new Relation();
            relation.setTeacherId(this.getTeacherID(teachers,c.getTeacherName()));
            relation.setCourseId(this.getCourseId(courses,c.getLesson()));
            relation.setBuildingName(c.getLocation());
            try {
                this.relationWriteDao.insertRelation(relation);
            }catch (Exception e){
                e.printStackTrace();
                logger.error(e.getMessage());
            }


        }
    }

    private List<Teacher> getAllTeachers(HashMap<String,Teacher> teacherMap){
        return null;
    }

    private List<Class> getAllClasses(List<String> classNames){
        return null;
    }

    private List<Department> getAllDepartments(List<String> departmentNames){
        return null;
    }

    private List<Course> getAllCourses(HashMap<String,Course> courseMap,List<Department> departments){
        return null;
    }

//    private void handleTeachers(List<Teacher> teachers,ClassDetail classDetail,Relation relation){
//        if(org.springframework.util.CollectionUtils.isEmpty(teachers))
//            return;
//        for(Teacher t:teachers){
//            if(t.getName().equals(classDetail.getTeacherName())){
//                relation.setTeacherId(t.getId());
//                return;
//            }
//        }
//
//    }

    private void handleCourse(List<Course> courses,ClassDetail classDetail,Relation relation){
        if(org.springframework.util.CollectionUtils.isEmpty(courses))
            return;
        for(Course c:courses){
            if(c.getName().equals(classDetail.getLesson())){
                relation.setCourseId(c.getId());
                return;
            }
        }
    }


    private Integer getCourseId(List<Course> courses,String courseName){
        if(org.springframework.util.CollectionUtils.isEmpty(courses))
            return -1;
        for(Course c:courses){
            if(c.getName().equals(courseName))
                return c.getId();
        }
        return -1;

    }

    private Integer getTeacherID(List<Teacher> teachers,String teacherName){
        if(org.springframework.util.CollectionUtils.isEmpty(teachers))
            return -1;
        for(Teacher t:teachers){
            if(t.getName().equals(teacherName))
                return t.getId();
        }
        return -1;
    }




    public void setHtmlResolver(HtmlResolver htmlResolver) {
        this.htmlResolver = htmlResolver;
    }
}
