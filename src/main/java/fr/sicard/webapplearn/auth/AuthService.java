package fr.sicard.webapplearn.auth;

import fr.sicard.webapplearn.user.*;
import fr.sicard.webapplearn.auth.dto.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public AuthResponse register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.email())) {
            throw new RuntimeException("Email already used");
        }

        User user = new User();
        user.setName(request.name());
        user.setEmail(request.email());
        user.setBio(request.bio());
        user.setPasswordHash(passwordEncoder.encode(request.password()));

        userRepository.save(user);

        return new AuthResponse(
                user.getId().toString(),
                user.getName(),
                user.getEmail(),
                user.getBio(),
                "User created successfully"
        );
    }

    public AuthResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.email())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        if (!passwordEncoder.matches(request.password(), user.getPasswordHash())) {
            throw new RuntimeException("Invalid credentials");
        }

        return new AuthResponse(
                user.getId().toString(),
                user.getName(),
                user.getEmail(),
                user.getBio(),
                "Login successful"
        );
    }
}
