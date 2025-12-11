package fr.sicard.webapplearn.user;

import fr.sicard.webapplearn.user.dto.*;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordRepository;

    public UserService(UserRepository userRepository,
                          PasswordEncoder passwordEncoder) {
          this.userRepository = userRepository;
          this.passwordRepository = passwordEncoder;
    }

    // ===== CRUD =====

    public List<UserResponse> findAll() {
        return userRepository.findAll()
        .stream()
        .map(this::toResponse)
        .toList();
    }

    public UserResponse findById(Long id) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found : " + id));
        return toResponse(user);
    }

    public UserResponse create(UserCreateRequest request) {
        if (userRepository.existsByEmail(request.email())) {
            throw new RuntimeException("Email already usesd : " + request.email());
        }

        User user = new User();
        user.setName(request.name());
        user.setEmail(request.email());
        user.setBio(request.bio());
        user.setPasswordHash(hashPassword(request.password()));

        User saved = userRepository.save(user);
        return toResponse(saved);
    }

    public UserResponse update(Long id, UserUpdateRequest request) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found : " + id));
        
        user.setName(request.name());
        user.setEmail(request.email());
        user.setBio(request.bio());

        if (request.password() != null && !request.password().isBlank()) {
            user.setPasswordHash(hashPassword(request.password()));
        }

        User saved = userRepository.save(user);
        return toResponse(saved);
    }

    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found : " + id);
        }
        userRepository.deleteById(id);
    }

    public UserResponse findByEmail(String email) {
        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found : " + email));
        return toResponse(user);
    }

    public void updateLastLogin(Long id) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found : " + id));
        user.setLastLoginAt(LocalDateTime.now());
        userRepository.save(user);
    }

    // ===== Utils =====

    private String hashPassword(String rawPassword) {
        if (rawPassword == null || rawPassword.isBlank()) {
            throw new RuntimeException("Password cannot be empty");
        }
        // todo : plus tard ajouter du sel et un pepper provenant de la config
        return  passwordRepository.encode(rawPassword);
    }

    private UserResponse toResponse(User user) {
        return new UserResponse(
            user.getId(),
            user.getName(),
            user.getEmail(),
            user.getBio(),
            user.getCreatedAt().toString(),
            user.getUpdatedAt().toString(),
            user.getLastLoginAt() != null ? user.getLastLoginAt().toString() : null
        );
    }
}
