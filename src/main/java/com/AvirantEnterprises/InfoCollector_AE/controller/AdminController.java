package com.AvirantEnterprises.InfoCollector_AE.controller;

import com.AvirantEnterprises.InfoCollector_AE.model.User;
import com.AvirantEnterprises.InfoCollector_AE.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/admin/dashboard")
    public String adminDashboard(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");

        // Check if the user is logged in and has admin role
        if (user != null && "ADMIN".equals(user.getRole())) {
            // Fetch all users and pass them to the view
            model.addAttribute("users", userService.getAllUsers());
            return "admin-dashboard";  // Return the admin-dashboard view
        }

        // If the user is not an admin, redirect to login
        return "redirect:/login";
    }
}
