package models.services;

import com.itextpdf.io.IOException;
import models.general.*;
import models.repositories.FileBasedSafetyGuideRepository;
import models.repositories.Repository;
import models.utils.PDFGenerator;

import java.util.ArrayList;
import java.util.Optional;

public class SafetyGuideService {
    private final FileBasedSafetyGuideRepository guidesRepo;
    private final PDFGenerator pdfGenerator;
    private User currentUser;

    public SafetyGuideService(FileBasedSafetyGuideRepository repository) {
        this.guidesRepo = repository;
        this.pdfGenerator = new PDFGenerator();
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

    // Métodos para personalizar el generador de PDF
    public void customizePDFStyles(String titleFont, String headerFont, String normalFont,
                                   float titleSize, float headerSize, float normalSize,
                                   float spacing) throws IOException {
        try {
            pdfGenerator.setTitleFont(titleFont);
            pdfGenerator.setHeaderFont(headerFont);
            pdfGenerator.setNormalFont(normalFont);
            pdfGenerator.setFontSizes(titleSize, headerSize, normalSize);
            pdfGenerator.setSpacing(spacing);
        } catch (java.io.IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateGuide(SafetyGuide updatedGuide) {
        // Validar que el objeto actualizado no sea nulo
        if (updatedGuide == null) {
            throw new IllegalArgumentException("La guía de seguridad o su ID no pueden ser nulos.");
        }

        // Buscar si la guía existe en el repositorio
        ArrayList<SafetyGuide> existingGuide = guidesRepo.findById(updatedGuide.getId());
        if (!(existingGuide.isEmpty())) {
            // Reemplazar la guía en el repositorio con la versión actualizada
            guidesRepo.save(currentUser.getUsername(), updatedGuide);
        } else {
            throw new IllegalArgumentException("La guía de seguridad con ID " + updatedGuide.getId() + " no existe.");
        }
    }

    public ArrayList<ArrayList<SafetyGuide>> getAllGuides() {
        return guidesRepo.findAll();
    }

    public void save(String username, SafetyGuide guide) throws IOException {
        guidesRepo.save(username, guide);
    }

    public void setCurrentUser(User user) { currentUser = user; }
}