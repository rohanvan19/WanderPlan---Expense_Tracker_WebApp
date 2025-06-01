
package com.wanderplan.wanderplan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.wanderplan.wanderplan.service.ExpenseService;
import com.wanderplan.wanderplan.service.TripService;
import com.wanderplan.wanderplan.service.DestinationService;
import com.wanderplan.wanderplan.service.BudgetService;
import com.wanderplan.wanderplan.service.UserService;
import org.springframework.ui.Model;

@Controller
public class HomeController {

    @Autowired
    private TripService tripService;
    @Autowired
    private ExpenseService expenseService;
    @Autowired
    private DestinationService destinationService;
    @Autowired
    private BudgetService budgetService;
    @Autowired
    private UserService userService;

    // Map root URL "/" and "/index" to the index.html Thymeleaf template
//    @GetMapping({"/"})
//    public String index() {
//        return "index";  // This resolves to src/main/resources/templates/index.html
//    }
    @GetMapping("/")
    public String dashboard(Model model) {
        model.addAttribute("userCount", userService.countUsers());
        model.addAttribute("tripCount", tripService.countTrips());
        model.addAttribute("expenseTotal", expenseService.getTotalExpenses());
        model.addAttribute("destinationCount", destinationService.countDestinations());
        model.addAttribute("budgetTotal", budgetService.totalBudgets());
        return "index"; // or "home" based on your file name
    }

}
