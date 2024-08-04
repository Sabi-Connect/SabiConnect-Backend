package com.skilledservice.ClientService.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PostReviewResponse {
    private Long postId;
    private Long clientId;
    private String reviewerId;
    private String review;
}
