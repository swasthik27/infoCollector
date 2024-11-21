package com.AvirantEnterprises.InfoCollector_AE.controller;

import com.AvirantEnterprises.InfoCollector_AE.model.User;
import com.AvirantEnterprises.InfoCollector_AE.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @Autowired
    private UserService userService;

    // Directs users to the correct dashboard based on their role
    @GetMapping("/dashboard")
    public String userDashboard(HttpSession session, Model model) {
        // Retrieve the logged-in user from session
        User user = (User) session.getAttribute("user");

        if (user != null) {
            if ("ADMIN".equals(user.getRole())) {
                return "redirect:/admin/dashboard";  // Redirect to admin dashboard
            } else if ("USER".equals(user.getRole())) {
                return "redirect:/user/dashboard";  // Redirect to user dashboard
            }
        }

        // Redirect to login if no user is found in session
        return "redirect:/login";
    }
}
