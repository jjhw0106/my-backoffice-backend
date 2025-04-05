package org.example.resume;

import lombok.extern.slf4j.Slf4j;
import org.example.resume.dto.SkillDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resume")
@Slf4j
public class ResumeController {
    @GetMapping("/skill")
    public SkillDTO mySkill() {
        return SkillDTO.builder().name("JAVA").grade(20).build();
    }
}
