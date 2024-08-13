package com.skilledservice.ClientService.dto.requests;

import com.skilledservice.ClientService.data.constants.Category;
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
