package com.AvirantEnterprises.InfoCollector_AE.controller;

import com.AvirantEnterprises.InfoCollector_AE.model.User;
import com.AvirantEnterprises.InfoCollector_AE.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @PostMapping("/submit")
    public String registerUser(@RequestParam String name, @RequestParam String email,
                               @RequestParam String password, @RequestParam String confirmPassword,
                               Model model) {

        if (!password.equals(confirmPassword)) {
            model.addAttribute("error", "Passwords do not match");
            return "register";  // Return to registration page if passwords do not match
        }

        // Save the user in the database
        User user = new User(name, password, "USER", email);
        userService.saveUser(user);  // Save the user using UserService

        return "redirect:/admin/dashboard";  // Redirect to admin dashboard after successful registration
    }
}
