package com.wanderplan.wanderplan.controller;

import com.wanderplan.wanderplan.model.Budget;
import com.wanderplan.wanderplan.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/budgets")
public class BudgetController {

    @Autowired
    private BudgetService budgetService;

    @GetMapping
    public String listBudgets(Model model) {
        List<Budget> budgets = budgetService.getAllBudgets();
        model.addAttribute("budgets", budgets);
        return "budget/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("budget", new Budget());
        return "budget/form";
    }

    @PostMapping
    public String createBudget(@ModelAttribute Budget budget) {
        budgetService.createBudget(budget);
        return "redirect:/budgets";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Budget budget = budgetService.getBudgetById(id);
        model.addAttribute("budget", budget);
        return "budget/form";
    }

    @PostMapping("/update/{id}")
    public String updateBudget(@PathVariable Long id, @ModelAttribute Budget budget) {
        budgetService.updateBudget(id, budget);
        return "redirect:/budgets";
    }

    @GetMapping("/delete/{id}")
    public String deleteBudget(@PathVariable Long id) {
        budgetService.deleteBudget(id);
        return "redirect:/budgets";
    }
}
