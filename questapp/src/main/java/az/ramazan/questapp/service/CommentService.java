package az.ramazan.questapp.service;

import az.ramazan.questapp.entities.Comment;
import az.ramazan.questapp.requests.CommentCreateRequest;
import az.ramazan.questapp.requests.CommentUpdateRequest;
import az.ramazan.questapp.responses.CommentResponse;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    List<CommentResponse> getAllCommentsWithParam(Optional<Long> userId, Optional<Long> postId);

    Comment getOneCommentById(Long commentId);

    Comment createOneComment(CommentCreateRequest request);

    Comment updateOneCommentById(Long commentId, CommentUpdateRequest request);

    void deleteOneCommentById(Long commentId);

}
