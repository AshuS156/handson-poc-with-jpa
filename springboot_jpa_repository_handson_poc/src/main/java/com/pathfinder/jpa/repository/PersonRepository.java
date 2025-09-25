package com.pathfinder.jpa.repository;

import com.pathfinder.jpa.bean.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

    Person findByNameAndCity(String name,String city);

    Person findByNameContaining(String partialName);

    @Query("SELECT p FROM Person p WHERE p.name LIKE %:partialName%")
    Person searchByPartialName(String partialName);


}


