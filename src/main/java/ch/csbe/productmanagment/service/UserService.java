package ch.csbe.productmanagment.service;

import ch.csbe.productmanagment.model.User;

import java.util.List;

public interface UserService {
    User create(User user);
    User update(Long id, User user);
    void delete(Long id);

    User getById(Long id);
    List<User> getAll();

    User register(User user);
    void promoteToAdmin(Long userId);
    User findByUsername(String username);
}
