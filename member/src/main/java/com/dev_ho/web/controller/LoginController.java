package com.dev_ho.web.controller;

import com.dev_ho.web.dto.MemberDTO;
import com.dev_ho.domain.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
@Slf4j
public class LoginController {
//    static Map<String, String> store = new HashMap<String, String>();
    private final MemberService service;

    @PostMapping()
    public String login(@RequestBody MemberDTO dto) {

        return service.login(dto);
    }
}
