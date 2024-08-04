package com.skilledservice.ClientService.dto.request;

import com.skilledservice.ClientService.models.Category;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddSkillRequest {
    private Long skillId;
    private Long skilledWorkerId;
    private String skillName;
    private Category category;

}
