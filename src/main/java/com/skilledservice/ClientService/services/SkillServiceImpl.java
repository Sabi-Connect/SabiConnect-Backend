package com.skilledservice.ClientService.services;

import com.skilledservice.ClientService.dto.request.AddSkillRequest;
import com.skilledservice.ClientService.dto.response.AddSkillResponse;
import com.skilledservice.ClientService.exceptions.ProjectException;
import com.skilledservice.ClientService.models.Skill;
import com.skilledservice.ClientService.repository.SkillRepository;
import com.skilledservice.ClientService.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {
    private final ModelMapper modelMapper;
    private final SkillRepository skillRepository;
    private final UserRepository userRepository;


    @Override
    public AddSkillResponse addSkill(AddSkillRequest addSkillRequest) {
        Skill skill = new Skill();
        skill.setSkillName(addSkillRequest.getSkillName());
        skill.setSkilledWorker(userRepository.findById(addSkillRequest.getSkilledWorkerId())
                .orElseThrow(()->new ProjectException("user not found")));
        skill.setSkillDescription(addSkillRequest.getCategory().name());
       skill = skillRepository.save(skill);
        return modelMapper.map(skill, AddSkillResponse.class);
    }

    @Override
    public Skill findSkillById(Long skillId) {
        return skillRepository.findSkillById(skillId);
    }

    @Override
    public Skill addASkill(Skill skill) {
        return skillRepository.save(skill);
    }
}
