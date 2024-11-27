package models.repositories;

import java.util.ArrayList;
import java.util.Optional;

public interface Repository<E> {
    E save(String username, E object);
    Optional<E> findById(String id);
    ArrayList<E> findAll();
    void delete(String id);
}