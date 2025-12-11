package fr.sicard.webapplearn.user;

import fr.sicard.webapplearn.user.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    // GET /api/users
    @GetMapping
    public List<UserResponse> getAll() {
        return service.findAll();
    }

    // GET /api/users/{id}
    @GetMapping("/{id}")
    public UserResponse getById(@PathVariable Long id) {
        return service.findById(id);
    }

    // GET /api/users/search?email=...
    @GetMapping("/search")
    public UserResponse getByEmail(@RequestParam String email) {
        return service.findByEmail(email);
    }

    // POST /api/users
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse create(@RequestBody UserCreateRequest request) {
        return service.create(request);
    }

    // PUT /api/users/{id}
    @PutMapping("/{id}")
    public UserResponse update(@PathVariable Long id,
                               @RequestBody UserUpdateRequest request) {
        return service.update(id, request);
    }

    // DELETE /api/users/{id}
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    // PATCH /api/users/{id}/last-login
    @PatchMapping("/{id}/last-login")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateLastLogin(@PathVariable Long id) {
        service.updateLastLogin(id);
    }
}
