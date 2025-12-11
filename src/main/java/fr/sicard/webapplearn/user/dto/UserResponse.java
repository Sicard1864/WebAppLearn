package fr.sicard.webapplearn.user.dto;

public record UserResponse(
    Long id,
    String name,
    String email,
    String bio,
    String createdAt,
    String updatedAt,
    String lastLoginAt
) {
    
}
