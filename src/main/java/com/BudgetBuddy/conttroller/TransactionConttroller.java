package com.BudgetBuddy.conttroller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.BudgetBuddy.service.BudgetBudyService;

import jakarta.servlet.http.HttpSession;

import com.BudgetBuddy.repo.*;



@Controller

public class TransactionConttroller {
	

	    @Autowired
	    private IncomeRepository incomeRepository;
	    
	    @Autowired
	    private ExpensesRepository expensesRepository;
	    
	    @Autowired
	    private BudgetBudyService budgetBudyService;
	    
	  
	    @PostMapping("/budgetbuddy/addIncome")
	    public String addIncome(@RequestParam("amount") BigDecimal amount,
	                            @RequestParam("category") String category,
	                            HttpSession session) {
	        // Retrieve the user ID from the session
	        Integer userId = (Integer) session.getAttribute("userId");
	        
	        if (userId != null) {
	            // Create a new Income object
	            Income income = new Income();
	            income.setUserId(userId); // Set the user ID
	            income.setAmount(amount);
	            income.setSource(category);
	            income.setDate(LocalDate.now()); // Assuming you want to set the current date
	            
	            // Save the income to the database
	            incomeRepository.save(income);
	            
	            // Redirect to the user dashboard or any other page
	            return "redirect:/budgetbuddy/dashboard";
	        } else {
	            // If user ID is not found in the session, redirect to login page
	            return "redirect:/budgetbuddy/login";
	        }
	    }
	    
	    @PostMapping("/budgetbuddy/addexpenses")
	    public String addeExpenses(@RequestParam("amount") BigDecimal amount,
	                            @RequestParam("category") String category,
	                            HttpSession session) {
	        // Retrieve the user ID from the session
	        Integer userId = (Integer) session.getAttribute("userId");
	        
	        if (userId != null) {
	            // Create a new Income object
	        	Expenses expenses = new Expenses();
	        	expenses.setUserId(userId); // Set the user ID
	        	expenses.setAmount(amount);
	        	expenses.setSource(category);
	        	expenses.setDate(LocalDate.now()); // Assuming you want to set the current date
	            
	            // Save the income to the database
	        	expensesRepository.save(expenses);
	            
	            // Redirect to the user dashboard or any other page
	            return "redirect:/budgetbuddy/dashboard";
	        } else {
	            // If user ID is not found in the session, redirect to login page
	            return "redirect:/budgetbuddy/login";
	        }
	    }
	    
	    @GetMapping
	    public String showDashboard(@RequestParam int userId, Model model) {
	    	System.out.println(" the T Values : ");
	        DashboardData dashboardData = new DashboardData();
	        Object incomeService;
			//List<Income> incomes = incomeService.getIncomesByUserId(userId);
	        List<Expenses> expenses;
			
				expenses = budgetBudyService.getExpensesByUserId(userId);
		
	        dashboardData.setIncomes(null);
	        dashboardData.setExpenses(expenses);
	        model.addAttribute("dashboardData", dashboardData);
	        return "dashboard"; // Return the name of the JSP view
	    }
}
