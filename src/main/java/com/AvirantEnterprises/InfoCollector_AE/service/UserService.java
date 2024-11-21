package com.AvirantEnterprises.InfoCollector_AE.service;

import com.AvirantEnterprises.InfoCollector_AE.model.FormSubmission;
import com.AvirantEnterprises.InfoCollector_AE.model.User;
import com.AvirantEnterprises.InfoCollector_AE.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    // Inject UserRepository to access the database
    @Autowired
    private UserRepository userRepository;

    // Mock user validation method
    public User validateUser(String username, String password) {
        if ("admin".equals(username) && "admin123".equals(password)) {
            return new User("admin", "admin123", "ADMIN", "admin@domain.com");
        } else if ("user".equals(username) && "user123".equals(password)) {
            return new User("user", "user123", "USER", "user@domain.com");
        }
        return null;
    }

    // Method to return all users
    public List<User> getAllUsers() {
        return userRepository.findAll();  // Fetch users from the database
    }

    // Get form submission by ID (mock implementation for now)
    public FormSubmission getFormById(Long id) {
        // Logic to retrieve the form submission (returning null for now)
        return null;
    }

    // Save form submission (mock implementation for now)
    public void saveForm(FormSubmission formSubmission) {
        // Logic to save the form submission (no actual saving for now)
        System.out.println("Form saved: " + formSubmission);
    }

    // Save user to the database
    public void saveUser(User user) {
        userRepository.save(user);  // Correct way to save using the injected userRepository
    }
}
