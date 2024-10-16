package com.example.atividade1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.atividade1.models.CategoriaModel;

public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long>{
    List<CategoriaModel> findByNome(String nome);
}
