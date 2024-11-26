package controllers;

import com.itextpdf.io.IOException;
import models.*;
import services.SafetyGuideService;
import utils.FileHandler;

import java.util.*;

public class SafetyGuideController {
    private SafetyGuideService service;
    private Scanner scanner;
    private FileHandler fileHandler;
    private User currentUser;

    public SafetyGuideController(SafetyGuideService service) {
        this.service = service;
        this.scanner = new Scanner(System.in);
    }


    // Actualizar el método showMainMenu() para incluir la opción de generar PDF
    private void showMainMenu() {
        System.out.println("\n=== Sistema de Guías de Seguridad ===");
        System.out.println("1. Iniciar sesión");
        System.out.println("2. Registrarse");
        System.out.println("3. Olvidé contraseña");
        System.out.println("4. Olvidé usuario");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }


    // Actualizar el método start() para incluir la nueva opción
    public void start() {
        while (true) {
            showMainMenu();
            int option = getIntInput(scanner);
            switch (option) {
                case 1:
                    logIn();
                    break;
                case 2:
                    register();
                    break;
                case 3:
                    forgotPassword();
                    break;
                case 4:
                    forgotUser();
                    break;
                case 5:
                    System.out.println("¡Gracias por usar el sistema!");
                    return;
                default:
                    System.out.println("Opción inválida. Por favor intente nuevamente.");
            }
        }
    }


    public void menuOpcionesUsuario() {
        while(true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Crear guía de seguridad");
            System.out.println("2. Acceder a guías guardadas");
            System.out.println("3. Conocer más sobre riesgos");
            System.out.println("4. Ofrece tu feedback");
            System.out.println("5. Cerrar sesión");
            int option = getIntInput(scanner);

            switch (option) {
                case 1:
                    createNewGuide();
                    break;
                case 2:
                    accederAGuiasGuardadas();
                    break;
                case 3:
                    conocerMasSobreRiesgos();
                    break;
                case 4:
                    ofreceTuFeedback();
                    break;
                case 5:
                    System.out.println("Sesión cerrada.");
                    currentUser = null;
                    return;
                default:
                    System.out.println("Opción inválida. Por favor intente nuevamente.");
            }
        }

    }


    public static int getIntInput(Scanner scanner) {
        int option = -1;

        try {
            option = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException var3) {
            System.out.println("Entrada inválida. Por favor, ingrese un número.");
        }

        return option;
    }


