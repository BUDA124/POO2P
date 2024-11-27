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

    public void saveNewGuide(String username, SafetyGuide guide) {
        guides.get(username).add(guide);
        saveGuides();
    }

    public void createArraySpace(String username) {
        guides.put(username, new ArrayList<>());
        saveGuides();
    }

    public ArrayList<SafetyGuide> findById(String username) {
        return guides.get(username);
    }

    public ArrayList<ArrayList<SafetyGuide>> findAll() {
        return (ArrayList<ArrayList<SafetyGuide>>) guides.values();
    }

    public void delete(String username) {
        guides.remove(username);
        saveGuides();
    }
}