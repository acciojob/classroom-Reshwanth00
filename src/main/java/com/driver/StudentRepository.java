package com.driver;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public class StudentRepository {
    private HashMap<String, Student> studentMap;
    private HashMap<String, Teacher> teacherMap;
    private HashMap<String, List<String>> teacherStudentMapping;
    public StudentRepository(){
        this.studentMap = new HashMap<String, Student>();
        this.teacherMap = new HashMap<String, Teacher>();
        this.teacherStudentMapping = new HashMap<String, List<String>>();
    }
    public void saveStudent(Student student){
        studentMap.put(student.getName(), student);
    }
    public void saveTeacher(Teacher teacher){
        teacherMap.put(teacher.getName(), teacher);
    }
    public void saveStudentTeacherPair(String movie, String director){
        if(studentMap.containsKey(movie)&&teacherMap.containsKey(director)){
            List<String> currentMoviesByDirector = new ArrayList<>();
            if(teacherStudentMapping.containsKey(director))
                currentMoviesByDirector = teacherStudentMapping.get(director);
            currentMoviesByDirector.add(movie);
            teacherStudentMapping.put(director,currentMoviesByDirector);
        }
    }
    public Student findStudent(String student){
        return studentMap.get(student);
    }
    public Teacher findTeacher(String teacher){
        return teacherMap.get(teacher);
    }
    public List<String> findStudentFromTeacher(String director){
        List<String> moviesList = new ArrayList<String>();
        if(teacherStudentMapping.containsKey(director)) moviesList = teacherStudentMapping.get(director);
        return moviesList;
    }
    public List<String> findAllStudents(){
        return new ArrayList<>(studentMap.keySet());
    }
    public void deleteTeacher(String teacher){

        List<String> students = new ArrayList<String>();
        if(teacherStudentMapping.containsKey(teacher)){
            students = teacherStudentMapping.get(teacher);
            for(String student: students){
                if(studentMap.containsKey(student)){
                    studentMap.remove(student);
                }
            }
            teacherStudentMapping.remove(teacher);
        }
        if(teacherMap.containsKey(teacher)){
            teacherMap.remove(teacher);
        }
    }
    public void deleteAllTeacher(){
        HashSet<String> studentSet = new HashSet<String>();
        teacherMap = new HashMap<>();
        for(String teacher: teacherStudentMapping.keySet()){
            for(String student: teacherStudentMapping.get(teacher)){
                studentSet.add(student);
            }
        }
        for(String student: studentSet){
            if(studentMap.containsKey(student)){
                studentMap.remove(student);
            }
        }
        teacherStudentMapping = new HashMap<>();
    }
}
