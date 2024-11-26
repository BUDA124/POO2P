package repositories;

import models.SafetyGuide;
import java.util.List;
import java.util.Optional;

public interface SafetyGuideRepository {
    SafetyGuide save(SafetyGuide guide);
    Optional<SafetyGuide> findById(String id);
    List<SafetyGuide> findAll();
    void delete(String id);
}