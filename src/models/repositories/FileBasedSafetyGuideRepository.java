package models.repositories;

import models.general.SafetyGuide;
import models.utils.FileHandler;
import java.util.ArrayList;
import java.util.*;

public class FileBasedSafetyGuideRepository {
    private HashMap<String, ArrayList<SafetyGuide>> guides;

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

    public void save(String username, SafetyGuide guide) {
        guides.compute(username, (k, currentGuides) -> currentGuides);
        saveGuides();
    }

    public ArrayList<SafetyGuide> findById(String username) {
        return guides.get(username);
    }

    public ArrayList<ArrayList<SafetyGuide>> findAll() {
        return (ArrayList<ArrayList<SafetyGuide>>) guides.values();
    }

    public ArrayList<SafetyGuide> findGuideById(String username) {
        return guides.get(username);
    }

    public ArrayList<ArrayList<SafetyGuide>> findAllGuides() {
        return new ArrayList<>(guides.values());
    }

    public void delete(String id) {
        guides.remove(id);
        saveGuides();
    }
}