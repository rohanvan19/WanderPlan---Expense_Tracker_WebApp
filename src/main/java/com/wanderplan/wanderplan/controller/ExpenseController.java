package com.wanderplan.wanderplan.controller;

import com.wanderplan.wanderplan.dto.ExpenseDTO;
import com.wanderplan.wanderplan.model.Expense;
import com.wanderplan.wanderplan.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping
    public String listExpenses(Model model) {
        List<ExpenseDTO> expenses = expenseService.getAllExpenses().stream()
                .map(expenseService::convertToDTO)
                .collect(Collectors.toList());
        model.addAttribute("expenses", expenses);
        return "expense/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("expense", new ExpenseDTO());
        return "expense/form";
    }

    @PostMapping
    public String createExpense(@ModelAttribute ExpenseDTO expenseDTO) {
        expenseService.createExpense(expenseDTO);
        return "redirect:/expenses";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Expense expense = expenseService.getExpenseById(id);
        ExpenseDTO expenseDTO = expenseService.convertToDTO(expense);
        model.addAttribute("expense", expenseDTO);
        return "expense/form";
    }

    @PostMapping("/update/{id}")
    public String updateExpense(@PathVariable Long id, @ModelAttribute ExpenseDTO expenseDTO) {
        expenseService.updateExpense(id, expenseDTO);
        return "redirect:/expenses";
    }

    @GetMapping("/delete/{id}")
    public String deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
        return "redirect:/expenses";
    }
}

