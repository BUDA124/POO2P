package repositories;

import models.User;
import utils.FileHandler;
import java.util.*;

public class FileBasedUserRepository implements UserRepository {
    private Map<String, User> users;

    public FileBasedUserRepository() {
        this.users = new HashMap<>();
        loadUsers();
    }

    private void loadUsers() {
        List<User> loadedUsers = FileHandler.loadUsers();
        loadedUsers.forEach(user -> users.put(user.getId(), user));
    }

    private void saveUsers() {
        FileHandler.saveUsers(new ArrayList<>(users.values()));
    }

    @Override
    public User save(User user) {
        users.put(user.getId(), user);
        saveUsers();
        return user;
    }

    @Override
    public Optional<User> findById(String id) {
        return Optional.ofNullable(users.get(id));
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    @Override
    public void delete(String id) {
        users.remove(id);
        saveUsers();
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return users.values().stream()
            .filter(user -> user.getUsername().equals(username))
            .findFirst();
    }

    @Override
    public boolean existsByUsername(String username) {
        return users.values().stream()
            .anyMatch(user -> user.getUsername().equals(username));
    }
}