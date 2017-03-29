package com.su.schedule.spy.handler.impl;

import com.su.schedule.business.read.manage.ClassReadManage;
import com.su.schedule.business.read.manage.CourseReadManage;
import com.su.schedule.business.read.manage.DepartmentReadManage;
import com.su.schedule.business.read.manage.TeacherReadManage;
import com.su.schedule.business.write.manage.*;
import com.su.schedule.model.constants.HtmlConstant;
import com.su.schedule.model.dto.ClassDetail;
import com.su.schedule.model.dto.CourseEx;
import com.su.schedule.model.po.*;
import com.su.schedule.model.po.Class;
import com.su.schedule.spy.handler.HtmlHandler;
import com.su.schedule.spy.resolver.impl.CsuHtmlResolver;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * Created by shj on 2017/3/27.
 */
@Component
public class CsuHandler implements HtmlHandler{
    @Autowired
    private CsuHtmlResolver htmlResolver;

    @Autowired
    private ClassReadManage classReadManage;
    @Autowired
    private ClassWriteManage classWriteManage;
    @Autowired
    private TeacherReadManage teacherReadManage;
    @Autowired
    private TeacherWriteManage teacherWriteManage;
    @Autowired
    private CourseReadManage courseReadManage;
    @Autowired
    private CourseWriteManage courseWriteManage;
    @Autowired
    private DepartmentReadManage departmentReadManage;
    @Autowired
    private DepartmentWriteManage departmentWriteManage;
    @Autowired
    private RelationWriteManage relationWriteManage;
    @Autowired
    private CRRelWriteManage crRelWriteManage;

    private boolean isUpdate;

    private static final Integer schoolId = 0;

    Logger logger = Logger.getLogger(CsuHandler.class);
    @PostConstruct
    public void init(){
        this.isUpdate = true;
    }



    public void handleRosolver(List<ClassDetail> classDetails){
        try {
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
                teacherMap.put(c.getTeacherName(),teacher);
            }
            departmentNames.add(c.getDepartment());
            if(courseMap.get(c.getLesson())==null){
                CourseEx course = new CourseEx();
                course.setName(c.getLesson());
                course.setPeriod(this.weekStringHandle(c.getWeeks()));
                course.setScore(c.getCredit());
                course.setDepartmentName(c.getDepartment());
                courseMap.put(c.getLesson(),course);

//                course.setScore();
            }
//            courseNames.add(new String[]{c.getLesson(),c.getDepartment()});
            if(org.springframework.util.CollectionUtils.isEmpty(c.getClassNames()))
                continue;

            for(String cName:c.getClassNames()){
                classNames.add(cName);
            }
        }
            System.out.println("cache load success");
//        List<Relation> relations = new ArrayList<Relation>();
        classes = this.getAllClasses(new ArrayList<String>(classNames));
            System.out.println("classes update success");
        departments = this.getAllDepartments(new ArrayList<String>(departmentNames));
            System.out.println("department update success");
        teachers = this.getAllTeachers(teacherMap);
            System.out.println("teacher update success");
        courses = this.getAllCourses(courseMap,departments);
            System.out.println("courses update success");


