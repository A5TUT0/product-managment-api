package ch.csbe.productmanagment.service;

import ch.csbe.productmanagment.model.User;

import java.util.List;

public interface UserService {
    User register(User user);
    User getById(Long id);
    List<User> getAll();
    void promoteToAdmin(Long userId);
    User findByUsername(String username);
}
