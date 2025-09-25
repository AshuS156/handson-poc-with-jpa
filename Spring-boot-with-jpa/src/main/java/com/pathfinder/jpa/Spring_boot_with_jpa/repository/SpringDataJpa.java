package com.pathfinder.jpa.Spring_boot_with_jpa.repository;

import com.pathfinder.jpa.Spring_boot_with_jpa.beans.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringDataJpa extends JpaRepository<Course, Long>{

    Optional<Course> findById(Long id);

}
