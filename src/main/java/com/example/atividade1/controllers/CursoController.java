package com.example.atividade1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.atividade1.models.CursoModel;
import com.example.atividade1.services.CursoService;

@Controller
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @GetMapping("/cursos")
    public String listarCursos(Model model) {
        List<CursoModel> cursos = cursoService.findAll();
        model.addAttribute("cursos", cursos);
        return "cursos";
    }
}
