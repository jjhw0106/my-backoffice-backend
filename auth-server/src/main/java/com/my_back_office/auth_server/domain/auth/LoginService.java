package com.my_back_office.auth_server.domain.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.my_back_office.auth_server.domain.member.Member;
import com.my_back_office.auth_server.domain.member.MemberRepository;
import com.sun.net.httpserver.HttpServer;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseCookie;
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

    public ResponseEntity<Map<String,String>> login(String userId, String password, HttpServletResponse response) {

        Optional<Member> loginMember = memberRepository.findByUserId(userId);

        if (loginMember.isEmpty() || !loginMember.get().getPassword().equals(password)) {
            return ResponseEntity.status(HttpServletResponse.SC_UNAUTHORIZED).body(Map.of("error", "로그인 실패"));
        }

        String token = createJwtToken(userId, password);
        // 아래 코드는 local storage에 저장하는 것이 아닌, 브라우저에서 토큰 발급하기 위함
        ResponseCookie cookie = ResponseCookie.from("token", token)
                .httpOnly(true)
                .secure(false)
                .path("/")                 // ✅ 쿠키의 유효 경로 (기본적으로 안 붙이면 /auth만 유효)
                .maxAge(3600)
                .build();
        response.addHeader("Set-Cookie", cookie.toString());

//        return ResponseEntity.ok(Map.of("message", "로그인 성공"));
        return ResponseEntity.ok(Map.of("accessToken", token));
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
