package com.wanderplan.wanderplan.service;

import com.wanderplan.wanderplan.model.Budget;
import com.wanderplan.wanderplan.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetService {

    @Autowired
    private BudgetRepository budgetRepository;

    public List<Budget> getAllBudgets() {
        return budgetRepository.findAll();
    }

    public Budget getBudgetById(Long id) {
        return budgetRepository.findById(id).orElse(null);
    }

    public Budget createBudget(Budget budget) {
        return budgetRepository.save(budget);
    }

    public Budget updateBudget(Long id, Budget updatedBudget) {
        return budgetRepository.findById(id).map(budget -> {
            budget.setAmount(updatedBudget.getAmount());
            budget.setMonth(updatedBudget.getMonth());
            budget.setUser(updatedBudget.getUser());
            return budgetRepository.save(budget);
        }).orElse(null);
    }

    public void deleteBudget(Long id) {
        budgetRepository.deleteById(id);
    }

    public long countBudgets() {
        return budgetRepository.count();
    }
}
