package com.BudgetBuddy.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByUsernameAndPasswordHash(String username, String passwordHash);
    
        User findByUsername( String username);
        User findByUserId( int userId);
        

        
        
   
}
