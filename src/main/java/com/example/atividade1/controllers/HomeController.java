package com.example.atividade1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
    @GetMapping("/")
    public String homee(HttpSession session, Model model) {
        String userEmail = (String) session.getAttribute("userEmail");
        if (userEmail == null) {
            return "redirect:/auth/login";
        }
        model.addAttribute("userEmail", userEmail);
        return "home";
    }

    @GetMapping("/home")
    public String home(HttpSession session, Model model) {
        String userEmail = (String) session.getAttribute("userEmail");
        if (userEmail == null) {
            return "redirect:/auth/login";
        }
        model.addAttribute("userEmail", userEmail);
        return "home";
    }
}
