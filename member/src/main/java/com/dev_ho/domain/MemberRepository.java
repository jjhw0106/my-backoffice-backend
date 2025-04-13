package com.dev_ho.domain;

import org.springframework.stereotype.Repository;

import java.util.*;

import static com.dev_ho.common.TestData.*;

@Repository
public class MemberRepository {
    private static long seq = 0L;

    public Member save(Member member) {
        store.put(++seq, member);

        return member;
    }

    public List<Member> findAll() {
        return new ArrayList<Member> (store.values());
    }

    public Member findById(String id) {
        return findAll()
                .stream()
                .filter(e -> e.getUserId().equals(id))
                .findFirst()
                .orElseThrow(()->new IllegalArgumentException("존재하지 않는 ID"));
    }

    public void validatePassword(Member member, String password) {
        if(!password.equals(member.getPassword())) {
            throw new IllegalArgumentException("비밀번호 불일치");
        }
    }
}
