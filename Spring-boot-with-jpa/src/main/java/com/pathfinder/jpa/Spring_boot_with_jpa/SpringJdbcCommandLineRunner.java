package com.pathfinder.jpa.Spring_boot_with_jpa;

import com.pathfinder.jpa.Spring_boot_with_jpa.beans.Course;
import com.pathfinder.jpa.Spring_boot_with_jpa.repository.JPARepository;
import com.pathfinder.jpa.Spring_boot_with_jpa.repository.SpringDataJpa;
import com.pathfinder.jpa.Spring_boot_with_jpa.repository.SpringJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SpringJdbcCommandLineRunner implements CommandLineRunner{

    //@Autowired
    //SpringJdbcRepository repository;

  /*  @Autowired
    JPARepository  repository;*/

    @Autowired
    SpringDataJpa repository;
    @Override
    public void run(String... args) throws Exception{

       /* repository.insert(new Course(1L, "Learn AWS", "in28Minutes"));
        repository.insert(new Course(2L, "Learn Azure", "in28Minutes"));
        repository.insert(new Course(3L, "Learn DevOps", "in28Minutes"));*/

        repository.save(new Course(1L, "Learn AWS", "in28Minutes"));
        repository.save(new Course(2L, "Learn Azure", "in28Minutes"));
        repository.save(new Course(3L, "Learn DevOps", "in28Minutes"));

        System.out.println(repository.findById(1L));
        System.out.println(repository.findById(2L));
        System.out.println(repository.findById(3L));

    }
}
