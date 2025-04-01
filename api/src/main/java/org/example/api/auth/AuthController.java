package org.example.api.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@Slf4j
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        log.info("Login request received username: {} password: {}" , loginRequestDTO.getUsername(), loginRequestDTO.getPassword());
        return ResponseEntity.ok().build();
    }
}
