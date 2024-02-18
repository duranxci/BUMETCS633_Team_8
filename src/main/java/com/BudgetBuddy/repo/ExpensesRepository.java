package com.BudgetBuddy.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpensesRepository extends JpaRepository<Expenses, Long> {

	List<Expenses> findByUserId(int userId);

	

}
