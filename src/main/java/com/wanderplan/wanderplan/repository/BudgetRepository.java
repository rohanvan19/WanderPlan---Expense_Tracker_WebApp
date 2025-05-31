package com.wanderplan.wanderplan.repository;

import com.wanderplan.wanderplan.model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BudgetRepository extends JpaRepository<Budget, Long> {
}