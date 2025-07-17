package org.example.services;

import org.example.entities.Student;
import org.example.repositories.StudentRepo;

import java.util.List;

public class StudentServices {
    public void createStudent(Student student) {
        StudentRepo.saveStudent(student);
    }

    public void updateStudent(long id){
        StudentRepo.updateStudent(id);
    }

    public List<Student> getListStudent(){
       return StudentRepo.getAllStudent();
    }

    public Student getStudentById(long id){
        return StudentRepo.findStudentbyID(id);
    }

    public void deleteStudent(long id){
        StudentRepo.deleteStudentById(id);
    }
}
