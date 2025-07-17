package org.example.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studentID")
    private long ID;
    @Column(name = "FullName",columnDefinition = "VARCHAR(100)", nullable = false)
    private String fullName;
    @Column(name = "Gender")
    private Gender gender;
    @Column(name = "Birthday")
    private Date dateOfBirth;
    @Column(name = "GPA")
    private double gpa;
    @Column(name = "EnrollmentYear")
    private int enrollmentYear;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MajorID")
    private Major major;
    @ManyToOne(fetch =  FetchType.EAGER)
    @JoinColumn(name = "SchoolID")
    private School school;

    public Student(String fullName, Gender gender, Date dateOfBirth, double gpa, int enrollmentYear) {
        this.fullName = fullName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.gpa = gpa;
        this.enrollmentYear = enrollmentYear;
    }
}
