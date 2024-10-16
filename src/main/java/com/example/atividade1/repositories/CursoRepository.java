package com.example.atividade1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.atividade1.models.CursoModel;

public interface CursoRepository extends JpaRepository<CursoModel, Long>{

}
