package com.example.atividade1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.atividade1.models.CategoriaModel;

public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long>{

}
