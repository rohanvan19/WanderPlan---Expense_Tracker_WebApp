package com.wanderplan.wanderplan.dto;

import com.wanderplan.wanderplan.model.Expense;

import java.time.LocalDate;

public class ExpenseDTO {

    private Long id;
    private String category;
    private double amount;
    private String description;
    private LocalDate expenseDate;
    private Long userId;
    private String userName;  // New field added

    public ExpenseDTO() {
        // Default constructor for form binding
    }

    public ExpenseDTO(Expense expense) {
        this.id = expense.getId();
        this.category = expense.getCategory();
        this.amount = expense.getAmount();
        this.description = expense.getDescription();
        this.expenseDate = expense.getExpenseDate();
        this.userId = expense.getUser().getUserId();
        this.userName = expense.getUser().getName();  // Populate userName here
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(LocalDate expenseDate) {
        this.expenseDate = expenseDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {  // New getter
        return userName;
    }

    public void setUserName(String userName) {  // New setter
        this.userName = userName;
    }
}
