package com.AvirantEnterprises.InfoCollector_AE.controller;

import com.AvirantEnterprises.InfoCollector_AE.model.User;
import com.AvirantEnterprises.InfoCollector_AE.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/dashboard")
    public String userDashboard(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            model.addAttribute("user", user);  // Add user info to the view
            return "user-dashboard";  // Ensure this corresponds to the correct HTML file
        }

        return "redirect:/login";  // Redirect if no user found in session
    }
}
