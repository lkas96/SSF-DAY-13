package sg.edu.nus.issq.vttp_day13_lecture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.issq.vttp_day13_lecture.model.Person;
import sg.edu.nus.issq.vttp_day13_lecture.repo.PersonRepo;

@Service
public class PersonService {

    @Autowired
    PersonRepo personRepo;

    public List<Person> findAll(){
        return personRepo.findAll();
    }

    public Boolean create(Person person){
        return personRepo.create(person);
    }

    public Boolean delete(Person person){
        return personRepo.delete(person);
    }

    public Boolean update(Person person){
        return personRepo.update(person);
    }

    public Person findById(String id){
        return personRepo.findById(id);
    }
    
}
