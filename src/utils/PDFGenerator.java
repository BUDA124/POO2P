package utils;

import com.itextpdf.layout.property.TextAlignment;
import models.*;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.kernel.geom.PageSize;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class PDFGenerator {
    private static final String FONTS_PATH = "src/main/resources/fonts/";

    // Estilos personalizables
    private PdfFont titleFont;
    private PdfFont headerFont;
    private PdfFont normalFont;
    private float titleSize = 24f;
    private float headerSize = 16f;
    private float normalSize = 12f;
    private float spacing = 20f;

    public PDFGenerator() {
        try {
            // Puedes cambiar las fuentes según tus preferencias
            titleFont = PdfFontFactory.createFont(FONTS_PATH + "Roboto-Bold.ttf");
            headerFont = PdfFontFactory.createFont(FONTS_PATH + "Roboto-Medium.ttf");
            normalFont = PdfFontFactory.createFont(FONTS_PATH + "Roboto-Regular.ttf");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Métodos para personalizar estilos
    public void setTitleFont(String fontPath) throws IOException {
        this.titleFont = PdfFontFactory.createFont(FONTS_PATH + fontPath);
    }

    public void setHeaderFont(String fontPath) throws IOException {
        this.headerFont = PdfFontFactory.createFont(FONTS_PATH + fontPath);
    }

    public void setNormalFont(String fontPath) throws IOException {
        this.normalFont = PdfFontFactory.createFont(FONTS_PATH + fontPath);
    }

    public void setFontSizes(float titleSize, float headerSize, float normalSize) {
        this.titleSize = titleSize;
        this.headerSize = headerSize;
        this.normalSize = normalSize;
    }

    public void setSpacing(float spacing) {
        this.spacing = spacing;
    }

    public void generatePDF(SafetyGuide guide, String outputPath) throws IOException {
        PdfWriter writer = new PdfWriter(outputPath);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf, PageSize.A4);
        document.setMargins(36, 36, 36, 36);

        addHeader(document, guide);
        addUserInformation(document, guide.getUser());
        addFooter(document, guide);

        document.close();
    }

    private void addHeader(Document document, SafetyGuide guide) {
        Paragraph title = new Paragraph("Guía de Seguridad")
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
        Table userTable = new Table(2).useAllAvailableWidth();

        // Estilo para la tabla
        userTable.setBorder(new SolidBorder(ColorConstants.GRAY, 1));
        userTable.setBackgroundColor(ColorConstants.LIGHT_GRAY, 0.2f);

        // Título de la sección
        Cell titleCell = new Cell(1, 2)
                .add(new Paragraph("Información del Usuario")
                        .setFont(headerFont)
                        .setFontSize(headerSize))
                .setBorder(new SolidBorder(ColorConstants.GRAY, 1));
        userTable.addCell(titleCell);

        // Datos del usuario
        addTableRow(userTable, "Nombre:", user.getName());
        addTableRow(userTable, "Rol:", user.getRole());
        addTableRow(userTable, "Empresa:", user.getCompany());
        addTableRow(userTable, "Contacto:", user.getContactInfo());

        document.add(userTable);
        document.add(new Paragraph().setHeight(spacing));
    }

    private void addChecklist(Document document, List<SafetyRequirement> checklist) {
        document.add(new Paragraph("Lista de Comprobación")
                .setFont(headerFont)
                .setFontSize(headerSize));

        Table checklistTable = new Table(new float[]{20f, 60f, 20f}).useAllAvailableWidth();

        // Encabezados
        addTableHeaderCell(checklistTable, "No.");
        addTableHeaderCell(checklistTable, "Requerimiento");
        addTableHeaderCell(checklistTable, "Estado");

        // Items
        for (int i = 0; i < checklist.size(); i++) {
            SafetyRequirement req = checklist.get(i);
            addTableCell(checklistTable, String.valueOf(i + 1));
            addTableCell(checklistTable, req.getDescription() +
                    (req.isRequired() ? " *" : ""));
            addTableCell(checklistTable, req.isCompleted() ? "✓" : "□");
        }

        document.add(checklistTable);
        document.add(new Paragraph().setHeight(spacing));
    }

    private void addFeedbackSection(Document document, List<String> feedback) {
        if (!feedback.isEmpty()) {
            document.add(new Paragraph("Retroalimentación")
                    .setFont(headerFont)
                    .setFontSize(headerSize));

            Table feedbackTable = new Table(1).useAllAvailableWidth();
            feedback.forEach(f -> addTableCell(feedbackTable, "• " + f));
            document.add(feedbackTable);
        }
    }

    private void addFooter(Document document, SafetyGuide guide) {
        document.add(new Paragraph()
                .add(new Text("ID de la guía: " + guide.getId())
                        .setFont(normalFont)
                        .setFontSize(10f))
                .setTextAlignment(TextAlignment.RIGHT));
    }

    // Métodos auxiliares para crear celdas de tabla
    private void addTableRow(Table table, String label, String value) {
        table.addCell(new Cell().add(new Paragraph(label).setFont(normalFont).setFontSize(normalSize)));
        table.addCell(new Cell().add(new Paragraph(value).setFont(normalFont).setFontSize(normalSize)));
    }

    private void addTableCell(Table table, String content) {
        table.addCell(new Cell()
                .add(new Paragraph(content)
                        .setFont(normalFont)
                        .setFontSize(normalSize)));
    }

    private void addTableHeaderCell(Table table, String content) {
        table.addCell(new Cell()
                .add(new Paragraph(content)
                        .setFont(headerFont)
                        .setFontSize(normalSize)
                        .setBold())
                .setBackgroundColor(ColorConstants.LIGHT_GRAY, 0.5f));
    }
}