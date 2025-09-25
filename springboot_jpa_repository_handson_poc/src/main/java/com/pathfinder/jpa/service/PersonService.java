package com.pathfinder.jpa.service;

import com.pathfinder.jpa.bean.Person;
import com.pathfinder.jpa.repository.PaginationAndSortingRepo;
import com.pathfinder.jpa.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class PersonService{

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PaginationAndSortingRepo paginationAndSortingRepo;

    public void savePerson(Person person){
        personRepository.save(person);
    }

    public Person getPerson(Long id){
        return personRepository.findById(id).orElse(null);
        //return personRepository.findById(id).orElseThrow(() -> new RuntimeException("Person not found with id: " + id));
    }

    public void deletePerson(Long id){
        final Person person = personRepository.findById(id).orElseThrow(() -> new RuntimeException("Person not found with id: " + id));
        personRepository.deleteById(person.getPersonId());
    }

    public Page<Person>  getPersonUsingPagination(int page, int size){
        final Page<Person> personPageList = paginationAndSortingRepo.findAll(PageRequest.of(page, size));
        return personPageList;
    }

}
