package models.utils;

import models.general.SafetyGuide;
import models.general.User;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class FileHandler {

    private static final String GUIDES_FILE_PATH = "src/DataFiles/safetyGuides.dat";
    private static final String USERS_FILE_PATH = "src/DataFiles/users.dat";

    /**
     * Guarda un mapa de guías de seguridad en un archivo.
     * @param guides el mapa de guías a guardar
     */
    public static void saveGuides(HashMap<String, ArrayList<SafetyGuide>> guides) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(GUIDES_FILE_PATH))) {
            oos.writeObject(guides);
        } catch (NotSerializableException e) {
            System.err.println("Un objeto no es serializable: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error al guardar las guías: " + e.getMessage());
        }
    }

    /**
     * Carga un mapa de guías de seguridad desde un archivo.
     * Si el archivo no existe o está vacío, retorna un mapa vacío.
     * @return el mapa de guías cargadas
     */
    public static HashMap<String, ArrayList<SafetyGuide>> loadGuides() {
        File file = new File(GUIDES_FILE_PATH);
        if (!file.exists()) {
            System.out.println("Archivo no encontrado. Creando uno nuevo...");
            saveGuides(new HashMap<>()); // Crea un archivo vacío
            return new HashMap<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (HashMap<String, ArrayList<SafetyGuide>>) ois.readObject();
        } catch (EOFException e) {
            System.out.println("El archivo está vacío. Inicializando mapa vacío...");
            return new HashMap<>();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar las guías: " + e.getMessage());
            return new HashMap<>();
        }
    }

    /**
     * Guarda un mapa de usuarios en un archivo.
     * @param users el mapa de usuarios a guardar
     */
    public static void saveUsers(HashMap<String, User> users) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USERS_FILE_PATH))) {
            oos.writeObject(users);
        } catch (IOException e) {
            System.err.println("Error al guardar los usuarios: " + e.getMessage());
        }
    }

    /**
     * Carga un mapa de usuarios desde un archivo.
     * Si el archivo no existe o está vacío, retorna un mapa vacío.
     * @return el mapa de usuarios cargados
     */
    public static HashMap<String, User> loadUsers() {
        File file = new File(USERS_FILE_PATH);
        if (!file.exists()) {
            System.out.println("Archivo de usuarios no encontrado. Creando uno nuevo...");
            saveUsers(new HashMap<>()); // Crea un archivo vacío
            return new HashMap<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (HashMap<String, User>) ois.readObject();
        } catch (EOFException e) {
            System.out.println("El archivo de usuarios está vacío. Inicializando mapa vacío...");
            return new HashMap<>();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar los usuarios: " + e.getMessage());
            return new HashMap<>();
        }
    }
}
