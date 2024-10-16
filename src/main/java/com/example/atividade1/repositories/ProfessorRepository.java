package com.example.atividade1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.atividade1.models.ProfessorModel;

public interface ProfessorRepository extends JpaRepository <ProfessorModel, Long>{
    ProfessorModel findByEmail(String email);
}
