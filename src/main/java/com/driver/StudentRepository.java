package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentRepository {
    Map<String,Student> studentMap = new HashMap<>();
    Map<String ,Teacher> teacherMap=new HashMap<>();
    Map<String, List<String>> teacherStudentList = new HashMap<>();
    List<String> studentTeacherList = new ArrayList<>();
    public void addStudentTeacher(String student, String teacher) {
        List<String> students = teacherStudentList.getOrDefault(teacher,new ArrayList<>());
        students.add(student);
        studentTeacherList.add(student);
        teacherStudentList.put(teacher,students);
    }

    public void deleteTeacher(String teacher) {
        List<String> studentList = teacherStudentList.getOrDefault(teacher,new ArrayList<>());
        for(String str:studentList){
            studentMap.remove(str);
        }
        teacherMap.remove(teacher);
        teacherStudentList.remove(teacher);
    }

    public void all() {
        for(String str: studentTeacherList){
            studentMap.remove(str);
        }
        this.teacherMap=null;
        this.teacherStudentList=null;
        this.studentTeacherList=null;
    }
}