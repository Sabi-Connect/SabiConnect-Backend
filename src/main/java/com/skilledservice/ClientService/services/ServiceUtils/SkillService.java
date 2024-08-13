package com.skilledservice.ClientService.services.ServiceUtils;

import com.skilledservice.ClientService.dto.requests.AddSkillRequest;
import com.skilledservice.ClientService.dto.responses.AddSkillResponse;
import com.skilledservice.ClientService.data.models.Skill;

import java.util.List;

public interface SkillService {
    AddSkillResponse addSkill(AddSkillRequest addSkillRequest);
    Skill findSkillById(Long skilledWorkerId);
    Skill addASkill(Skill skill);

    List<Skill> findSkillFor(Long skilledWorkerId);
}
