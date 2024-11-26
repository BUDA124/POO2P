package models.repositories;

import java.util.List;
import java.util.Optional;

public interface Repository<E> {
    E save(E object);
    Optional<E> findById(String id);
    List<E> findAll();
    void delete(String id);
}