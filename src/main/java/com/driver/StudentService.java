package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public void addStudent(Student student) {
        studentRepository.studentMap.put(student.getName(),student);
    }

    public void addTeacher(Teacher teacher) {
        studentRepository.teacherMap.put(teacher.getName(),teacher);
    }

    public void addStudentTeacher(String student, String teacher) {
        studentRepository.addStudentTeacher(student,teacher);
    }

    public List<String> getAllStudent() {
        return studentRepository.sut();
    }

    public void deleteTeacher(String teacher) {
        studentRepository.deleteTeacher(teacher);
    }

    public void all() {
        studentRepository.all();
    }
}