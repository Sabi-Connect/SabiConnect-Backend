package com.skilledservice.ClientService.services;

import com.skilledservice.ClientService.dto.request.AddSkillRequest;
import com.skilledservice.ClientService.dto.response.AddSkillResponse;
import com.skilledservice.ClientService.models.Skill;

import java.util.List;

public interface SkillService {
    AddSkillResponse addSkill(AddSkillRequest addSkillRequest);
    Skill findSkillById(Long skilledWorkerId);
    Skill addASkill(Skill skill);

    List<Skill> findSkillFor(Long skilledWorkerId);
}
