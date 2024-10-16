package com.example.atividade1.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.example.atividade1.models.ProfessorModel;
import com.example.atividade1.models.TokenModel;
import com.example.atividade1.services.ProfessorService;
import com.example.atividade1.services.TokenService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpSession;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private ProfessorService professorService;

    @Autowired
    private TokenService tokenService;

    @GetMapping("/login")
    public String login() {
        return "login"; // Retorna a página de login (login.html)
    }

    /* @GetMapping("/home")
    public String home(HttpSession session, Model model) {
        String userEmail = (String) session.getAttribute("userEmail");
        if (userEmail == null) {
            return "redirect:/auth/login"; // Redireciona para a página de login se não estiver logado
        }
        model.addAttribute("userEmail", userEmail);
        return "/home";
    } */

    @PostMapping("/login")
    public String login(@RequestParam String email, Model model) throws MessagingException {
        ProfessorModel professor = professorService.findByEmail(email);
        if (professor != null) {
            // Crear el token y asociarlo al profesor
            TokenModel token = tokenService.createToken(professor);
            String link = "http://localhost:8080/auth/verify?token=" + token.getToken();

            // Preparar y enviar el correo electrónico
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            try {
                helper.setTo(email);
                helper.setSubject("Tu enlace mágico");
                helper.setText("<p>Haz clic en el siguiente enlace para iniciar sesión:</p><a href=\"" + link + "\">"
                        + link + "</a>", true);
                mailSender.send(message);
            } catch (MessagingException e) {
                e.printStackTrace();
                return "Error al enviar el correo.";
            }
            model.addAttribute("message", "Se ha enviado un enlace mágico a tu correo.");
            return "confirmation";
        }
        model.addAttribute("message", "Email no encontrado. Verifique com um administrador.");
        return "login";
    }

    @GetMapping("/verify")
    public String verify(@RequestParam String token, HttpSession session, Model model) {
        TokenModel validToken = tokenService.validateToken(token);
        if (validToken != null) {
            session.setAttribute("userEmail", validToken.getProfessor().getEmail());
            return "home";
        }
        model.addAttribute("message", "Token inválido ou expirado.");
        return "login";
    }

    @GetMapping("/checkLoginStatus")
    @ResponseBody
    public Map<String, Boolean> checkLoginStatus(HttpSession session) {
        Map<String, Boolean> response = new HashMap<>();
        response.put("loggedIn", session.getAttribute("userEmail") != null);
        return response;
    }
}
