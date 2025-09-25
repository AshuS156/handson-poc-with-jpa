package com.pathfinder.jpa.repository;

import com.pathfinder.jpa.bean.Person;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PaginationAndSortingRepo extends PagingAndSortingRepository<Person, Long>{
}
