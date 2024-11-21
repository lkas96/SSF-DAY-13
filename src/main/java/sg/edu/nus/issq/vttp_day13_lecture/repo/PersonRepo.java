package sg.edu.nus.issq.vttp_day13_lecture.repo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import sg.edu.nus.issq.vttp_day13_lecture.model.Person;

@Repository
public class PersonRepo {

    private List<Person> persons = new ArrayList<>();

    public PersonRepo() throws ParseException {

        String birthDate = "1988-12-01";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = sdf.parse(birthDate);
        persons.add(new Person("Daniel", "Loo", 1800 ,"danielloo@ial.edu.sg", birthday, "98473624", 120430));
    }

    public List<Person> findAll() {
        return persons;
    }

    public Boolean create(Person person) {
        persons.add(person);
        return true;
    }

    public Boolean delete(Person person) {
        Integer arrayIndexOfPerson = persons.indexOf(person);
        if (arrayIndexOfPerson >= 0) {
            // Means this persons record is found and is present
            // Continue to delete
            persons.remove(person);
            return true;
        } else {
            // Person not found, no delete, return false
            return false;
        }
    }

    //Editing function
    //Take in a person id, filter and check to narrow down and select
    //If matching then edit and update whatever fields
    public Boolean update(Person person) {
        List<Person> filteredPerson = persons.stream().filter(p -> p.getId().equals(person.getId()))
                .collect(Collectors.toList());

        if (filteredPerson.size() > 0) {
            persons.remove(filteredPerson.getFirst());
            persons.add(person);
            return true;
        }

        return false;

    }

    public Person findById(String id){
        Person found = persons.stream().filter(p -> p.getId().equals(id)).findFirst().get();
        return found;
    }
}
