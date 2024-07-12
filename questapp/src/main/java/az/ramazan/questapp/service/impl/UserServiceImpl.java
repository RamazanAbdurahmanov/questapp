package az.ramazan.questapp.service.impl;

import az.ramazan.questapp.entities.User;
import az.ramazan.questapp.repository.CommentRepository;
import az.ramazan.questapp.repository.LikeRepository;
import az.ramazan.questapp.repository.PostRepository;
import az.ramazan.questapp.repository.UserRepository;
import az.ramazan.questapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final LikeRepository likeRepository;
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, LikeRepository likeRepository, CommentRepository commentRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.likeRepository = likeRepository;
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveOneUser(User newUser) {
        return userRepository.save(newUser);
    }

    @Override
    public User getOneUserById(Long userId) {

        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public User updateOneUser(Long userId, User newUser) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            User foundUser = user.get();
            foundUser.setUsername(newUser.getUsername());
            foundUser.setPassword(newUser.getPassword());
            foundUser.setAvatar(newUser.getAvatar());
            return foundUser;
        } else {
            return null;
        }

    }

    @Override
    public void deleteById(Long userId) {
        try {
            userRepository.deleteById(userId);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("User " + userId + " doesn't exist");
        }
    }

    @Override
    public User getOneUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<Object> getUserActivity(Long userId) {
        List<Long> postIds = postRepository.findTopByUserId(userId);
        if (postIds.isEmpty())
            return null;
        List<Object> comments = commentRepository.findUserCommentsByPostId(postIds);
        List<Object> likes = likeRepository.findUserLikesByPostId(postIds);
        List<Object> result = new ArrayList<>();
        result.addAll(comments);
        result.addAll(likes);
        return result;
    }
}
