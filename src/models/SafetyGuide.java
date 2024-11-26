package models;

import controllers.SafetyGuideController;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public abstract class SafetyGuide {
    // Atributos de la primera clase
    private String id;
    private User user;
    private LocalDateTime creationDate;

    // Atributos de la segunda clase
    protected Map<String, String> riesgosYPrevenciones = new HashMap<>();
    protected List<String> checklist = new ArrayList<>();

    public SafetyGuide() {
        this.id = java.util.UUID.randomUUID().toString();
        this.creationDate = LocalDateTime.now();
        this.riesgosYPrevenciones = new HashMap<>();
        this.checklist = new ArrayList<>();
    }

    public void mostrarRiesgosYPrevenciones() {
        System.out.println("Riesgos y Prevenciones:");
        for (Map.Entry<String, String> entry : riesgosYPrevenciones.entrySet()) {
            System.out.println("Riesgo: " + entry.getKey());
            System.out.println("Prevención: " + entry.getValue());
            System.out.println("---------------------------");
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

    public void marcarPrevencionCumplida(int indice) {
        if (indice > 0 && indice <= checklist.size()) {
            String prevencion = checklist.get(indice - 1);
            System.out.println("Prevención marcada como cumplida: " + prevencion);
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public void interactuarChecklist(Scanner scanner) {
        boolean salir = false;
        while (!salir) {
            System.out.println("Checklist de Prevenciones:");
            for (int i = 0; i < checklist.size(); i++) {
                System.out.println((i + 1) + ". " + checklist.get(i));
            }

            System.out.println("Seleccione el número de la prevención que ha cumplido (0 para salir):");
            int opcion = SafetyGuideController.getIntInput(scanner);

            if (opcion == 0) {
                salir = true;
            } else if (opcion > 0 && opcion <= checklist.size()) {
                String prevencion = checklist.get(opcion - 1);
                checklist.set(opcion - 1, prevencion + " (Cumplida)");
                System.out.println("Prevención marcada como cumplida: " + prevencion);
            } else {
                System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }

    // Getters y setters
    public String getId() { return id; }
    public User getUser() { return user; }
    public LocalDateTime getCreationDate() { return creationDate; }
}