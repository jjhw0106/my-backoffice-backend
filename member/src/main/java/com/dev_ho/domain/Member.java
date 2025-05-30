package com.dev_ho.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Member {

    private Long id;

    String userId;
    String userName;
    String password;
}
