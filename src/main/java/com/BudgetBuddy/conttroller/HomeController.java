package com.BudgetBuddy.conttroller;

import java.math.BigDecimal;
import java.util.List;

/*
 * Copyright (c) 2024 Team 8 - BudgetBuddy
 * Boston University MET CS 633
 * Team 8 - BudgetBuddy Application
 * 
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BudgetBuddy.repo.DashboardData;
import com.BudgetBuddy.repo.Expenses;
import com.BudgetBuddy.repo.Income;
import com.BudgetBuddy.repo.User;
import com.BudgetBuddy.repo.UserRepository;
import com.BudgetBuddy.service.BudgetBudyService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private BudgetBudyService budgetBudyService;

    @Autowired
    private  UserRepository userRepo;
    
    @GetMapping("/budgetbuddy")
    public String welcome() {
        logger.info("Welcome to BudgetBuddy Application");       
        return "home";
        
        
    }
    
    @GetMapping("/budgetbuddy/register")
    public String register() {
        logger.info("Register an account with BudgetBuddy Application");
        return "register";
    }

    @GetMapping("/budgetbuddy/login")
    public String login() {
        logger.info("Login to BudgetBuddy Application");
        return "login";
    }
    
    @GetMapping("budgetbuddy/success")
    public String showSuccessPage() {
        return "success"; // 
    }
    
    @GetMapping("/budgetbuddy/dashboard")
    public String dashboard(HttpSession session,Model model) {
        logger.info("Welcome to user Dashboard"); 
        System.out.println(" the Dashborad Values : ");
        Integer userId = (Integer) session.getAttribute("userId");
        System.out.println(" the Dashborad user id  : "+userId);

        DashboardData dashboardData = new DashboardData();
        Object incomeService;
		//List<Income> incomes = incomeService.getIncomesByUserId(userId);
        List<Expenses> expenses;
        List<Income>income;
		BigDecimal a=null;
		String c=null;
			expenses = budgetBudyService.getExpensesByUserId(userId);
           income = budgetBudyService.getIncomeByUserId(userId);
           User u=  userRepo.findByUserId(userId);  
         String uername=  u.getUsername();
        dashboardData.setIncomes(income);
        model.addAttribute("income", income);
        dashboardData.setExpenses(expenses);
        model.addAttribute("expenses", expenses);
        model.addAttribute("userId",userId);
        model.addAttribute("uername",uername);

       System.out.println( "this is the size "+expenses.size());
       // Calculate total income and total expenses


    // Calculate total income
       BigDecimal totalIncome = BigDecimal.ZERO; // Initialize totalIncome to zero
       for (Income incomes : income) {
           totalIncome = totalIncome.add(incomes.getAmount());
       }

       // Calculate total expenses
       BigDecimal totalExpenses = BigDecimal.ZERO; // Initialize totalExpenses to zero
       for (Expenses expenses1 : expenses) {
           totalExpenses = totalExpenses.add(expenses1.getAmount());
       }
       BigDecimal balance = totalIncome.subtract(totalExpenses);
       // Pass data to the frontend
       model.addAttribute("expenses", expenses);
       model.addAttribute("incomes", income);
       model.addAttribute("totalIncome", totalIncome);
       model.addAttribute("totalExpenses", totalExpenses);
       model.addAttribute("balance", balance);
        return "dashboard"; // Return the name of the JSP view
    
        
        
    }
    
    @GetMapping("/budgetbuddy/addincome")
    public String addIncome() {
        logger.info("Welcome to user add Income form");       
        return "addincome";
        
        
    }
    
    @GetMapping("/budgetbuddy/addexpenses")
    public String addExpenses() {
        logger.info("Welcome to user add Expenses form");       
        return "addexpenses";
        
        
    }
}
