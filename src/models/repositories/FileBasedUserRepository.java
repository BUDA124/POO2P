package models.repositories;

import models.general.User;
import models.utils.FileHandler;
import java.util.*;

public class FileBasedUserRepository implements Repository<User> {
    private HashMap<String, User> users;

    public FileBasedUserRepository() {
        this.users = new HashMap<>();
        loadUsers();
    }

    private void loadUsers() {
        users = FileHandler.loadUsers();
    }

    private void saveUsers() {
        FileHandler.saveUsers(users);
    }

    public User save(String username, User user) {
        users.put(user.getId(), user);
        saveUsers();
        return user;
    }

    @Override
    public Optional<User> findById(String username) {
        return Optional.ofNullable(users.get(username));
    }

    @Override
    public ArrayList<User> findAll() {
        return new ArrayList<>(users.values());
    }

    @Override
    public void delete(String id) {
        users.remove(id);
        saveUsers();
    }

    public Optional<User> findByUsername(String username) {
        return users.values().stream()
            .filter(user -> user.getUsername().equals(username))
            .findFirst();
    }

    public boolean existsByUsername(String username) {
        return users.values().stream()
            .anyMatch(user -> user.getUsername().equals(username));
    }
}