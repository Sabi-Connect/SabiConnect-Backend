package com.skilledservice.ClientService.services.ServiceUtils;

import com.skilledservice.ClientService.dto.requests.PostReviewRequest;
import com.skilledservice.ClientService.dto.responses.PostReviewResponse;

public interface ReviewService {
    PostReviewResponse addReview(PostReviewRequest postReview);
}
