package com.skilledservice.ClientService.controllers;

import com.skilledservice.ClientService.dto.requests.*;
import com.skilledservice.ClientService.dto.responses.ApiResponse;
import com.skilledservice.ClientService.services.ServiceUtils.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/client")
@AllArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping("/bookAppointment")
    public ResponseEntity<?>bookAppointment(@RequestBody BookAppointmentRequest bookAppointmentRequest){
        return ResponseEntity.status(CREATED)
                .body(new ApiResponse
                        (clientService.bookAppointment(bookAppointmentRequest),true));
    }

    @PostMapping("/registerClient")
    public ResponseEntity<?> registerClient(@RequestBody RegistrationRequest registrationRequest){
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
        return ResponseEntity.status(CREATED)
               .body(new ApiResponse
                        (clientService.viewAllAppointment(clientId),true));
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        System.out.println(loginRequest.getEmail()+"😊😊😊😊😊😊😊😊😊");
        System.out.println(loginRequest.getPassword()+"😊😊😊😊😊😊😊😊😊");
        return ResponseEntity.status(CREATED)
                .body(new ApiResponse(clientService.login(loginRequest),true));
    }






}
