package com.example.atividade1.dto;

import jakarta.validation.constraints.NotBlank;

public record ProfessorDTO(Long id, @NotBlank String nome, @NotBlank String email, @NotBlank String foto) {

}
