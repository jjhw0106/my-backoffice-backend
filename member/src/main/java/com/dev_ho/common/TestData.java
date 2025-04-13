package com.dev_ho.common;

import com.dev_ho.member.model.Member;
import com.dev_ho.member.repository.MemberRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class TestData {
    public static Map<Long, Member> store = new HashMap<Long, Member>();
    private final MemberRepository memberRepository;

    @PostConstruct
    public void init() {
        System.out.println("init!!!!");
        List<Member> members = new ArrayList<>();
        members.add(Member.builder()
            .userId("jjhw0106")
            .userName("정호원")
            .password("1234").build());
        members.add(Member.builder()
            .userId("jhw0106")
            .userName("정호투")
            .password("1234").build());
//        members.forEach(member -> memberRepository.save(member));
        members.forEach(memberRepository::save);
    }
}
