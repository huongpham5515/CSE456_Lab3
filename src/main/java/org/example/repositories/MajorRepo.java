package org.example.repositories;

import jakarta.persistence.EntityManager;
import org.example.entities.Major;
import org.example.infras.javaUtil;

import java.util.List;

public class MajorRepo {
    private static final EntityManager em = javaUtil.getEntity();

    public static void addMajor(Major major){
        em.getTransaction().begin();
        em.persist(major);
        em.getTransaction().commit();
        em.close();
    }

    public static void updateMajor(String id){
        em.getTransaction().begin();
        em.merge(findMajorbyID(id));
        em.getTransaction().commit();
        em.close();
    }

    public static Major findMajorbyID(String id){
        return em.find(Major.class, id);
    }

    public static List<Major> getAllMajor(){
        return em.createQuery("SELECT s FROM Major s", Major.class).getResultList();
    }

    public static void removeMajor(String id){
        em.getTransaction().begin();
        em.remove(findMajorbyID(id));
        em.getTransaction().commit();
        em.close();
    }
}
