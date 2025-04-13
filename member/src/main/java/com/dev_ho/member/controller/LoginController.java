package com.dev_ho.member.controller;

import com.dev_ho.member.dto.MemberDTO;
import com.dev_ho.member.model.Member;
import com.dev_ho.member.repository.MemberRepository;
import com.dev_ho.member.service.MemberService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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
