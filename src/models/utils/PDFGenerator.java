package models.utils;

import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.TextAlignment;
import models.general.BasicSafetyGuide;
import models.general.CustomSafetyGuide;
import models.general.SafetyGuide;
import models.general.User;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;

public class PDFGenerator {
    private static final String FONTS_PATH = "src/models/utils/fonts/";

    // Estilos personalizables
    private PdfFont titleFont;
    private PdfFont headerFont;
    private PdfFont normalFont;
    private final float headerSize = 16f;
    private final float normalSize = 12f;
    private final float spacing = 20f;

    public PDFGenerator() {
        try {
            titleFont = PdfFontFactory.createFont(FONTS_PATH + "Roboto-Bold.ttf");
            headerFont = PdfFontFactory.createFont(FONTS_PATH + "Roboto-Medium.ttf");
            normalFont = PdfFontFactory.createFont(FONTS_PATH + "Roboto-Regular.ttf");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generatePDF(User user, SafetyGuide guide) throws IOException {
        // Obtener la ruta de la carpeta de descargas
        String downloadsFolder = getDownloadsFolder();
        if (downloadsFolder == null) {
            throw new IOException("No se pudo determinar la carpeta de descargas.");
        }

        // Definir el nombre del archivo
        String fileName = "Guia_Seguridad_" + guide.getId() + ".pdf";
        String outputPath = Paths.get(downloadsFolder, fileName).toString();

        // Crear el archivo PDF
        PdfWriter writer = new PdfWriter(outputPath);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf, PageSize.A4);
        document.setMargins(36, 36, 36, 36);

        // Generar contenido del PDF
        addHeader(document, guide);
        addUserInformation(document, user);
        addGuideDetails(document, guide); // Nueva sección
        addFooter(document, guide);

        document.close();

        System.out.println("PDF generado exitosamente en: " + outputPath);
    }

    private void addGuideDetails(Document document, SafetyGuide guide) {
        // Título de la sección
        document.add(new Paragraph("Detalles de la Guía de Seguridad")
                .setFont(headerFont)
                .setFontSize(headerSize)
                .setBold());
        document.add(new Paragraph().setHeight(spacing / 2));

        if (guide instanceof BasicSafetyGuide basicGuide) {

            document.add(new Paragraph("Riesgos generales:")
                    .setFont(headerFont)
                    .setFontSize(headerSize));
            basicGuide.getRisks().forEach(risk ->
                    document.add(new Paragraph("- " + risk).setFont(normalFont).setFontSize(normalSize))
            );

            document.add(new Paragraph("Prevenciones generales:")
                    .setFont(headerFont)
                    .setFontSize(headerSize));
            basicGuide.getPreventions().forEach(prevention ->
                    document.add(new Paragraph("- " + prevention).setFont(normalFont).setFontSize(normalSize))
            );

        } else if (guide instanceof CustomSafetyGuide customGuide) {

            document.add(new Paragraph("Riesgos personalizados:")
                    .setFont(headerFont)
                    .setFontSize(headerSize));
            customGuide.getRisks().forEach(customRisk ->
                    document.add(new Paragraph("- " + customRisk).setFont(normalFont).setFontSize(normalSize))
            );

            document.add(new Paragraph("Prevenciones específicas:")
                    .setFont(headerFont)
                    .setFontSize(headerSize));
            customGuide.getPreventions().forEach(customPrevention ->
                    document.add(new Paragraph("- " + customPrevention).setFont(normalFont).setFontSize(normalSize))
            );
        }

        document.add(new Paragraph().setHeight(spacing));
    }



    private void addHeader(Document document, SafetyGuide guide) {
        float titleSize = 24f;
        String tempTitle = guide.getTitle();
        Paragraph title = new Paragraph(tempTitle)
                .setFont(titleFont)
                .setFontSize(titleSize)
                .setTextAlignment(TextAlignment.CENTER)
                .setBold();
        document.add(title);

        Paragraph date = new Paragraph("Fecha de creación: " +
                guide.getCreationDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")))
                .setFont(normalFont)
                .setFontSize(normalSize)
                .setTextAlignment(TextAlignment.RIGHT);
        document.add(date);

        document.add(new Paragraph().setHeight(spacing));
    }

    private void addUserInformation(Document document, User user) {
        document.add(new Paragraph("Información del Usuario")
                .setFont(headerFont)
                .setFontSize(headerSize));
        document.add(new Paragraph("Nombre: " + user.getName()).setFont(normalFont).setFontSize(normalSize));
        document.add(new Paragraph().setHeight(spacing));
    }

    private void addFooter(Document document, SafetyGuide guide) {
        document.add(new Paragraph()
                .add("ID de la guía: " + guide.getId())
                .setFont(normalFont)
                .setFontSize(10f)
                .setTextAlignment(TextAlignment.RIGHT));
    }

    private String getDownloadsFolder() {
        String home = System.getProperty("user.home");
        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("win")) {
            return Paths.get(home, "Downloads").toString();
        } else if (os.contains("mac")) {
            return Paths.get(home, "Downloads").toString();
        } else if (os.contains("nix") || os.contains("nux")) {
            return Paths.get(home, "Descargas").toString();
        } else {
            return null;
        }
    }
}