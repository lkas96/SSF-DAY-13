package sg.edu.nus.issq.vttp_day13_lecture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import sg.edu.nus.issq.vttp_day13_lecture.model.Person;
import sg.edu.nus.issq.vttp_day13_lecture.service.PersonService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping()
    public String personListing(Model model) {

        List<Person> persons = personService.findAll();
        model.addAttribute("persons", persons);
        return "personlist";
    }

    @GetMapping(path = "/create")
    public String createForm(Model model) {
        Person p = new Person();
        model.addAttribute("person", p);
        return "personcreate";
    }

    @PostMapping("/create")
    public String postCreateForm(@Valid @ModelAttribute("person") Person person, BindingResult result, Model model) {

        if (result.hasErrors())
            return "personcreate";

        Person p = new Person(person.getFirstName(), person.getLastName(), person.getSalary(), person.getEmail(),
                person.getDateOfBirth(), person.getTelephone(), person.getPostalCode());

        personService.create(p);

        return "redirect:/persons";
    }

    @GetMapping("/delete/{person-id}")
    public String deletePerson(@PathVariable("person-id") String personId) {

        // Find the person and delete
        Person p = personService.findById(personId);
        personService.delete(p);

        return "redirect:/persons";
    }

    @GetMapping(path = "/update/{person-id}")
    public String updateForm(@PathVariable("person-id") String personId, Model model) {
        Person p = personService.findById(personId);
        model.addAttribute("person", p);
        return "personupdate";
    }

    @PostMapping("/update")
    public String postUpdateForm(@Valid @ModelAttribute("person") Person person, BindingResult result, Model model) {

        if (result.hasErrors())
            return "personupdate";
        
        personService.update(person);

        return "redirect:/persons";
    }

}