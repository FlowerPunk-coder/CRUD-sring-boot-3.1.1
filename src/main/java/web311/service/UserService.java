package web311.service;

import web311.entity.User;

import java.util.List;


public interface UserService {

    List<User> getAllUsers();
    void saveUser(User user);
    User getUserById(long id);
    void removeUser(long id);
}
