package com.skilledservice.ClientService.services.implmentations;

import com.skilledservice.ClientService.data.models.Address;
import com.skilledservice.ClientService.dto.requests.AddSkillRequest;
import com.skilledservice.ClientService.dto.requests.RegistrationRequest;
import com.skilledservice.ClientService.dto.responses.AddSkillResponse;
import com.skilledservice.ClientService.dto.responses.SkilledWorkerRegistrationResponse;
import com.skilledservice.ClientService.exceptions.SabiConnectException;
import com.skilledservice.ClientService.data.constants.Role;
import com.skilledservice.ClientService.data.models.SkilledWorker;
import com.skilledservice.ClientService.data.repository.SkilledWorkerRepository;
import com.skilledservice.ClientService.services.ServiceUtils.SkillService;
import com.skilledservice.ClientService.services.ServiceUtils.SkilledWorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SkilledWorkerServiceImpl implements SkilledWorkerService {

    private final SkillService skillService;
    private final PasswordEncoder passwordEncoder;
    private final SkilledWorkerRepository skilledWorkerRepository;
    private final AddressServiceImpl addressService;

    @Autowired
    @Lazy
    public SkilledWorkerServiceImpl(SkillService skillService, PasswordEncoder passwordEncoder, SkilledWorkerRepository skilledWorkerRepository, AddressServiceImpl addressService) {
        this.skillService = skillService;
        this.passwordEncoder = passwordEncoder;
        this.skilledWorkerRepository = skilledWorkerRepository;
        this.addressService = addressService;
    }

    @Override
    public Long getNumberOfUsers() {
        return skilledWorkerRepository.count();
    }

    @Override
    public SkilledWorkerRegistrationResponse registerSkilledWorker(RegistrationRequest registrationRequest) {

        SkilledWorker skilledWorker = new SkilledWorker();
        skilledWorker.setFirstName(registrationRequest.getFirstName());
        skilledWorker.setLastName(registrationRequest.getLastName());
        skilledWorker.setEmail(registrationRequest.getEmail());
        skilledWorker.setPhoneNumber(registrationRequest.getPhoneNumber());
        skilledWorker.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
        skilledWorker.setUsername(registrationRequest.getUsername());
        Address newAddress = addressService.createAddress(registrationRequest);
        skilledWorker.setAddress(newAddress);
        skilledWorker = skilledWorkerRepository.save(skilledWorker);

        return getSkilledWorkerRegistrationResponse(skilledWorker);
    }

    private static SkilledWorkerRegistrationResponse getSkilledWorkerRegistrationResponse(SkilledWorker skilledWorker) {
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
    public SkilledWorker findById(Long skilledWorkerId) {
        return skilledWorkerRepository.findById(skilledWorkerId).orElseThrow(() -> new SabiConnectException("user not found"));
    }


}
