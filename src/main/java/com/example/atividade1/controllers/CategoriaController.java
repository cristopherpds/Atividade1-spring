package com.example.atividade1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.atividade1.models.CategoriaModel;
import com.example.atividade1.services.CategoriaService;



@Controller
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/categorias")
    public String listarCategorias(Model model) {
        List<CategoriaModel> categorias = categoriaService.findAll();
        model.addAttribute("categorias", categorias);
        return "categorias";
    }
}
