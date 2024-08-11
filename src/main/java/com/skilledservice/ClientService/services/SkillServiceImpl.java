package com.skilledservice.ClientService.services;

import com.skilledservice.ClientService.dto.request.AddSkillRequest;
import com.skilledservice.ClientService.dto.response.AddSkillResponse;
import com.skilledservice.ClientService.models.Skill;
import com.skilledservice.ClientService.models.User;
import com.skilledservice.ClientService.repository.SkillRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {
    private final SkillRepository skillRepository;
    private final SkilledWorkerService skilledWorkerService;

    @Autowired
    @Lazy
    public SkillServiceImpl(SkillRepository skillRepository, SkilledWorkerService skilledWorkerService) {
        this.skillRepository = skillRepository;
        this.skilledWorkerService = skilledWorkerService;
    }




    @Override
    public AddSkillResponse addSkill(AddSkillRequest addSkillRequest) {
        Skill skill = new Skill();
        skill.setSkillName(addSkillRequest.getSkillName());
        User skilledWorker = skilledWorkerService.findById(addSkillRequest.getSkilledWorkerId());
        skill.setSkilledWorker(skilledWorker);
        skill.setSkillCategory(addSkillRequest.getCategory());
        skillRepository.save(skill);

        AddSkillResponse addSkillResponse = new AddSkillResponse();
        addSkillResponse.setSkillId(skill.getId());
        addSkillResponse.setSkilledWorkerId(skilledWorker.getId());
        addSkillResponse.setSkillName(addSkillRequest.getSkillName());
        addSkillResponse.setCategory(addSkillRequest.getCategory());
        return addSkillResponse;
    }

    @Override
    public Skill findSkillById(Long skillId) {
        return skillRepository.findSkillById(skillId);
    }

    @Override
    public Skill addASkill(Skill skill) {
        return skillRepository.save(skill);
    }

    @Override
    public List<Skill> findSkillFor(Long skilledWorkerId) {
        return skillRepository.findSkillsFor(skilledWorkerId);
    }


}
