package com.skilledservice.ClientService.services;

import com.skilledservice.ClientService.dto.request.AddSkillRequest;
import com.skilledservice.ClientService.dto.request.RegistrationRequest;
import com.skilledservice.ClientService.dto.response.AddSkillResponse;
import com.skilledservice.ClientService.dto.response.SkilledWorkerRegistrationResponse;
import com.skilledservice.ClientService.exceptions.ProjectException;
import com.skilledservice.ClientService.models.Skill;
import com.skilledservice.ClientService.models.User;
import com.skilledservice.ClientService.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class SkilledWorkerServiceImpl implements SkilledWorkerService {

    private final ModelMapper mapper;
    private final UserRepository userRepository;
    private final SkillServiceImpl skillServiceImpl;

    public SkilledWorkerServiceImpl(ModelMapper mapper, UserRepository userRepository, SkillServiceImpl skillServiceImpl) {
        this.mapper = mapper;
        this.userRepository = userRepository;
        this.skillServiceImpl = skillServiceImpl;
    }

    @Override
    public Long getNumberOfUsers() {
        return userRepository.count();
    }

    @Override
    public SkilledWorkerRegistrationResponse registerSkilledWorker(RegistrationRequest registrationRequest) {
        User skilledWorker = mapper.map(registrationRequest, User.class);
        skilledWorker=userRepository.save(skilledWorker);

        SkilledWorkerRegistrationResponse registrationResponse = new SkilledWorkerRegistrationResponse();
        registrationResponse.setSkilledWorkerId(skilledWorker.getId());
        registrationResponse.setAddress(skilledWorker.getAddress());
        registrationResponse.setEmail(skilledWorker.getEmail());
        registrationResponse.setLastName(skilledWorker.getLastName());
        registrationResponse.setFirstName(skilledWorker.getFirstName());
        registrationResponse.setMessage("registration successful");
        return registrationResponse;
    }

    @Override
    public AddSkillResponse addSkill(AddSkillRequest addSkillRequest) {
        User skilledWorker = userRepository.findById(addSkillRequest.getSkilledWorkerId())
                .orElseThrow(() -> new ProjectException("user not found"));

        AddSkillResponse addSkillResponse = new AddSkillResponse();
        Skill skill = skillServiceImpl.findSkillById(addSkillRequest.getSkillId());
        skill.setSkilledWorker(skilledWorker);
        skill = skillServiceImpl.addASkill(skill);
        return addSkillResponse;
    }

}
