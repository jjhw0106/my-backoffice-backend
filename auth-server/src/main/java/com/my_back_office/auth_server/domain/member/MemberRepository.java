package com.my_back_office.auth_server.domain.member;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public List<Member> findAll(String userId) {
        return new ArrayList<Member>(store.values());
    }

    public Optional<Member> findByUserId(String userId) {
        return findAll(userId).stream().filter(m->m.getUserId().equals(userId)).findFirst();
    }

    public Member findById(Long id) {
        return store.get(id);
    }
    @PostConstruct
    public void init() {
        save(new Member("test", "1234"));
        save(new Member("test2", "1234"));
        save(new Member("test3", "1234"));
    }
}
