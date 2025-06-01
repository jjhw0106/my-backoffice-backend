package com.my_back_office.auth_server.domain.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.my_back_office.auth_server.domain.member.Member;
import com.my_back_office.auth_server.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LoginService {

    private final MemberRepository memberRepository;

    String PRIVATE_KEY="tempkey";
    Algorithm algorithm = Algorithm.HMAC256(PRIVATE_KEY);

    public ResponseEntity<Map<String,String>> login(String userId, String password) {

        Optional<Member> loginMember = memberRepository.findByUserId(userId);

        if (loginMember.isEmpty() || !loginMember.get().getPassword().equals(password)) {
            return ResponseEntity.status(401).body(Map.of("error", "로그인 실패"));
        }

        String token = createJwtToken(userId, password);
        Map<String, String> response = Map.of("token", token);

        return ResponseEntity.ok(response);
    }

    private String createJwtToken(String username, String password) {
        Date now = new Date();
        Date expiry = new Date(now.getTime() + 1000 * 60 * 60);

        return JWT
            .create()
            .withSubject(username)
            .withExpiresAt(expiry)
            .sign(algorithm);
    }
}