    public void logIn() {
        System.out.print("Ingrese su nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contraseña = scanner.nextLine();

        ArrayList<User> usersFromFile = fileHandler.loadUsers();
        boolean usuarioEncontrado = false;

        for (User user : usersFromFile) {
            if (user.getName().equalsIgnoreCase(nombreUsuario) && user.validatePassword(contraseña)) {
                System.out.println("Inicio de sesión exitoso. Bienvenido, " + user.getName());
                usuarioEncontrado = true;
                currentUser = user;
                menuOpcionesUsuario();
                break;
            }
        }

        if (!usuarioEncontrado) {
            System.out.println("Usuario no encontrado o contraseña incorrecta.");
        }
    }


    public void register() {
        ArrayList<User> usuariosExistentes = FileHandler.loadUsers();

        System.out.print("Ingrese su nombre completo: ");
        String nombreCompleto = scanner.nextLine();

        System.out.print("Ingrese un nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();

        // Verificar si el nombre de usuario ya existe
        boolean usuarioExiste = usuariosExistentes.stream()
                .anyMatch(u -> u.getName().equalsIgnoreCase(nombreUsuario));

        if (usuarioExiste) {
            System.out.println("El nombre de usuario ya está en uso. Por favor, elija otro.");
            return;
        }

        System.out.print("Ingrese su rol (por ejemplo, Ingeniero, Albañil): ");
        String rol = scanner.nextLine();

        System.out.print("Ingrese su compañía: ");
        String compania = scanner.nextLine();

        System.out.print("Ingrese su información de contacto (email o teléfono): ");
        String contacto = scanner.nextLine();

        System.out.print("Ingrese una contraseña: ");
        String contraseña = scanner.nextLine();

        System.out.print("Confirme su contraseña: ");
        String confirmarContraseña = scanner.nextLine();

        if (contraseña.equals(confirmarContraseña)) {
            User nuevoUsuario = new User(nombreCompleto, nombreUsuario, rol, compania, contacto, contraseña);
            usuariosExistentes.add(nuevoUsuario);

            // Guardar la lista actualizada en el archivo
            FileHandler.saveUsers(usuariosExistentes);

            System.out.println("Registro exitoso. Bienvenido, " + nuevoUsuario.getName());
            System.out.println("Tu ID de usuario es: " + nuevoUsuario.getId());
        } else {
            System.out.println("Las contraseñas no coinciden. Por favor, intente nuevamente.");
        }
    }


    public void forgotPassword() {
        System.out.print("Ingrese su correo electrónico: ");
        String correo = scanner.nextLine();
        System.out.println("Se ha enviado un enlace para restablecer su contraseña al correo: " + correo);
    }


    public void forgotUser() {
        System.out.print("Ingrese su correo electrónico: ");
        String correo = scanner.nextLine();
        System.out.println("Se ha enviado su nombre de usuario al correo: " + correo);
    }


    public void ofreceTuFeedback() {
        System.out.print("Asunto: ");
        String asunto = scanner.nextLine();
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();
        System.out.println("Sugerencia enviada con éxito.");
    }


    public void conocerMasSobreRiesgos() {
        while(true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Conocer más sobre herramientas");
            System.out.println("2. Conocer más sobre distintos tipos de obra");
            System.out.println("3. Conocer más sobre profesiones en el área de construcción");
            System.out.println("4. Conocer más sobre riesgos comunes");
            System.out.println("5. Regresar");
            int option = getIntInput(scanner);

            switch (option) {
                case 1:
                    System.out.println("Aquí se muestra toda la info del figma sobre herramientas.");
                    break;
                case 2:
                    System.out.println("Aquí se muestra toda la info del figma sobre tipos de obra.");
                    break;
                case 3:
                    System.out.println("Aquí se muestra toda la info del figma sobre profesiones.");
                    break;
                case 4:
                    System.out.println("Aquí se muestra toda la info del figma sobre riesgos comunes.");
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, intente nuevamente.");
            }
        }

    }


    private void createNewGuide() {
        while(true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Crear guía básica");
            System.out.println("2. Personalizar guía de seguridad");
            System.out.println("3. Regresar");
            int option = getIntInput(scanner);
            switch (option) {
                case 1:
                    System.out.println("Creando guía básica de seguridad...");
                    createBasicGuide();
                    break;
                case 2:
                    System.out.println("Personalizando guía de seguridad...");
                    createCustomGuide();
                    break;
                case 3:
                    System.out.println("Regresando al menú principal...");
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, intente nuevamente.");
            }
        }
    }


    public void createBasicGuide() {
        SafetyGuide guiaBasica = new BasicSafetyGuide();
        guiaBasica.mostrarRiesgosYPrevenciones();
        guiaBasica.mostrarChecklist();
        guiaBasica.interactuarChecklist(scanner);
    }


    public void createCustomGuide() {
        CustomSafetyGuide guiaPersonalizada = new CustomSafetyGuide(scanner);
        guiaPersonalizada.mostrarRiesgosYPrevenciones();
        guiaPersonalizada.mostrarChecklist();
        guiaPersonalizada.interactuarChecklist(scanner);
    }


    public void accederAGuiasGuardadas() {
        System.out.println("Aquí deberían salir las distintas guías disponibles y seleccionar");
        System.out.println("a. Primera guía.");
        System.out.println("b. Segunda guía.");
        System.out.println("c. Tercera guía.");
        System.out.println();

        while(true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Descargar");
            System.out.println("2. Eliminar");
            System.out.println("3. Editar");
            System.out.println("4. Regresar");
            int option = getIntInput(scanner);
            switch (option) {
                case 1:
                    System.out.println("Descargando guía...");
                    break;
                case 2:
                    System.out.println("Eliminando guía...");
                    break;
                case 3:
                    System.out.println("Editando guía...");
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opción inválida. Por favor intente nuevamente.");
            }
        }

    }


    private void viewExistingGuides() {
        List<SafetyGuide> guides = service.getAllGuides();
        if (guides.isEmpty()) {
            System.out.println("No hay guías disponibles.");
            return;
        }

        System.out.println("\n=== Guías Existentes ===");
        for (SafetyGuide guide : guides) {
            System.out.println("\nID: " + guide.getId());
            System.out.println("Usuario: " + guide.getUser().getName());
            System.out.println("Fecha de creación: " + guide.getCreationDate());
        }
    }


    private void generatePDF() {
        System.out.print("\nIngrese el ID de la guía para generar PDF: ");
        String guideId = scanner.nextLine();

        System.out.print("Ingrese la ruta de salida para el PDF: ");
        String outputPath = scanner.nextLine();

        try {
            service.generatePDF(guideId, outputPath);
            System.out.println("PDF generado exitosamente en: " + outputPath);
        } catch (IOException e) {
            System.out.println("Error al generar el PDF: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}