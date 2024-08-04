package com.skilledservice.ClientService.services;

import com.skilledservice.ClientService.dto.request.AddSkillRequest;
import com.skilledservice.ClientService.dto.request.SkilledWorkerRegistrationRequest;
import com.skilledservice.ClientService.dto.response.AddSkillResponse;
import com.skilledservice.ClientService.dto.response.SkilledWorkerRegistrationResponse;

public interface SkilledWorkerService {
    Long getNumberOfUsers();

    SkilledWorkerRegistrationResponse registerSkilledWorker(SkilledWorkerRegistrationRequest registrationRequest);

    AddSkillResponse addSkill(AddSkillRequest addSkillRequest);
}
