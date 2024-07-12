package az.ramazan.questapp.service;

import az.ramazan.questapp.entities.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User saveOneUser(User newUser);
    User getOneUserById(Long userId);
    User updateOneUser(Long userId,User newUser);
    void deleteById(Long userId);
    User getOneUserByUsername(String username);
    List<Object> getUserActivity(Long userId);

}
