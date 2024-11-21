package com.AvirantEnterprises.InfoCollector_AE.controller;

import com.AvirantEnterprises.InfoCollector_AE.model.User;
import com.AvirantEnterprises.InfoCollector_AE.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    // Get login page
    @GetMapping("/login")
    public String loginPage() {
        return "login";  // This should map to login.html
    }

    // Handle login form submission
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session, Model model) {
        // Validate user credentials
        User user = userService.validateUser(username, password);

        if (user != null) {
            // Store user info in session
            session.setAttribute("user", user);

            // Redirect based on user role
            if ("ADMIN".equals(user.getRole())) {
                return "redirect:/admin/dashboard";  // Redirect to admin dashboard
            } else if ("USER".equals(user.getRole())) {
                return "redirect:/user/dashboard";  // Redirect to user dashboard
            }
        }

        // Invalid login credentials
        model.addAttribute("error", "Invalid credentials");
        return "login";  // Redirect back to login page on failure
    }

    // Logout handler
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();  // Invalidate session on logout
        return "redirect:/login";  // Redirect to login page after logout
    }
}
