package utils;

import models.SafetyGuide;
import models.User;
import java.io.*;
import java.util.ArrayList;

public class FileHandler {
    private static final String GUIDES_FILE_PATH = "safety_guides.dat";
    private static final String USERS_FILE_PATH = "users.dat";

    /**
     * Guarda una lista de guías de seguridad en un archivo.
     * @param guides la lista de guías a guardar
     */
    public static void saveGuides(ArrayList<SafetyGuide> guides) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(GUIDES_FILE_PATH))) {
            oos.writeObject(guides);
        } catch (IOException e) {
            System.err.println("Error al guardar las guías: " + e.getMessage());
        }
    }

    /**
     * Carga una lista de guías de seguridad desde un archivo.
     * Si el archivo no existe o está vacío, retorna una lista vacía.
     * @return la lista de guías cargadas
     */
    public static ArrayList<SafetyGuide> loadGuides() {
        File file = new File(GUIDES_FILE_PATH);
        if (!file.exists()) {
            System.out.println("Archivo no encontrado. Creando uno nuevo...");
            saveGuides(new ArrayList<>()); // Crea un archivo vacío
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (ArrayList<SafetyGuide>) ois.readObject();
        } catch (EOFException e) {
            System.out.println("El archivo está vacío. Inicializando lista vacía...");
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar las guías: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    /**
     * Guarda una lista de usuarios en un archivo.
     * @param users la lista de usuarios a guardar
     */
    public static void saveUsers(ArrayList<User> users) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USERS_FILE_PATH))) {
            oos.writeObject(users);
        } catch (IOException e) {
            System.err.println("Error al guardar los usuarios: " + e.getMessage());
        }
    }

    /**
     * Carga una lista de usuarios desde un archivo.
     * Si el archivo no existe o está vacío, retorna una lista vacía.
     * @return la lista de usuarios cargados
     */
    public static ArrayList<User> loadUsers() {
        File file = new File(USERS_FILE_PATH);
        if (!file.exists()) {
            System.out.println("Archivo de usuarios no encontrado. Creando uno nuevo...");
            saveUsers(new ArrayList<>()); // Crea un archivo vacío
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (ArrayList<User>) ois.readObject();
        } catch (EOFException e) {
            System.out.println("El archivo de usuarios está vacío. Inicializando lista vacía...");
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar los usuarios: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}