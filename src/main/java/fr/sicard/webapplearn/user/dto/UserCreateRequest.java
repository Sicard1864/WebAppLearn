package fr.sicard.webapplearn.user.dto;

public record UserCreateRequest(
    String name,
    String email,
    String password,
    String bio
) {
    
}
