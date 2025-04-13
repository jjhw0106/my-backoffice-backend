package com.dev_ho.domain;

import com.dev_ho.web.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public String login(MemberDTO dto) {
        Member member = memberRepository.findById(dto.getId());
        try {
            memberRepository.validatePassword(member, dto.getPassword());
            log.info("login success");
            return "login success";
        } catch(Exception e) {
            log.info(e.getMessage());
            return "login fail";
        }
    }
}
