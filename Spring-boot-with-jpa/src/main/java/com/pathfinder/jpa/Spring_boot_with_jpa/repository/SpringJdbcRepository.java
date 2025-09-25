package com.pathfinder.jpa.Spring_boot_with_jpa.repository;

import com.pathfinder.jpa.Spring_boot_with_jpa.beans.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SpringJdbcRepository{

    @Autowired
    JdbcTemplate springJdbcTemplate;

    private String INSERT_QUERY = """
            insert into course (id, name, author)
        values(?, ?, ?)
        """;
    private String SELECT_QUERY = """
            select * from course where id = ?
        """;
    public int insert(Long id, String name, String author){
        return springJdbcTemplate.update(INSERT_QUERY, id, name, author);
    }

    public Course findById(Long id){
        final Course course = springJdbcTemplate.queryForObject(SELECT_QUERY,new BeanPropertyRowMapper<>(Course.class),id);
        System.out.println("course : " +course);
        return course;
    }
}
