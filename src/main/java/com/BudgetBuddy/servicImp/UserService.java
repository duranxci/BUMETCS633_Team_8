package com.BudgetBuddy.servicImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.BudgetBuddy.repo.User;
import com.BudgetBuddy.repo.UserRegistrationDto;
import com.BudgetBuddy.repo.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

 

        public void registerUser(UserRegistrationDto registrationDto) {
            // Perform registration logic, e.g., save user to the database
            User newUser = new User();
            newUser.setUsername(registrationDto.getUsername());
            newUser.setEmail(registrationDto.getEmail());
            newUser.setPasswordHash(registrationDto.getPassword());
            userRepository.save(newUser);
        }
        

        public boolean authenticateUser(String username, String password) {
            User user = userRepository.findByUsernameAndPasswordHash(username, password);
            return user != null;
        }
    
    }
