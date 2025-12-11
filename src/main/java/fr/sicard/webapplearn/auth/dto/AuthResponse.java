package fr.sicard.webapplearn.auth.dto;

public record AuthResponse(
    String id,
    String name,
    String email,
    String bio,
    String message
) {
    
}
