package org.example;

import org.example.entities.Gender;
import org.example.entities.Major;
import org.example.entities.School;
import org.example.entities.Student;
import org.example.services.MajorServices;
import org.example.services.SchoolServices;
import org.example.services.StudentServices;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Major cse = new Major("CSE", "Software Engineer");
        Major csi = new Major("CSI", "Computer Science");

        School cseSchool = new School("CIT","Computer Science", "Hanoi");

        Student s1 = new Student("John Doe", Gender.MALE, LocalDate.parse("1990-05-15"), 3.9, 2013);
        Student s2 = new Student("Anna Taylor", Gender.FEMALE, LocalDate.parse("1990-08-01"), 3.6, 2013);
        Student s3 = new Student("Armand", Gender.MALE, LocalDate.parse("1990-11-24"), 3.7, 2013);
        Student s4 = new Student("Donna", Gender.FEMALE, LocalDate.parse("1990-12-06"), 3.81, 2013);

        cseSchool.addMajor(cse);
        cseSchool.addMajor(csi);
        cseSchool.addStudent(s1);
        cseSchool.addStudent(s2);
        cseSchool.addStudent(s3);
        cseSchool.addStudent(s4);
        cse.addStudent(s1);
        cse.addStudent(s2);
        csi.addStudent(s3);
        csi.addStudent(s4);

        SchoolServices ss = new SchoolServices();
        ss.createSchool(cseSchool);

        MajorServices ms = new MajorServices();
        csi.setName("Computer Science and Engineering");
        ms.updateMajor(csi);

        for(Major m : ms.getListMajor()){
            System.out.println(m.toString());
        }
        ms.getMajorById("CSI");
    }
}