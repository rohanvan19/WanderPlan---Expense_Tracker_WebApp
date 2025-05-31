package com.wanderplan.wanderplan.repository;

import com.wanderplan.wanderplan.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
