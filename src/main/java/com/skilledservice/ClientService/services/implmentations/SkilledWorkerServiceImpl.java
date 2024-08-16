package com.skilledservice.ClientService.services.implmentations;

import com.skilledservice.ClientService.data.models.Address;
import com.skilledservice.ClientService.data.models.Appointment;
import com.skilledservice.ClientService.dto.requests.AcceptAppointmentRequest;
import com.skilledservice.ClientService.dto.requests.AddSkillRequest;
import com.skilledservice.ClientService.dto.requests.LoginRequest;
import com.skilledservice.ClientService.dto.requests.RegistrationRequest;
import com.skilledservice.ClientService.dto.responses.AcceptAppointmentResponse;
import com.skilledservice.ClientService.dto.responses.AddSkillResponse;
import com.skilledservice.ClientService.dto.responses.LoginResponse;
import com.skilledservice.ClientService.dto.responses.SkilledWorkerRegistrationResponse;
import com.skilledservice.ClientService.exceptions.InvalidEmailFoundException;
import com.skilledservice.ClientService.exceptions.InvalidPasswordException;
import com.skilledservice.ClientService.exceptions.SabiConnectException;
import com.skilledservice.ClientService.data.models.SkilledWorker;
import com.skilledservice.ClientService.data.repository.SkilledWorkerRepository;
import com.skilledservice.ClientService.services.ServiceUtils.AppointmentService;
import com.skilledservice.ClientService.services.ServiceUtils.SkillService;
import com.skilledservice.ClientService.services.ServiceUtils.SkilledWorkerService;
import com.skilledservice.ClientService.utils.JwtUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SkilledWorkerServiceImpl implements SkilledWorkerService {

    private final SkillService skillService;
    private final PasswordEncoder passwordEncoder;
    private final SkilledWorkerRepository skilledWorkerRepository;
    private final AddressServiceImpl addressService;
    private final AppointmentService appointmentService;

    @Autowired
    @Lazy
    public SkilledWorkerServiceImpl(SkillService skillService, PasswordEncoder passwordEncoder, SkilledWorkerRepository skilledWorkerRepository, AddressServiceImpl addressService, AppointmentService appointmentService) {
        this.skillService = skillService;
        this.passwordEncoder = passwordEncoder;
        this.skilledWorkerRepository = skilledWorkerRepository;
        this.addressService = addressService;
        this.appointmentService = appointmentService;
    }

    @Override
    public Long getNumberOfUsers() {
        return skilledWorkerRepository.count();
    }

    @Override
    public SkilledWorkerRegistrationResponse registerSkilledWorker(RegistrationRequest registrationRequest) {
        validateEmail(registrationRequest.getEmail());
        validatePassword(registrationRequest.getPassword());

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

    @Override
    public AcceptAppointmentResponse acceptAppointment(AcceptAppointmentRequest acceptAppointmentRequest) {
        SkilledWorker skilledWorker = skilledWorkerRepository.findById(acceptAppointmentRequest.getId())
                .orElseThrow(()-> new SabiConnectException("user not found"));
        Appointment appointment = appointmentService.findAppointmentById(acceptAppointmentRequest.getId())
                .orElseThrow(()-> new SabiConnectException("appointment not found"));
        skilledWorker.getAppointment().add(appointment);
        return appointmentService.acceptAppointment(acceptAppointmentRequest);
    }

    private void validateEmail(String email) {
        if (!email.matches( "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            throw new InvalidEmailFoundException("Invalid Email");
        }
    }
    private static  void validatePassword(String password){
        if (password.length() < 8) {
            throw new InvalidPasswordException("Password does not meet complexity requirements");
        }
        if (!password.matches("[a-zA-Z0-9]*")) {
            throw new InvalidPasswordException("Password must be alphanumeric");
        }
        if (!password.matches(".*\\d.*")) {
            throw new InvalidPasswordException("Password must contain at least one digit");
        }
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();
        return checkLoginDetail(email, password);
    }

    private LoginResponse checkLoginDetail(String email, String password) {
        Optional<SkilledWorker> foundSkilledWorker = skilledWorkerRepository.findByEmail(email);
        if (foundSkilledWorker.isPresent()){
            SkilledWorker skilledWorker = foundSkilledWorker.get();
            if (skilledWorker.getPassword().equals(password)) {
                return loginResponseMapper(skilledWorker);
            } else {
                throw new SabiConnectException("Invalid username or password");
            }
        } else {
            throw new SabiConnectException("Invalid username or password");
        }
    }

    private LoginResponse loginResponseMapper(SkilledWorker skilledWorker) {
        LoginResponse loginResponse = new LoginResponse();
        String accessToken = JwtUtils.generateAccessToken(skilledWorker.getId());
        BeanUtils.copyProperties(skilledWorker, loginResponse);
        loginResponse.setJwtToken(accessToken);
        loginResponse.setMessage("Login Successful");

        return loginResponse;
    }


}

