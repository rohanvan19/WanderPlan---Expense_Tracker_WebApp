//package com.wanderplan.wanderplan.service;
//
//import com.wanderplan.wanderplan.dto.ExpenseDTO;
//import com.wanderplan.wanderplan.model.Expense;
//import com.wanderplan.wanderplan.model.User;
//import com.wanderplan.wanderplan.repository.ExpenseRepository;
//import com.wanderplan.wanderplan.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class ExpenseService {
//
//    @Autowired
//    private ExpenseRepository expenseRepository;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    public List<Expense> getAllExpenses() {
//        return expenseRepository.findAll();
//    }
//
//    public Expense getExpenseById(Long id) {
//        return expenseRepository.findById(id).orElse(null);
//    }
//
//    public Expense createExpense(Expense expense) {
//        return expenseRepository.save(expense);
//    }
//
//    public Expense createExpenseForUser(Long userId, Expense expense) {
//        User user = userRepository.findById(userId).orElse(null);
//        if (user == null) return null;
//        expense.setUser(user);
//        return expenseRepository.save(expense);
//    }
//
//    public Expense updateExpense(Long id, Expense updatedExpense) {
//        Expense expense = expenseRepository.findById(id).orElse(null);
//        if (expense != null) {
//            expense.setAmount(updatedExpense.getAmount());
//            expense.setDescription(updatedExpense.getDescription());
//            expense.setUser(updatedExpense.getUser());
//            expense.setCategory(updatedExpense.getCategory());
//            expense.setExpenseDate(updatedExpense.getExpenseDate());
//            return expenseRepository.save(expense);
//        }
//        return null;
//    }
//
//    public void deleteExpense(Long id) {
//        expenseRepository.deleteById(id);
//    }
//
//    // Add this method to convert Expense entity to DTO
//    public ExpenseDTO convertToDTO(Expense expense) {
//        if (expense == null) {
//            return null;
//        }
//        return new ExpenseDTO(expense);
//    }
//}

package com.wanderplan.wanderplan.service;

import com.wanderplan.wanderplan.dto.ExpenseDTO;
import com.wanderplan.wanderplan.model.Expense;
import com.wanderplan.wanderplan.model.User;
import com.wanderplan.wanderplan.repository.ExpenseRepository;
import com.wanderplan.wanderplan.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;

    public ExpenseService(ExpenseRepository expenseRepository, UserRepository userRepository) {
        this.expenseRepository = expenseRepository;
        this.userRepository = userRepository;
    }

    public Expense createExpense(ExpenseDTO dto) {
        return expenseRepository.save(convertToEntity(dto));
    }

    public Expense updateExpense(Long id, ExpenseDTO dto) {
        Expense existing = expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found with id: " + id));

        existing.setCategory(dto.getCategory());
        existing.setAmount(dto.getAmount());
        existing.setDescription(dto.getDescription());
        existing.setExpenseDate(dto.getExpenseDate());

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + dto.getUserId()));
        existing.setUser(user);

        return expenseRepository.save(existing);
    }

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public Expense getExpenseById(Long id) {
        return expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found with id: " + id));
    }

    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }

    public ExpenseDTO convertToDTO(Expense expense) {
        ExpenseDTO dto = new ExpenseDTO();
        dto.setId(expense.getId());
        dto.setCategory(expense.getCategory());
        dto.setAmount(expense.getAmount());
        dto.setDescription(expense.getDescription());
        dto.setExpenseDate(expense.getExpenseDate());
        dto.setUserId(expense.getUser().getUserId());
        return dto;
    }

    private Expense convertToEntity(ExpenseDTO dto) {
        Expense expense = new Expense();
        expense.setCategory(dto.getCategory());
        expense.setAmount(dto.getAmount());
        expense.setDescription(dto.getDescription());
        expense.setExpenseDate(dto.getExpenseDate());

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + dto.getUserId()));
        expense.setUser(user);

        return expense;
    }
}
