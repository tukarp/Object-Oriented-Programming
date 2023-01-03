package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@Controller
public class PersonController {
    @GetMapping("/person")
    public String get(Model model){
        try {
            List<Person> result = Person.selectAll();
            model.addAttribute("people", result);
            model.addAttribute("newPerson",new Person());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "person.html";
    }

    @PostMapping("/add_person")

    public String add(@ModelAttribute Person person){
        try {
            Person.insertPerson(person.getFirstName(), person.getLastName());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "redirect:/person";
    }
}