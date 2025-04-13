package com.dev_ho.member.service;

import com.dev_ho.member.dto.MemberDTO;
import com.dev_ho.member.model.Member;
import com.dev_ho.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

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
