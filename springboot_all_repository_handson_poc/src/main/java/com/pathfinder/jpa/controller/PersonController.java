package com.pathfinder.jpa.controller;

import com.pathfinder.jpa.bean.Person;
import com.pathfinder.jpa.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController{

    @Autowired
    private PersonService personService;

    @PostMapping("/person/save")
    public ResponseEntity<Person> savePerson(@RequestBody Person person){
        personService.savePerson(person);
        return ResponseEntity.ok(person);
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Long id){
        Person person = personService.getPerson(id);
        if(person == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(person);
    }

    @DeleteMapping("/person/delete/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id){
        personService.deletePerson(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/person/{page}/{size}")
    public ResponseEntity<?> getPersonUsingPaginationAndSorting(@PathVariable int page, @PathVariable int size){
        final Page<Person> personUsingPagination = personService.getPersonUsingPagination(page,size);
        return ResponseEntity.ok().body(personUsingPagination);
    }
}
