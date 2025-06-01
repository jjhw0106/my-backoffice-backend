package com.my_back_office.auth_server.domain.member;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Member {

    public Member() {}

    public Member(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    private Long id;

    @NotEmpty
    private String userId;
    @NotEmpty
    private String password;
}
