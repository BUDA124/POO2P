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

    public void generatePDF(String guideId, String outputPath) throws IOException {
        ArrayList<SafetyGuide> guide = guidesRepo.findById(guideId);
        if (!(guide.isEmpty())) {
            // pdfGenerator.generatePDF(guide.get(currentUser.getUsername()), outputPath);
        } else {
            throw new IllegalArgumentException("Guía no encontrada.");
        }
    }

    public ArrayList<ArrayList<SafetyGuide>> getAllGuides() {
        return guidesRepo.findAll();
    }

    public void save(String username, SafetyGuide guide) throws IOException {
        guidesRepo.saveNewGuide(username, guide);
    }

    public void createArrayForUser(String username) {
        guidesRepo.createArraySpace(username);
    }
}