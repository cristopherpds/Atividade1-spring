package com.example.atividade1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.atividade1.models.TokenModel;

@Repository
public interface TokenRepository extends JpaRepository<TokenModel, Long> {
    TokenModel findByToken(String token);
}

