package models.services;

import com.itextpdf.io.IOException;
import models.general.*;
import models.repositories.Repository;
import models.utils.PDFGenerator;

import java.util.List;
import java.util.Optional;

public class SafetyGuideService {
    private final Repository repository;
    private final PDFGenerator pdfGenerator;

    public SafetyGuideService(Repository repository) {
        this.repository = repository;
        this.pdfGenerator = new PDFGenerator();
    }

    public void generatePDF(String guideId, String outputPath) throws IOException {
        Optional<SafetyGuide> guide = repository.findById(guideId);
        if (guide.isPresent()) {
            try {
                pdfGenerator.generatePDF(guide.get(), outputPath);
            } catch (java.io.IOException e) {
                throw new RuntimeException(e);
            }
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

    public SafetyGuide createBasicGuide(User user) {
        return new BasicSafetyGuide();
    }

    public void updateGuide(SafetyGuide updatedGuide) {
        // Validar que el objeto actualizado no sea nulo
        if (updatedGuide == null) {
            throw new IllegalArgumentException("La guía de seguridad o su ID no pueden ser nulos.");
        }

        // Buscar si la guía existe en el repositorio
        Optional<SafetyGuide> existingGuide = repository.findById(updatedGuide.getId());
        if (existingGuide.isPresent()) {
            // Reemplazar la guía en el repositorio con la versión actualizada
            repository.save(updatedGuide);
        } else {
            throw new IllegalArgumentException("La guía de seguridad con ID " + updatedGuide.getId() + " no existe.");
        }
    }
    public List<SafetyGuide> getAllGuides() {
        return repository.findAll();
    }
    public Optional<SafetyGuide> getGuideById(String guideId) {
        if (guideId == null || guideId.isEmpty()) {
            throw new IllegalArgumentException("El ID de la guía no puede ser nulo o vacío.");
        }
        return repository.findById(guideId);
    }
}