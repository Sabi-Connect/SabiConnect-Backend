package com.skilledservice.ClientService.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EditReviewRequest {
    private Long reviewId;
    private Long clientId;
    private String review;
}
