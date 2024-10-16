package com.example.atividade1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.atividade1.models.ProfessorModel;
import com.example.atividade1.repositories.ProfessorRepository;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public ProfessorModel findByEmail(String email) {
        return professorRepository.findByEmail(email);
    }

    // Otros métodos...
}
