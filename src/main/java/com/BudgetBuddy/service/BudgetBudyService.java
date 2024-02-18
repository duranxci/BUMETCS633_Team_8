package com.BudgetBuddy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.BudgetBuddy.repo.Expenses;
import com.BudgetBuddy.repo.Income;

/*
 * Copyright (c) 2024 Team 8 - BudgetBuddy
 * Boston University MET CS 633
 * Team 8 - BudgetBuddy Application
 * 
 */
@Service
public interface BudgetBudyService {
	public int getUserIdByUsername(String username) ;
	public List<Expenses> getExpensesByUserId(int userId) ;
	public List<Income> getIncomeByUserId(int userId) ;

	  
	}


