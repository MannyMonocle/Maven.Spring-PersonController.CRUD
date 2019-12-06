package io.zipcoder.crudapp.controllers;
import io.zipcoder.crudapp.models.Person;
import io.zipcoder.crudapp.repositories.PersonRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    private PersonRespository respository;

    @Autowired
    public PersonController(PersonRespository r){this.respository = r;}

    @PostMapping("/people")
    public Person createPerson(Person p){ return respository.save(p); }

    @GetMapping("/people/{id}")
    public Person getPerson(@PathVariable int id){ return respository.findOne(id); }

    @GetMapping("/people")
    public List<Person> getPersonList(){ return (List<Person>)respository.findAll(); }

    @PutMapping("/people/{id}")
    public Person updatePerson(@PathVariable int id, Person person){

        Person oldGuy = respository.findOne(id);
        oldGuy.setFirstName(person.getFirstName());
        oldGuy.setLastName(person.getLastName());
        return respository.save(oldGuy); }

    @DeleteMapping("/people/{id}")
    public void deletePerson(@PathVariable int id){ }

}
