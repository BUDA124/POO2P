package models.general;

import control.SystemController;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

public abstract class SafetyGuide implements Serializable {
    private static final long serialVersionUID = 1L; // Versión para evitar problemas de compatibilidad

    // Atributos de la primera clase
    private String id;
    private String title = "Guía básica de seguridad";
    private LocalDateTime creationDate;

    // Atributos de la segunda clase
    protected HashMap<String, String> riesgosYPrevenciones = new HashMap<>();
    protected List<String> checklist = new ArrayList<>();

    public SafetyGuide() {
        this.id = java.util.UUID.randomUUID().toString();
        this.creationDate = LocalDateTime.now();
        this.riesgosYPrevenciones = new HashMap<>();
        this.checklist = new ArrayList<>();
    }

    public void mostrarRiesgosYPrevenciones() {
        System.out.println("\nRiesgos y Prevenciones:");
        for (Map.Entry<String, String> entry : riesgosYPrevenciones.entrySet()) {
            System.out.println("Riesgo: " + entry.getKey());
            System.out.println("Prevención: " + entry.getValue());
            System.out.println("\n---------------------------\n");
        }
    }

    public void generarChecklist() {
        checklist.addAll(riesgosYPrevenciones.values());
    }

    public void mostrarChecklist() {
        System.out.println("Checklist de Prevenciones:");
        for (int i = 0; i < checklist.size(); i++) {
            System.out.println((i + 1) + ". " + checklist.get(i));
        }
    }

    public void interactuarChecklist(Scanner scanner) {
        while (true) {
            mostrarChecklist();

            System.out.print("Digite las prevenciones cumplidas (0 para salir): ");
            int opcion = SystemController.getIntInput(scanner);

            if (opcion == 0) {
                break;
            } else if (opcion > 0 && opcion <= checklist.size()) {
                String prevencion = checklist.get(opcion - 1);
                checklist.set(opcion - 1, prevencion + " (Cumplida)");
            } else {
                System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }

    public Map<String, Object> obtenerDatos() {
        Map<String, Object> datos = new HashMap<>();
        datos.put("checklist", new ArrayList<>(checklist));
        datos.put("riesgosYPrevenciones", new HashMap<>(riesgosYPrevenciones));
        return datos;
    }

    // Getters y setters
    public String getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public LocalDateTime getCreationDate() { return creationDate; }
    public List<String> getRisks() {
        return new ArrayList<String>(riesgosYPrevenciones.keySet());
    }
    public Collection<String> getPreventions() {
        return riesgosYPrevenciones.values();
    }
}