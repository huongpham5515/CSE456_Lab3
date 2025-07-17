package org.example.repositories;

import jakarta.persistence.EntityManager;
import org.example.entities.School;
import org.example.infras.javaUtil;

import java.util.List;

public class SchoolRepo {

    public static void addSchool(School school){
        EntityManager em = javaUtil.getEntity();
        em.getTransaction().begin();
        em.persist(school);
        em.getTransaction().commit();
        em.close();
    }

    public static void updateSchool(School school){
        EntityManager em = javaUtil.getEntity();
        em.getTransaction().begin();
        em.merge(school);
        em.getTransaction().commit();
        em.close();
    }

    public static School findSchoolbyID(String id){
        EntityManager em = javaUtil.getEntity();
        return em.find(School.class, id);
    }

    public static List<School> getAllSchool(){
        EntityManager em = javaUtil.getEntity();
        return em.createQuery("SELECT s FROM School s", School.class).getResultList();
    }

    public static void removeSchool(String id){
        EntityManager em = javaUtil.getEntity();
        em.getTransaction().begin();
        School school = em.find(School.class, id);
        if (school != null) {
            em.remove(school);
        }
        em.getTransaction().commit();
        em.close();
    }
}
