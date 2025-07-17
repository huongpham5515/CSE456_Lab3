package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "majors")
@NoArgsConstructor
@ToString(exclude = {"students", "school"})
public class Major {
    @Id
    @Column(name = "MajorID")
    private String ID;
    @Column(name = "MajorName", nullable = false)
    private String name;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "major")
    private List<Student> students = new ArrayList<>();
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SchoolID")
    private School school;

    public Major(String ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public void addStudent(Student student){
        students.add(student);
        student.setMajor(this);
    }
}
