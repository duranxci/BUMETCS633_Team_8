package com.BudgetBuddy.repo;

import java.util.List;

public class DashboardData {

	// DashboardData.java

	    private List<Income> incomes;
	    private List<Expenses> expenses;
	    
		public List<Income> getIncomes() {
			return incomes;
		}
		public void setIncomes(List<Income> incomes) {
			this.incomes = incomes;
		}
		public List<Expenses> getExpenses() {
			return expenses;
		}
		public void setExpenses(List<Expenses> expenses) {
			this.expenses = expenses;
		}

	

}
