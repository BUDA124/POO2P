package models.repositories;

import models.general.SafetyGuide;
import models.utils.FileHandler;
import java.util.*;

public class FileBasedSafetyGuideRepository implements Repository<SafetyGuide> {
    private HashMap<String, SafetyGuide> guides;

    public FileBasedSafetyGuideRepository() {
        this.guides = new HashMap<>();
        loadGuides();
    }

    private void loadGuides() {
        guides = FileHandler.loadGuides();
    }

    private void saveGuides() {
        FileHandler.saveGuides(guides);
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