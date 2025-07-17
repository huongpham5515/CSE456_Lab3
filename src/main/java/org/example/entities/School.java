package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Schools")
@ToString
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SchoolId")
    private String ID;
    @Column(name = "SchoolName", nullable = false)
    private String schoolName;
    @Column(name = "Location")
    private String location;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "school")
//    @JoinColumn(name = "SchoolID")
    private List<Major> majors = new ArrayList<>();
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "school")
//    @JoinColumn(name = "SchoolID")
    private List<Student> students = new ArrayList<>();
    public School(String schoolName, String location) {
        this.schoolName = schoolName;
        this.location = location;
    }

    public void addStudent(Student student) {
        students.add(student);
        student.setSchool(this);
    }
    public void addMajor(Major major){
        majors.add(major);
        major.setSchool(this);
    }
}
