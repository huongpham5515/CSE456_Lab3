package org.example.repositories;

import jakarta.persistence.EntityManager;
import org.example.entities.Student;
import org.example.infras.javaUtil;

import java.util.List;

public class StudentRepo {

    public static void saveStudent(Student student){
        EntityManager em = javaUtil.getEntity();
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
        em.close();
    }

    public static List<Student> getAllStudent(){
        EntityManager em = javaUtil.getEntity();
        return em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }

    public static void updateStudent(Student student){
        EntityManager em = javaUtil.getEntity();
        em.getTransaction().begin();
        em.merge(student);
        em.getTransaction().commit();
        em.close();
    }

   public static Student findStudentbyID (long id){
       EntityManager em = javaUtil.getEntity();
        return em.find(Student.class, id);
   }

   public static void deleteStudentById (long id){
       EntityManager em = javaUtil.getEntity();
        em.getTransaction().begin();
       Student student = em.find(Student.class, id);
       if (student != null) {
           em.remove(student);
       }
        em.getTransaction().commit();
        em.close();
   }
}
