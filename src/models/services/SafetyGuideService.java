package models.services;

import com.itextpdf.io.IOException;
import models.general.*;
import models.repositories.FileBasedSafetyGuideRepository;
import models.utils.PDFGenerator;

import java.util.ArrayList;

public class SafetyGuideService {
    private final FileBasedSafetyGuideRepository guidesRepo;


    public SafetyGuideService(FileBasedSafetyGuideRepository repository) {
        this.guidesRepo = repository;
    }

    public ArrayList<SafetyGuide> findById(String username) {
        return guidesRepo.findById(username);
    }

    public void save(String username, SafetyGuide guide) throws IOException {
        guidesRepo.saveNewGuide(username, guide);
    }

    public void createArrayForUser(String username) {
        guidesRepo.createArraySpace(username);
    }

    public void delete(String username, SafetyGuide guide) {
        guidesRepo.delete(username, guide);
    }
}