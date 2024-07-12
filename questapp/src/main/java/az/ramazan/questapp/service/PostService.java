package az.ramazan.questapp.service;

import az.ramazan.questapp.entities.Post;
import az.ramazan.questapp.requests.PostCreateRequest;
import az.ramazan.questapp.requests.PostUpdateRequest;
import az.ramazan.questapp.responses.PostResponse;

import java.util.List;
import java.util.Optional;

public interface PostService {
    List<PostResponse> getAllPosts(Optional<Long> userId);
    Post getOnePostById(Long postId);

    PostResponse getOnePostByIdWithLikes(Long postId);

    Post createOnePost(PostCreateRequest newPostRequest);

    Post updateOnePostById(Long postId, PostUpdateRequest updatePost);

    void deleteOnePostById(Long postId);

}
