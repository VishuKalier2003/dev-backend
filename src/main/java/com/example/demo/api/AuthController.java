package com.example.demo.api;

import com.example.demo.model.User;
import com.example.demo.repo.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    private final UserRepository repo;

    public AuthController(UserRepository repo) {
        this.repo = repo;
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        if (repo.findByEmail(user.getEmail()) != null) {
            return "Email already exists";
        }
        repo.save(user);
        return "Registered successfully";
    }

    @PostMapping("/login")
    public String login(@RequestBody User request) {
        User dbUser = repo.findByEmail(request.getEmail());

        if (dbUser == null) {
            return "User not found";
        }

        if (!dbUser.getPassword().equals(request.getPassword())) {
            return "Invalid password";
        }

        return "Login successful";
    }
}
