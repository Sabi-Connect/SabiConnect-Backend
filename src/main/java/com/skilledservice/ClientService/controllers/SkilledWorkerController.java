package com.skilledservice.ClientService.controllers;

import com.skilledservice.ClientService.dto.requests.AddSkillRequest;
import com.skilledservice.ClientService.dto.requests.LoginRequest;
import com.skilledservice.ClientService.dto.requests.RegistrationRequest;
import com.skilledservice.ClientService.dto.responses.ApiResponse;
import com.skilledservice.ClientService.services.ServiceUtils.SkilledWorkerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/skilledWorker")
@AllArgsConstructor
public class SkilledWorkerController {

    private final SkilledWorkerService skilledWorkerService;


    @PostMapping("/registerSkilledWorker")
    public ResponseEntity<?> registerSkilledWorker(@RequestBody RegistrationRequest registrationRequest) {
        return ResponseEntity.status(CREATED)
                .body(new ApiResponse
                        (skilledWorkerService.registerSkilledWorker(registrationRequest), true));
    }
    @PostMapping("/addSkill")
    public ResponseEntity<?> addSkill(@RequestBody AddSkillRequest addSkillRequest) {
        return ResponseEntity.status(CREATED)
                .body(new ApiResponse
                        (skilledWorkerService.addSkill(addSkillRequest), true));
    }
    @GetMapping("/findById")
    public ResponseEntity<?> findById(@RequestParam Long skilledWorkerId) {
        return ResponseEntity.ok(skilledWorkerService.findById(skilledWorkerId));
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.status(CREATED)
                .body(new ApiResponse(skilledWorkerService.login(loginRequest), true));
    }
}
