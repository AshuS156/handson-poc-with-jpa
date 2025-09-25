package com.pathfinder.jpa.repository;

import com.pathfinder.jpa.bean.Person;
import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonRepositoryWithQueryHints extends JpaRepository<Person, Long>{

    Person findByNameAndCity(String name,String city);

    Person findByNameContaining(String partialName);

    // named parameter query and more reliable and readable so better to use this
    @Query("SELECT p FROM Person p WHERE p.name LIKE %:partialName%") // ALL SQL keyword will be in CAPS for better readability
    @QueryHints({
            @QueryHint(name = "org.hibernate.readOnly", value = "true"),
            @QueryHint(name = "org.hibernate.cacheable", value = "true"),
            @QueryHint(name = "org.hibernate.timeout", value = "1000"),
            @QueryHint(name = "org.hibernate.fetchSize", value = "50"),
            @QueryHint(name = "javax.persistence.lock.timeout", value = "3000")

    })
    Person searchByPartialName(@Param("partialName") String partialName);

}


