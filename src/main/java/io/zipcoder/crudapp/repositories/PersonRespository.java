package io.zipcoder.crudapp.repositories;

import io.zipcoder.crudapp.models.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRespository extends CrudRepository<Person, Integer> {
}
