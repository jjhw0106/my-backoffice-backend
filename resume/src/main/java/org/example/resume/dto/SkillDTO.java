package org.example.resume.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SkillDTO {
    private String name;
    private int grade;
}
