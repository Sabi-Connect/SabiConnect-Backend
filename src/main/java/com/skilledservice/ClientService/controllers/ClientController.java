package com.skilledservice.ClientService.controllers;

import com.skilledservice.ClientService.dto.requests.*;
import com.skilledservice.ClientService.dto.responses.ApiResponse;
import com.skilledservice.ClientService.services.ServiceUtils.ClientService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.CREATED;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/client")
@AllArgsConstructor
public class ClientController {

    private static final Logger log = LoggerFactory.getLogger(ClientController.class);
    private final ClientService clientService;

    @PostMapping("/bookAppointment")
    public ResponseEntity<?>bookAppointment(@RequestBody BookAppointmentRequest bookAppointmentRequest){
        return ResponseEntity.status(CREATED)
                .body(new ApiResponse
                        (clientService.bookAppointment(bookAppointmentRequest),true));
    }

    @PostMapping("/registerClient")
    public ResponseEntity<?> registerClient(@RequestBody RegistrationRequest registrationRequest){
//        log.info("Registering Client => {}", registrationRequest.toString());
        return ResponseEntity.status(CREATED)
               .body(new ApiResponse
                        (clientService.registerClient(registrationRequest),true));
    }
    @PutMapping("/cancelAppointment")
    public ResponseEntity<?> cancelAppointment(@RequestParam Long appointmentId, CancelAppointmentRequest request){
        return ResponseEntity.status(CREATED)
               .body(new ApiResponse
                        (clientService.cancelAppointment(appointmentId,request),true));
    }

    @PutMapping("/updateAppointment")
    public ResponseEntity<?> updateAppointment(@RequestParam Long appointmentId, @RequestBody UpdateAppointmentRequest request){
        return ResponseEntity.status(CREATED)
               .body(new ApiResponse
                        (clientService.updateAppointment(appointmentId, request),true));
    }
    @DeleteMapping("/deleteAppointment")
    public ResponseEntity<?> deleteAppointment(@RequestParam Long appointmentId,@RequestBody DeleteAppointmentRequest request){
        return ResponseEntity.status(CREATED)
               .body(new ApiResponse
                        (clientService.deleteAppointment(appointmentId,request),true));
    }

    @GetMapping("/viewAllAppointment")
    public ResponseEntity<?> viewAllAppointment(@RequestParam Long clientId){
        System.out.println("Received clientId: " + clientId);
        return ResponseEntity.status(CREATED)
               .body(new ApiResponse
                        (clientService.viewAllAppointment(clientId),true));
    }

    @PutMapping("/updateClientProfile")
    public ResponseEntity<?> updateClientProfile(@RequestBody UpdateClientRequest request) {
        return ResponseEntity
                .ok(new ApiResponse(clientService.updateClientProfile(request), true));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.status(CREATED)
                .body(new ApiResponse(clientService.login(loginRequest),true));
    }
    
}
