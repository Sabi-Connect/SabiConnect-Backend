package com.skilledservice.ClientService.services;

import com.skilledservice.ClientService.dto.request.AddSkillRequest;
import com.skilledservice.ClientService.dto.request.RegistrationRequest;
import com.skilledservice.ClientService.dto.response.AddSkillResponse;
import com.skilledservice.ClientService.dto.response.SkilledWorkerRegistrationResponse;
import com.skilledservice.ClientService.exceptions.ProjectException;
import com.skilledservice.ClientService.models.Role;
import com.skilledservice.ClientService.models.User;
import com.skilledservice.ClientService.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SkilledWorkerServiceImpl implements SkilledWorkerService {

    private final ModelMapper mapper;
    private final UserRepository userRepository;
    private final SkillService skillService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    @Lazy
    public SkilledWorkerServiceImpl(ModelMapper mapper, UserRepository userRepository, SkillService skillService, PasswordEncoder passwordEncoder) {
        this.mapper = mapper;
        this.userRepository = userRepository;
        this.skillService = skillService;
        this.passwordEncoder = passwordEncoder;
    }
//    @Autowired
//    public void SkillService(SkillService skillService) {
//        this.skillService = skillService;
//    }

    @Override
    public Long getNumberOfUsers() {
        return userRepository.count();
    }

    @Override
    public SkilledWorkerRegistrationResponse registerSkilledWorker(RegistrationRequest registrationRequest) {
        User skilledWorker = mapper.map(registrationRequest, User.class);
        skilledWorker.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
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
        return skillService.addSkill(addSkillRequest);
    }

    @Override
    public User findById(Long skilledWorkerId) {
        return userRepository.findById(skilledWorkerId).orElseThrow(() -> new ProjectException("user not found"));
    }


}
