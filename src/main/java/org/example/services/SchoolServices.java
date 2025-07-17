package org.example.services;

import org.example.entities.School;
import org.example.entities.Student;
import org.example.repositories.SchoolRepo;
import org.example.repositories.StudentRepo;

import java.util.List;

public class SchoolServices {
    public void createSchool(School school) {
        SchoolRepo.addSchool(school);
    }

    public void updateSchool(School school){
        SchoolRepo.updateSchool(school);
    }

    public List<School> getListSchool(){
        return SchoolRepo.getAllSchool();
    }

    public School getSchoolById(String id){
        return SchoolRepo.findSchoolbyID(id);
    }

    public void deleteSchool(String id){
       SchoolRepo.removeSchool(id);
    }

}
