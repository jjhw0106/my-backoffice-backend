package com.dev_ho.domain;

import com.dev_ho.common.JwtUtil;
import com.dev_ho.web.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final JwtUtil jwtUtil;

    public ResponseEntity<?> login(MemberDTO dto) {
        Member member = memberRepository.findById(dto.getId());
        try {
            memberRepository.validatePassword(member, dto.getPassword());
            String token = jwtUtil.generateToken(dto.getId());
            Map<String, String> response = new HashMap<>();
            response.put("token", token);

            log.info("login success");
            return ResponseEntity.ok(response);
        } catch(Exception e) {
            log.info(e.getMessage());

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
