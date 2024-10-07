package com.skilledservice.ClientService.dto.requests;

import com.skilledservice.ClientService.data.constants.Category;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class AvailabilityRequest {
    private LocalDateTime scheduleTime;
    private Category category;
}
