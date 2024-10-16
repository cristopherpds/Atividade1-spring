package com.example.atividade1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.atividade1.models.CursoModel;
import com.example.atividade1.services.CursoService;

import jakarta.servlet.http.HttpSession;


@Controller
public class HomeController {

    @Autowired
    private CursoService cursoService;
    @GetMapping({"/", "/home"})
    public String home(HttpSession session, Model model) {
        String userEmail = (String) session.getAttribute("userEmail");
        if (userEmail == null) {
            return "redirect:/auth/login";
        }
        model.addAttribute("userEmail", userEmail);

        List<CursoModel> cursos = cursoService.findByName(null);
        model.addAttribute("cursos", cursos);

        return "home";
    }
}
