package com.example.atividade1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.atividade1.models.CursoModel;
import com.example.atividade1.repositories.CursoRepository;


@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    public List<CursoModel> findByName(String nome) {
        if (nome == null || nome.isEmpty()) {
            return cursoRepository.findAll();
        }
        return cursoRepository.findByNome(nome);
    }

    public List<CursoModel> findAll() {
        return cursoRepository.findAll();
    }
}
