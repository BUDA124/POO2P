package repositories;

import models.SafetyGuide;
import utils.FileHandler;
import java.util.*;

public class FileBasedSafetyGuideRepository implements SafetyGuideRepository {
    private Map<String, SafetyGuide> guides;

    public FileBasedSafetyGuideRepository() {
        this.guides = new HashMap<>();
        loadGuides();
    }

    private void loadGuides() {
        List<SafetyGuide> loadedGuides = FileHandler.loadGuides();
        loadedGuides.forEach(guide -> guides.put(guide.getId(), guide));
    }

    private void saveGuides() {
        FileHandler.saveGuides(new ArrayList<>(guides.values()));
    }

    @Override
    public SafetyGuide save(SafetyGuide guide) {
        guides.put(guide.getId(), guide);
        saveGuides();
        return guide;
    }

    @Override
    public Optional<SafetyGuide> findById(String id) {
        return Optional.ofNullable(guides.get(id));
    }

    @Override
    public List<SafetyGuide> findAll() {
        return new ArrayList<>(guides.values());
    }

    @Override
    public void delete(String id) {
        guides.remove(id);
        saveGuides();
    }
}