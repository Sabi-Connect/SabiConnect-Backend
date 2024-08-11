package com.skilledservice.ClientService.dto.response;

import com.skilledservice.ClientService.models.Category;
import com.skilledservice.ClientService.models.User;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddSkillResponse {
    private Long skillId;
    private Long skilledWorkerId;
    private Category category;
    private String skillName;
}
