package com.example.atividade1.dto;

import java.util.Set;

public record CategoriaDTO(Long id, String nome, Set<CursoDTO> cursos) {

}
