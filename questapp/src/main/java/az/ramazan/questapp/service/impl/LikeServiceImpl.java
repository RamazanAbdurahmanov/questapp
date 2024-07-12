package az.ramazan.questapp.service.impl;

import az.ramazan.questapp.entities.Like;
import az.ramazan.questapp.entities.Post;
import az.ramazan.questapp.entities.User;
import az.ramazan.questapp.repository.LikeRepository;
import az.ramazan.questapp.requests.LikeCreateRequest;
import az.ramazan.questapp.responses.LikeResponse;
import az.ramazan.questapp.service.LikeService;
import az.ramazan.questapp.service.PostService;
import az.ramazan.questapp.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LikeServiceImpl implements LikeService {
    private LikeRepository likeRepository;
    private UserService userService;
    private PostService postService;

    public LikeServiceImpl(LikeRepository likeRepository, UserService userService,
                           PostService postService) {
        this.likeRepository = likeRepository;
        this.userService = userService;
        this.postService = postService;
    }

    @Override
    public List<LikeResponse> getAllLikesWithParam(Optional<Long> userId, Optional<Long> postId) {
        List<Like> list;
        if (userId.isPresent() && postId.isPresent()) {
            list = likeRepository.findByUserIdAndPostId(userId.get(), postId.get());
        } else if (userId.isPresent()) {
            list = likeRepository.findByUserId(userId.get());
        } else if (postId.isPresent()) {
            list = likeRepository.findByPostId(postId.get());
        } else
            list = likeRepository.findAll();
        return list.stream().map(like -> new LikeResponse(like)).collect(Collectors.toList());
    }

    @Override
    public Like getOneLikeById(Long likeId) {
        return likeRepository.findById(likeId).orElse(null);
    }

    @Override
    public Like createOneLike(LikeCreateRequest request) {
        User user = userService.getOneUserById(request.getUserId());
        Post post = postService.getOnePostById(request.getPostId());
        if (user != null && post != null) {
            Like likeToSave = new Like();
            likeToSave.setId(request.getId());
            likeToSave.setPost(post);
            likeToSave.setUser(user);
            return likeRepository.save(likeToSave);
        } else
            return null;
    }

    @Override
    public void deleteOneLikeById(Long likeId) {
        likeRepository.deleteById(likeId);

    }
}
