
package com.wanderplan.wanderplan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class HomeController {

    // Map root URL "/" and "/index" to the index.html Thymeleaf template
    @GetMapping({"/"})
    public String index() {
        return "index";  // This resolves to src/main/resources/templates/index.html
    }

//    // Budgets
//    @GetMapping("/budgets")
//    public String budgetsList() {
//        return "budget/list";  // templates/budget/list.html
//    }
//
//    @GetMapping("/budgets/new")
//    public String budgetForm() {
//        return "budget/form";  // templates/budget/form.html for creating new budget
//    }
//
//    @GetMapping("/budgets/edit/{id}")
//    public String budgetFormEdit(@PathVariable("id") Long id) {
//        // Add logic here to load budget by id and pass to the form if needed
//        return "budget/form";  // templates/budget/form.html for editing existing budget
//    }
//
//    // Trips
//    @GetMapping("/trips")
//    public String tripsList() {
//        return "trip/list";
//    }
//
//    @GetMapping("/trips/new")
//    public String tripForm() {
//        return "trip/form";
//    }
//
//    @GetMapping("/trips/edit/{id}")
//    public String tripFormEdit(@PathVariable("id") Long id) {
//        return "trip/form";
//    }
//
//    // Expenses
//    @GetMapping("/expenses")
//    public String expensesList() {
//        return "expense/list";
//    }
//
//    @GetMapping("/expenses/new")
//    public String expenseForm() {
//        return "expense/form";
//    }
//
//    @GetMapping("/expenses/edit/{id}")
//    public String expenseFormEdit(@PathVariable("id") Long id) {
//        return "expense/form";
//    }
//
//    // Destinations
//    @GetMapping("/destinations")
//    public String destinationsList() {
//        return "destination/list";
//    }
//
//    @GetMapping("/destinations/new")
//    public String destinationForm() {
//        return "destination/form";
//    }
//
//    @GetMapping("/destinations/edit/{id}")
//    public String destinationFormEdit(@PathVariable("id") Long id) {
//        return "destination/form";
//    }
//
//    // Users
//    @GetMapping("/users")
//    public String usersList() {
//        return "user/list";
//    }
//
//    @GetMapping("/users/new")
//    public String userForm() {
//        return "user/form";
//    }
//
//    @GetMapping("/users/edit/{id}")
//    public String userFormEdit(@PathVariable("id") Long id) {
//        return "user/form";
//    }

}
