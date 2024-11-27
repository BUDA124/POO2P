package models.repositories;

import models.general.User;
import models.utils.FileHandler;
import java.util.*;

public class FileBasedUserRepository {
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

    public void save(String username, User user) {
        users.put(user.getUsername(), user);
        saveUsers();
    }

    public Optional<User> findByUsername(String username) {
        return Optional.ofNullable(users.get(username));
    }

    public void delete(String id) {
        users.remove(id);
        saveUsers();
    }

    public HashMap<String, User> getUsers() {
        return users;
    }
}