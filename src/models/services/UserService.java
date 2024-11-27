package models.services;

import com.itextpdf.io.IOException;
import models.general.User;
import models.repositories.FileBasedUserRepository;
import java.util.HashMap;
import java.util.Optional;

public class UserService {
    private final FileBasedUserRepository userRepository;

    public UserService(FileBasedUserRepository repository) {
        this.userRepository = repository;
    }

    public Optional<User> findById(String username) {
        return userRepository.findByUsername(username);
    }

    public void save(User user) throws IOException {
        userRepository.save(user.getUsername(), user);
    }

    public HashMap<String, User> findAll() {
        return userRepository.getUsers();
    }
}

