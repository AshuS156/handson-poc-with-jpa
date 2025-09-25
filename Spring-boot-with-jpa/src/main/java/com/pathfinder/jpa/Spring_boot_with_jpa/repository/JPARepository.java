package com.pathfinder.jpa.Spring_boot_with_jpa.repository;

import com.pathfinder.jpa.Spring_boot_with_jpa.beans.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class JPARepository{

    @PersistenceContext
    EntityManager entityManager;

    public void insert(Course entity){
        entityManager.persist(entity);
    }

    public Course findById(Long id){
        final Course course = entityManager.find(Course.class,id);
        System.out.println("course : " +course);
        return course;
    }
}
