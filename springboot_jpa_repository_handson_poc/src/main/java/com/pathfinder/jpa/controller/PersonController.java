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
    public ResponseEntity<Person> getPersonById(@PathVariable Long id){
        Person person = personService.getPersonById(id);
        if(person == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(person);
    }

    @GetMapping("/person/QueryMethod/{partialName}")
    public ResponseEntity<Person> getPersonByPartialName(@PathVariable String partialName){
        Person person = personService.getPersonByPartialNameUsingQueryMethod(partialName);
        if(person == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(person);
    }

    @GetMapping("/person/QueryAnnotation/{partialName}")
    public ResponseEntity<Person> getPersonByPartialNameUsingQueryAnnotation(@PathVariable String partialName){
        Person person = personService.getPersonByPartialNameUsingQueryAnnotation(partialName);
        if(person == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(person);
    }

    @GetMapping("/person/{name}/{city}")
    public ResponseEntity<Person> getPersonByMultipleParameter(@PathVariable String name, @PathVariable String city){
        Person person = personService.getPersonByNameAndCity(name, city);
        if(person == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(person);
    }

    @GetMapping("/person")
    public ResponseEntity<?> getPersonByMultipleParameter(@RequestParam(value = "page") int page , @RequestParam(value = "size") int size ){
        final Page<Person> persons = personService.getPersons(page,size);
        if(persons == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(persons);
    }

}
