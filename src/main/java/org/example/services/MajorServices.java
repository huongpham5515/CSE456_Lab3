package org.example.services;

import org.example.entities.Major;
import org.example.repositories.MajorRepo;

import java.util.List;

public class MajorServices {
    public void createMajor(Major major) {
        MajorRepo.addMajor(major);
    }

    public void updateMajor(String id){
        MajorRepo.updateMajor(id);
    }

    public List<Major> getListMajor(){
        return MajorRepo.getAllMajor();
    }

    public Major getMajorById(String id){
        return MajorRepo.findMajorbyID(id);
    }

    public void deleteMajor(String id){
        MajorRepo.removeMajor(id);
    }
}
