package fr.sicard.webapplearn.user.dto;

public record UserUpdateRequest(
    String name,
    String email,
    String password,
    String bio
) {
    
}
