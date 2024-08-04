package com.skilledservice.ClientService.dto.response;

import com.skilledservice.ClientService.models.Category;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddSkillResponse {
    private Long skilledWorkerId;
    private Category category;
    private String skillName;
}
