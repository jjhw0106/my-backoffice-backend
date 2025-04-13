package com.dev_ho.web.controller;

import com.dev_ho.web.dto.MemberDTO;
import com.dev_ho.domain.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
@Slf4j
public class LoginController {
    private final MemberService service;

    @PostMapping()
    public ResponseEntity<?> login(@RequestBody MemberDTO dto) {

        return service.login(dto);
    }
}
