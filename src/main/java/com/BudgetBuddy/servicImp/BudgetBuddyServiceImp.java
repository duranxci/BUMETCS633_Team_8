package com.BudgetBuddy.servicImp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BudgetBuddy.repo.Expenses;
import com.BudgetBuddy.repo.ExpensesRepository;
import com.BudgetBuddy.repo.Income;
import com.BudgetBuddy.repo.IncomeRepository;
import com.BudgetBuddy.repo.User;
import com.BudgetBuddy.repo.UserRepository;
/*
 * Copyright (c) 2024 Team 8 - BudgetBuddy
 * Boston University MET CS 633
 * Team 8 - BudgetBuddy Application
 * 
 */
import com.BudgetBuddy.service.BudgetBudyService;


@Service
public class BudgetBuddyServiceImp implements BudgetBudyService  {
	  @Autowired
	    private UserRepository userRepository;
	  
	  @Autowired
	  private ExpensesRepository expenseRepository;
	  
	  @Autowired
	  private IncomeRepository incomeRepository;
	
	public int getUserIdByUsername(String username) {
	    User user = userRepository.findByUsername(username);
	    if (user != null) {
	        return user.getUserId();
	    } else {
	        return 0;
	    }
	    
	}
	public List<Expenses> getExpensesByUserId(int userId) {
        return expenseRepository.findByUserId(userId);
    }
	
	public List<Income> getIncomeByUserId(int userId) {
        return incomeRepository.findByUserId(userId);

	}

}
