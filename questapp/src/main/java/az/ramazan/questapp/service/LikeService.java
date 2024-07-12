package az.ramazan.questapp.service;

import az.ramazan.questapp.entities.Like;
import az.ramazan.questapp.requests.LikeCreateRequest;
import az.ramazan.questapp.responses.LikeResponse;

import java.util.List;
import java.util.Optional;

public interface LikeService {
    List<LikeResponse> getAllLikesWithParam(Optional<Long> userId, Optional<Long> postId);

    Like getOneLikeById(Long likeId);

    Like createOneLike(LikeCreateRequest request);

    void deleteOneLikeById(Long likeId);
}