        for(ClassDetail c:classDetails){
            Relation relation = new Relation();
            relation.setTeacherId(this.getTeacherID(teachers,c.getTeacherName()));
            relation.setCourseId(this.getCourseId(courses,c.getLesson()));
            relation.setBuildingName(c.getLocation());
            this.sectionHandle(c.getSections(),relation);
                relation.setId(this.relationWriteManage.insertRelationReturnId(relation));

                if(org.springframework.util.CollectionUtils.isEmpty(c.getClassNames()))
                    continue;
                for(String name:c.getClassNames()){
                    Integer id = this.getClassId(classes,name);
                    CRRel crRel = new CRRel();
                    crRel.setRelationId(relation.getId());
                    crRel.setClassId(id);
                    this.crRelWriteManage.insertCRRel(crRel);
                }

            }
            System.out.println("relation update success");
        }

        catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
        }
    }

    private List<Teacher> getAllTeachers(HashMap<String,Teacher> teacherMap)throws Exception{
       List<Teacher> teachers =  this.teacherReadManage.getTeacherByNames(new ArrayList<String>(teacherMap.keySet()));
       if(org.springframework.util.CollectionUtils.isEmpty(teachers)){
           for(String s:teacherMap.keySet()){
               teacherMap.get(s).setId(this.teacherWriteManage.insertTeacherReturnId(teacherMap.get(s)));
           }
       }else {
           for(String s:teacherMap.keySet()){
               boolean flag = false;
               for(Teacher t:teachers){
                   if(t.getName().equals(s)){
                       teacherMap.get(s).setId(t.getId());
                       flag=true;
                       break;
                   }

               }
               if(flag)
                   continue;
               teacherMap.get(s).setId(this.teacherWriteManage.insertTeacherReturnId(teacherMap.get(s)));
           }
       }
        return new ArrayList<Teacher>(teacherMap.values());
    }

    private List<Class> getAllClasses(List<String> classNames)throws Exception{
        List<Class> classes = this.classReadManage.getClassByNames(classNames);
        List<Class> newClasses = new ArrayList<Class>();
        for(String c:classNames){
            boolean flag = false;
            for(Class cl:classes){
                if(cl.getName().equals(c)){
                    flag = true;
                    break;
                }

            }
            if(flag)
                continue;
            Class cla= new Class();
            cla.setName(c);
            cla.setId(this.classWriteManage.insertClassReturnId(cla));
            newClasses.add(cla);
        }
        classes.addAll(newClasses);
        return classes;
    }

    private List<Department> getAllDepartments(List<String> departmentNames)throws Exception{
        List<Department> departments = this.departmentReadManage.getDepartmentsByNames(departmentNames);
        List<Department> newDepartments = new ArrayList<Department>();
        for(String ds:departmentNames){
            boolean flag = false;
            for(Department d:departments){
                if(d.getName().equals(ds)){
                    flag = true;
                    break;
                }


            }
            if(flag)
                continue;
            Department dnew = new Department();
            dnew.setName(ds);
            dnew.setId(this.departmentWriteManage.insertDepartmentReturnId(dnew));
            newDepartments.add(dnew);
        }
        departments.addAll(newDepartments);
        return departments;
    }

    private List<Course> getAllCourses(HashMap<String,Course> courseMap,List<Department> departments)throws Exception{
        List<Course> courses = this.courseReadManage.getCoursesByNames(new ArrayList<String>(courseMap.keySet()));

        for(String c:courseMap.keySet()){
            boolean flag = false;
            for(Department d:departments){
                if(((CourseEx)courseMap.get(c)).getDepartmentName().equals(d.getName())){
                    courseMap.get(c).setDepartmId(d.getId());
                }
            }
            for(Course course:courses){
                if(course.getName().equals(c)){
                    courseMap.get(c).setId(course.getId());
                    flag =true;
                    break;
                }

            }
            if(flag)
                continue;
            courseMap.get(c).setId(this.courseWriteManage.insertCourseReturnId(courseMap.get(c)));

        }

        return new ArrayList<Course>(courseMap.values());
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


    private Integer getClassId(List<Class> classes,String classNames){
        if(org.springframework.util.CollectionUtils.isEmpty(classes))
            return null;
        for(Class c:classes){
            if(c.getName().equals(classNames)){
                return c.getId();
            }
        }
        return null;
    }

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


    private String weekStringHandle(String weekInfo){
        String[] weekInfos = weekInfo.trim().split("/");
        String res;
        if(weekInfos.length!=2){
            logger.error("error weekinfo,weekInfo is "+weekInfo);
            return null;
        }
        res = weekInfos[0];
        if(HtmlConstant.SINGLE_WEEK.equals(weekInfos[1])){
            res+="-"+0;
        }else {
            res+="-"+1;
        }

        return res;
    }

    public void sectionHandle(String section,Relation relation){
        if(section==null)return;
        if(relation==null)return;
        try {
            Integer weekNo = Integer.parseInt(section.substring(0,1));
            relation.setWeekNo(weekNo);
            Integer lessonNo = section.length()-1;
            String lessonNoStr = "";
            char[] lessonChar = section.substring(1,section.length()).toCharArray();
            for(int i=0;i<=lessonNo/2;i+=2){
                Integer temp = Integer.parseInt(new String(new char[]{lessonChar[i],lessonChar[i+1]})) ;
                lessonNoStr = lessonNoStr+temp+"-";
            }
            relation.setLessonNo(lessonNoStr.substring(0,lessonNoStr.length()-1));
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
        }

    }



    public void setHtmlResolver(CsuHtmlResolver htmlResolver) {
        this.htmlResolver = htmlResolver;
    }
}
