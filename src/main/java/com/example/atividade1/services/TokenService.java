package com.example.atividade1.services;

import org.springframework.stereotype.Service;

import com.example.atividade1.models.ProfessorModel;
import com.example.atividade1.models.TokenModel;
import com.example.atividade1.repositories.TokenRepository;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;


import java.time.LocalDateTime;

@Service
public class TokenService {
    @Autowired
    private TokenRepository tokenRepository;

    public TokenModel createToken(ProfessorModel professor) {
        TokenModel token = new TokenModel();
        token.setToken(UUID.randomUUID().toString());
        token.setProfessor(professor);
        token.setExpirationTime(LocalDateTime.now().plusMinutes(15)); // Expira en 15 minutos
        return tokenRepository.save(token);
    }

    public TokenModel validateToken(String tokenValue) {
        TokenModel token = tokenRepository.findByToken(tokenValue);
        if (token != null && token.getExpirationTime().isAfter(LocalDateTime.now())) {
            return token;
        }
        return null; // Token inválido o expirado
    }
}
