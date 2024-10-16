package com.example.atividade1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.atividade1.models.ProfessorModel;
import com.example.atividade1.services.ProfessorService;

@Controller
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;

    @GetMapping("/professores")
    public String listarProfessores(Model model) {
        List<ProfessorModel> professores = professorService.findAll();
        model.addAttribute("professores", professores);
        return "professores";
    }
}
