package com.skilledservice.ClientService.services.ServiceUtils;

import com.skilledservice.ClientService.dto.requests.AddSkillRequest;
import com.skilledservice.ClientService.dto.requests.LoginRequest;
import com.skilledservice.ClientService.dto.requests.PostReviewRequest;
import com.skilledservice.ClientService.dto.requests.RegistrationRequest;
import com.skilledservice.ClientService.dto.responses.AddSkillResponse;
import com.skilledservice.ClientService.dto.responses.LoginResponse;
import com.skilledservice.ClientService.dto.responses.PostReviewResponse;
import com.skilledservice.ClientService.dto.responses.SkilledWorkerRegistrationResponse;
import com.skilledservice.ClientService.data.models.SkilledWorker;

public interface SkilledWorkerService {
    Long getNumberOfUsers();

    SkilledWorkerRegistrationResponse registerSkilledWorker(RegistrationRequest registrationRequest);

    AddSkillResponse addSkill(AddSkillRequest addSkillRequest);

    SkilledWorker findById(Long skilledWorkerId);

}
