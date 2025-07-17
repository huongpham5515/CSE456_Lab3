package org.example.repositories;

import jakarta.persistence.EntityManager;
import org.example.entities.School;
import org.example.infras.javaUtil;

import java.util.List;

public class SchoolRepo {
    private static final EntityManager em = javaUtil.getEntity();

    public static void addSchool(School school){
        em.getTransaction().begin();
        em.persist(school);
        em.getTransaction().commit();
        em.close();
    }

    public static void updateSchool(School school){
        em.getTransaction().begin();
        em.merge(school);
        em.getTransaction().commit();
        em.close();
    }

    public static School findSchoolbyID(String id){
        return em.find(School.class, id);
    }

    public static List<School> getAllSchool(){
        return em.createQuery("SELECT s FROM School s", School.class).getResultList();
    }

    public static void removeSchool(String id){
        em.getTransaction().begin();
        em.remove(findSchoolbyID(id));
        em.getTransaction().commit();
        em.close();
    }
}
