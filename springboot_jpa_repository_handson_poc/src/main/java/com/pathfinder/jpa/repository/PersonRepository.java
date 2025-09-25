package com.pathfinder.jpa.repository;

import com.pathfinder.jpa.bean.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;


@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

    Person findByNameAndCity(String name,String city);

    Person findByNameContaining(String partialName);

    // positioned  parameter query and less reliable and readable
    @Query("SELECT p FROM Person p WHERE p.name LIKE %:partialName%")
    Person searchByPartialName22(String partialName);


    // named parameter query and more reliable and readable so better to use this
    @Query("SELECT p FROM Person p WHERE p.name LIKE %:partialName%") // ALL SQL keyword will be in CAPS for better readability
    Person searchByPartialName(@Param("partialName") String partialName);

    // query method different usecase examples
/*
    Person findByStatusOrderByNameAsc(String status);
    Person findByStatusOrderByName(String status);
    Person findByStatusOrderByNameDesc(String status);
    Person findByNameStartingWith(String prefix);
    Person findByNameEndingWith(String suffix);
    Person findByNameIsNull();
    Person findByNameIsNotNull();
    Person findByNameIn(String[] names);
    Person findByNameNotIn(String[] names);
    Person findByAgeBetween(int startAge, int endAge);
    Person findByAgeLessThan(int age);
    Person findByAgeGreaterThan(int age);
    Person findByNameIgnoreCase(String name);
    Person findTop3ByStatus(String status);
    Person findFirst5ByStatus(String status);
    long countByStatus(String status);
    boolean existsByName(String name);
    void deleteByName(String name);
    void deleteByStatus(String status);
    void deleteByAgeLessThan(int age);
    void deleteByAgeGreaterThan(int age);
    void deleteByNameIn(String[] names);
    void deleteByNameNotIn(String[] names);
    void deleteByNameIsNull();
    void deleteByNameIsNotNull();
    void deleteByStatusOrderByNameAsc(String status);
    void deleteByStatusOrderByNameDesc(String status);
    void deleteByNameStartingWith(String prefix);
    void deleteByNameEndingWith(String suffix);
    void deleteByAgeBetween(int startAge, int endAge);
    void deleteByNameIgnoreCase(String name);
    void deleteByStatusAndAgeLessThan(String status, int age);
    void deleteByStatusAndAgeGreaterThan(String status, int age);
    void deleteByStatusAndAgeBetween(String status, int startAge, int endAge);
    void deleteByStatusOrAgeLessThan(String status, int age);
    void deleteByStatusOrAgeGreaterThan(String status, int age);
    void deleteByStatusOrAgeBetween(String status, int startAge, int endAge);
    void deleteByStatusAndNameContaining(String status, String partialName);
    void deleteByStatusOrNameContaining(String status, String partialName);
    void deleteByStatusAndNameStartingWith(String status, String prefix);
    void deleteByStatusOrNameStartingWith(String status, String prefix);
    void deleteByStatusAndNameEndingWith(String status, String suffix);
    void deleteByStatusOrNameEndingWith(String status, String suffix);
    void deleteByStatusAndNameIsNull(String status);
    void deleteByStatusOrNameIsNull(String status);
    void deleteByStatusAndNameIsNotNull(String status);
    void deleteByStatusOrNameIsNotNull(String status);
    void deleteByStatusAndNameIn(String status, String[] names);
    void deleteByStatusOrNameIn(String status, String[] names);
    void deleteByStatusAndNameNotIn(String status, String[] names);
    void deleteByStatusOrNameNotIn(String status, String[] names);*/


}


