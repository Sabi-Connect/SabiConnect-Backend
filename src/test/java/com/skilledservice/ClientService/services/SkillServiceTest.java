package com.skilledservice.ClientService.services;

import com.skilledservice.ClientService.dto.request.AddSkillRequest;
import com.skilledservice.ClientService.dto.request.SkilledWorkerRegistrationRequest;
import com.skilledservice.ClientService.dto.response.AddSkillResponse;
import com.skilledservice.ClientService.dto.response.SkilledWorkerRegistrationResponse;
import com.skilledservice.ClientService.exceptions.ProjectException;
import com.skilledservice.ClientService.models.Address;
import com.skilledservice.ClientService.models.Category;
import com.skilledservice.ClientService.models.Skill;
import com.skilledservice.ClientService.repository.AddressRepository;
import com.skilledservice.ClientService.repository.SkillRepository;
import com.skilledservice.ClientService.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SkillServiceTest {
    @Autowired
    private SkilledWorkerService skilledWorkerService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    private SkillServiceImpl skillServiceImpl;
    @Autowired
    private AddressRepository addressRepository;

    @Test
    public void addSkillTest() {
        Address address = new Address();
        address.setHouseNumber("312");
        address.setStreet("Herbert Macaulay Way");
        address.setArea("Yaba");

        SkilledWorkerRegistrationRequest registrationRequest = new SkilledWorkerRegistrationRequest();
        registrationRequest.setFirstName("Fitzgerald");
        registrationRequest.setLastName("McDonald");
        registrationRequest.setEmail("fitzgerald@gmail.com");
        registrationRequest.setPassword("password");
        registrationRequest.setPhoneNumber("1234567890");
        address = addressRepository.save(address);
        registrationRequest.setAddress(address);
        SkilledWorkerRegistrationResponse response = skilledWorkerService.registerSkilledWorker(registrationRequest);
        assertThat(skilledWorkerService.getNumberOfUsers()).isEqualTo(1L);
        assertThat(response).isNotNull();

        AddSkillRequest addSkillRequest = new AddSkillRequest();
        addSkillRequest.setSkilledWorkerId(response.getSkilledWorkerId());
        addSkillRequest.setCategory(Category.ELECTRICAL);
        addSkillRequest.setSkillName("Electronics Electrician");
        AddSkillResponse skillResponse = skillServiceImpl.addSkill(addSkillRequest);
        Skill skill = skillRepository.findById(skillResponse.getSkilledWorkerId())
                .orElseThrow(()-> new ProjectException("user does not exist"));
        assertThat(skill.getSkillName()).isEqualTo("Electronics Electrician");
        assertThat(skill.getSkilledWorker().getId()).isEqualTo(response.getSkilledWorkerId());
    }

    @Test
    public void addMoreThatOneSkillTest() {
        Address address = new Address();
        address.setHouseNumber("312");
        address.setStreet("Herbert Macaulay Way");
        address.setArea("Yaba");

        SkilledWorkerRegistrationRequest registrationRequest = new SkilledWorkerRegistrationRequest();
        registrationRequest.setFirstName("Fitzgerald");
        registrationRequest.setLastName("McDonald");
        registrationRequest.setEmail("fitzgerald@gmail.com");
        registrationRequest.setPassword("password");
        registrationRequest.setPhoneNumber("1234567890");
        address = addressRepository.save(address);
        registrationRequest.setAddress(address);
        SkilledWorkerRegistrationResponse response = skilledWorkerService.registerSkilledWorker(registrationRequest);
        assertThat(skilledWorkerService.getNumberOfUsers()).isEqualTo(1L);
        assertThat(response).isNotNull();

        AddSkillRequest addSkillRequest = new AddSkillRequest();
        addSkillRequest.setSkilledWorkerId(response.getSkilledWorkerId());
        addSkillRequest.setCategory(Category.ELECTRICAL);
        addSkillRequest.setSkillName("Electronics Electrician");
        AddSkillResponse skillResponse = skillServiceImpl.addSkill(addSkillRequest);

        AddSkillRequest addSkillRequest1 = new AddSkillRequest();
        addSkillRequest1.setSkilledWorkerId(response.getSkilledWorkerId());
        addSkillRequest1.setCategory(Category.CARPENTRY);
        addSkillRequest1.setSkillName("Carpenter");
        AddSkillResponse skillResponse1 = skillServiceImpl.addSkill(addSkillRequest1);

        var skills = skillRepository.findSkillBySkillWorkerId(skillResponse.getSkilledWorkerId());
        assertThat(skills.size()).isEqualTo(2L);
        assertThat(skills.get(1).getSkillName()).isEqualTo("Carpenter");
        assertThat(skills.get(0).getSkillName()).isEqualTo("Electronics Electrician");
        assertThat(skills.get(1).getSkilledWorker().getId()).isEqualTo(response.getSkilledWorkerId());
//        assertThat(skill.getSkilledWorker().getId()).isEqualTo(2L);
    }

    @Test
    public void editSkillTest() {
        
    }

}
