package org.example.repositories;

import jakarta.persistence.EntityManager;
import org.example.entities.Major;
import org.example.infras.javaUtil;

import java.util.List;

public class MajorRepo {

    public static void addMajor(Major major){
        EntityManager em = javaUtil.getEntity();
        em.getTransaction().begin();
        em.persist(major);
        em.getTransaction().commit();
        em.close();
    }

    public static void updateMajor(Major major){
        EntityManager em = javaUtil.getEntity();
        em.getTransaction().begin();
        em.merge(major);
        em.getTransaction().commit();
        em.close();
    }

    public static Major findMajorbyID(String id){
        EntityManager em = javaUtil.getEntity();
        return em.find(Major.class, id);
    }

    public static List<Major> getAllMajor(){
        EntityManager em = javaUtil.getEntity();
        return em.createQuery("SELECT s FROM Major s", Major.class).getResultList();
    }

    public static void removeMajor(String id){
        EntityManager em = javaUtil.getEntity();
        em.getTransaction().begin();
        Major major = em.find(Major.class, id);
        if (major != null) {
            em.remove(major);
        }
        em.getTransaction().commit();
        em.close();
    }
}
