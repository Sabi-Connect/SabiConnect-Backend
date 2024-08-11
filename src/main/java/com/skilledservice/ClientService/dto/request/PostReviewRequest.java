package com.skilledservice.ClientService.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PostReviewRequest {
    private Long clientId;
    private Long skilledWorkerId;
    private String review;
}
