package view.controllers;

import java.util.ArrayList;
import java.util.List;

public class ChecklistController {
    private static final List<String> selectedWorks = new ArrayList<>();
    private static final List<String> selectedProfessionals = new ArrayList<>();
    private static final List<String> selectedTools = new ArrayList<>();

    public static List<String> getSelectedWorks() {
        return selectedWorks;
    }

    public static void addSelectedWork(String work) {
        selectedWorks.add(work);
    }

    public static List<String> getSelectedProfessionals() {
        return selectedProfessionals;
    }

    public static void addSelectedProfessional(String professional) {
        selectedProfessionals.add(professional);
    }

    public static List<String> getSelectedTools() {
        return selectedTools;
    }

    public static void addSelectedTool(String tool) {
        selectedTools.add(tool);
    }
}
