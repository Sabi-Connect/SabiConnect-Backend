package com.skilledservice.ClientService.dto.requests;

import com.skilledservice.ClientService.data.models.SkilledWorker;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PostReviewRequest {
    private SkilledWorker skilledWorker;
    private String review;
}
