package ch.csbe.productmanagment.service;

import ch.csbe.productmanagment.model.User;
import ch.csbe.productmanagment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    // Crea un nuevo usuario (equivale a registrar sin validación adicional)
    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    // Actualiza los datos de un usuario
    @Override
    public User update(Long id, User user) {
        User existing = getById(id);
        existing.setUsername(user.getUsername());
        existing.setPassword(user.getPassword());
        existing.setRoles(user.getRoles());
        return userRepository.save(existing);
    }

    // Elimina un usuario por ID
    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    // Busca un usuario por ID
    @Override
    public User getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User with ID " + id + " not found"));
    }

    // Lista todos los usuarios
    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    // Registra un nuevo usuario (podrías agregar validaciones o encriptación de password aquí)
    @Override
    public User register(User user) {
        // Inicializa el rol por defecto si está vacío
        if (user.getRoles() == null || user.getRoles().isEmpty()) {
            user.setRoles(new HashSet<>());
            user.getRoles().add("USER");
        }
        return userRepository.save(user);
    }

    // Promueve un usuario a ADMIN
    @Override
    public void promoteToAdmin(Long userId) {
        User user = getById(userId);
        if (!user.getRoles().contains("ADMIN")) {
            user.getRoles().add("ADMIN");
            userRepository.save(user);
        }
    }

    // Busca por nombre de usuario
    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
