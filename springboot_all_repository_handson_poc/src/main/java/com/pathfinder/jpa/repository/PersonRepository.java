package com.pathfinder.jpa.repository;

import com.pathfinder.jpa.bean.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{
}



/*
@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{
}
*/

/*
@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Long>{
}
*/

/*
@Repository
public interface PersonRepository extends ListPagingAndSortingRepository<Person, Long>{
}
*/


/*
@Repository
public interface PersonRepository extends ListCrudRepository<Person, Long>{
}
*/
