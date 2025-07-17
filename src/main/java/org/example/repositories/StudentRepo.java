package org.example.repositories;

import jakarta.persistence.EntityManager;
import org.example.entities.Student;
import org.example.infras.javaUtil;

import java.util.List;

public class StudentRepo {
    private static final EntityManager em = javaUtil.getEntity();

    public static void saveStudent(Student student){
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
        em.close();
    }

    public static List<Student> getAllStudent(){
        return em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }

    public static void updateStudent(Student student){
        em.getTransaction().begin();
        em.merge(student);
        em.getTransaction().commit();
        em.close();
    }

   public static Student findStudentbyID (long id){
        return em.find(Student.class, id);
   }

   public static void deleteStudentById (long id){
        em.getTransaction().begin();
        em.remove(findStudentbyID(id));
        em.getTransaction().commit();
        em.close();
   }
}
