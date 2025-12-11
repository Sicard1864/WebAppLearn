package fr.sicard.webapplearn.auth.dto;

public record LoginRequest(
    String email,
    String password
) {
    
}
