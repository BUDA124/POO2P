package control;

import com.itextpdf.io.IOException;
import models.general.*;
import models.services.SafetyGuideService;
import models.services.ServicioCorreos;
import models.services.UserService;
import models.utils.FileHandler;
import models.utils.PDFGenerator;

import java.util.*;

public class SafetyGuideController {
    private final SafetyGuideService guideService;
    private final UserService userService;
    private final Scanner scanner;
    private final ServicioCorreos servicioCorreos;
    private final PDFGenerator pdfGenerator;
    private User currentUser;

    public SafetyGuideController(SafetyGuideService guideService, UserService userService,
                                 ServicioCorreos servicioCorreos, PDFGenerator pdfGenerator) {
        this.guideService = guideService;
        this.userService = userService;
        this.servicioCorreos = servicioCorreos;
        this.pdfGenerator = new PDFGenerator();
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
            System.out.println("\n=== Menu de opciones de usuario ===");
            System.out.println("1. Crear guía de seguridad");
            System.out.println("2. Acceder a guías guardadas");
            System.out.println("3. Conocer más sobre riesgos");
            System.out.println("4. Ofrece tu feedback");
            System.out.println("5. Cerrar sesión");
            System.out.print("Seleccione una opción: ");

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
        String currentUsername = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contrasena = scanner.nextLine();

        Optional<User> optionalUser = userService.findById(currentUsername);

        User user;
        if (optionalUser.isPresent()) {
            user = optionalUser.get();
        }
        else {
            System.out.println("Usuario no encontrado.");
            return;
        }

        // Validar contraseña
        if (user.validatePassword(contrasena)) {
            System.out.println("Inicio de sesión exitoso. Bienvenido, " + user.getName());
            currentUser = user; // Asignar el usuario actual
            menuOpcionesUsuario(); // Llamar al menú de opciones
        } else {
            System.out.println("Contraseña incorrecta. Intenta de nuevo.");
        }

    }

    public void register() {
        // Cargar usuarios existentes como un HashMap
        HashMap<String, User> userHashMap = userService.findAll();

        System.out.print("Ingrese su nombre completo: ");
        String nombreCompleto = scanner.nextLine();

        String nombreUsuario;
        while (true) {
            System.out.print("Ingrese un nombre de usuario: ");
            nombreUsuario = scanner.nextLine();

            // Verificar si el nombre de usuario ya existe
            if (userHashMap.containsKey(nombreUsuario)) {
                System.out.println("El nombre de usuario ya está en uso. Por favor, elija otro.");
            } else {
                break; // Nombre de usuario válido
            }
        }

        System.out.print("Ingrese su rol (por ejemplo, Ingeniero, Albañil): ");
        String rol = scanner.nextLine();

        System.out.print("Ingrese su compañía: ");
        String compania = scanner.nextLine();

        System.out.print("Ingrese su información de contacto (email o teléfono): ");
        String contacto = scanner.nextLine();

        String contrasena;
        String confirmarContrasena;
        while (true) {
            System.out.print("Ingrese una contraseña: ");
            contrasena = scanner.nextLine();

            System.out.print("Confirme su contraseña: ");
            confirmarContrasena = scanner.nextLine();

            if (contrasena.equals(confirmarContrasena)) {
                break; // Contraseña válida
            } else {
                System.out.println("Las contraseñas no coinciden. Por favor, intente nuevamente.");
            }
        }

        // Crear un nuevo usuario
        User nuevoUsuario = new User(nombreCompleto, nombreUsuario, rol, compania, contacto, contrasena);

        // Agregar el nuevo usuario al HashMap
        userService.save(nuevoUsuario);
        guideService.createArrayForUser(nuevoUsuario.getUsername());

        System.out.println("Registro exitoso. Bienvenido, " + nuevoUsuario.getName());
    }

    public void forgotPassword() {
        User user;
        System.out.print("Ingrese su nombre de usuario: ");
        String currentUsername = scanner.nextLine();

        Optional<User> optionalUser = userService.findById(currentUsername);
        if (optionalUser.isPresent()) {
            user = optionalUser.get();
        }
        else {
            System.out.println("Usuario no encontrado.");
            return;
        }

        System.out.print("Ingrese su correo electrónico: ");
        String correo = scanner.nextLine();
        servicioCorreos.notificarRestablecimientoContrasena(correo);
        System.out.println("Se ha enviado un aviso sobre el cambio al correo: " + correo);

        String contrasena;
        String confirmarContrasena;
        while (true) {
            System.out.print("Ingrese su nueva contraseña: ");
            contrasena = scanner.nextLine();

            System.out.print("Confirme su contraseña: ");
            confirmarContrasena = scanner.nextLine();

            if (contrasena.equals(confirmarContrasena)) {
                break; // Contraseña válida
            } else {
                System.out.println("Las contraseñas no coinciden. Por favor, intente nuevamente.");
            }
        }
        user.setPassword(contrasena);
        System.out.println("Contraseña cambiada de manera exitosa!.");
    }

    public void forgotUser() {
        System.out.print("Ingrese su correo electrónico: ");
        String correo = scanner.nextLine();
        servicioCorreos.notificarOlvidoUsuario(correo);
        System.out.println("Se ha enviado información sobre la recuperación de usuario al correo: " + correo);
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
            System.out.println("\n=== Información ===");
            System.out.println("1. Conocer más sobre herramientas");
            System.out.println("2. Conocer más sobre distintos tipos de obra");
            System.out.println("3. Conocer más sobre profesiones en el área de construcción");
            System.out.println("4. Conocer más sobre riesgos comunes");
            System.out.println("5. Regresar");
            System.out.print("Seleccione una opción: ");

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
            System.out.println("\n=== Opciones de guías ===");
            System.out.println("1. Crear guía básica");
            System.out.println("2. Personalizar guía de seguridad");
            System.out.println("3. Regresar");
            System.out.print("Seleccione una opción: ");

            int option = getIntInput(scanner);
            switch (option) {
                case 1:
                    System.out.println("Creando guía básica de seguridad...");
                    createBasicGuide();
                    break;
                case 2:
                    createCustomGuide();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, intente nuevamente.");
            }
        }
    }

    public void createBasicGuide() {
        SafetyGuide guiaBasica = new BasicSafetyGuide();
        guiaBasica.generarChecklist();
        guiaBasica.mostrarRiesgosYPrevenciones();
        guiaBasica.interactuarChecklist(scanner);
        guideService.save(currentUser.getUsername(), guiaBasica);
    }

    public void createCustomGuide() {
        CustomSafetyGuide guiaPersonalizada = new CustomSafetyGuide();
        guiaPersonalizada.mostrarRiesgosYPrevenciones();
        guiaPersonalizada.interactuarChecklist(scanner);
        guideService.save(currentUser.getUsername(), guiaPersonalizada);
    }

    public void accederAGuiasGuardadas() {
        ArrayList<SafetyGuide> guideArrayList = obtenerGuiasDelUsuario();
        if (guideArrayList == null || guideArrayList.isEmpty()) {
            System.out.println("No tienes guías guardadas.");
            return;
        }
        while (true) {
            mostrarGuias(guideArrayList);
            SafetyGuide selectedGuide = seleccionarGuia(guideArrayList);
            if (selectedGuide == null) {
                return; // Salir si el usuario decide cancelar
            }
            mostrarOpcionesDeGuia(selectedGuide);
        }
    }

    private ArrayList<SafetyGuide> obtenerGuiasDelUsuario() {
        return guideService.findById(currentUser.getUsername());
    }

    private void mostrarGuias(ArrayList<SafetyGuide> guideArrayList) {
        System.out.println("\n=== Guías Disponibles ===");
        int i = 1;
        for (SafetyGuide guide : guideArrayList) {
            System.out.println("\nGuía (" + i + ")");
            System.out.println("ID: " + guide.getId());
            System.out.println("Fecha de creación: " + guide.getCreationDate());
            i++;
        }
    }

    private SafetyGuide seleccionarGuia(ArrayList<SafetyGuide> guideArrayList) {
        System.out.print("\nSelecciona una guía para continuar o ingresa 0 para salir: ");
        int selectedGuide = getIntInput(scanner);

        // Manejar la opción de salir
        if (selectedGuide == 0) {
            return null; // O manejar el caso según sea necesario
        }
        // Verificar si la selección es válida
        if (selectedGuide > 0 && selectedGuide <= guideArrayList.size()) {
            return guideArrayList.get(selectedGuide - 1); // Ajustar para índice basado en 0
        }
        System.out.println("Número de guía inválido. Por favor intenta nuevamente.");
        return seleccionarGuia(guideArrayList); // Llama recursivamente hasta obtener una selección válida
    }

    private void mostrarOpcionesDeGuia(SafetyGuide guide) {
        while (true) {
            System.out.println("\n=== Opciones para la guía seleccionada ===");
            System.out.println("1. Descargar guía");
            System.out.println("2. Eliminar guía");
            System.out.println("3. Editar guía");
            System.out.println("4. Regresar al menú anterior");
            System.out.print("Selecciona una opción: ");

            int opcion = getIntInput(scanner);
            switch (opcion) {
                case 1:
                    descargarGuia(guide);
                    break;
                case 2:
                    eliminarGuia(guide);
                    return; // Salir al menú de selección después de eliminar
                case 3:
                    editarGuia(guide);
                    break;
                case 4:
                    return; // Regresar al menú de selección
                default:
                    System.out.println("Opción inválida. Por favor intenta nuevamente.");
            }
        }
    }

    private void descargarGuia(SafetyGuide guide) {
        System.out.println("Descargando guía con ID: " + guide.getId());
        try {
            pdfGenerator.generatePDF(currentUser, guide);
        } catch (java.io.IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void eliminarGuia(SafetyGuide guide) {
        System.out.println("Eliminando guía seleccionada: " + guide.getId());



        System.out.println("Guía eliminada con éxito.");
    }

    private void editarGuia(SafetyGuide guide) {
        System.out.println("Editando guía con ID: " + guide.getId());
        // Lógica para editar la guía
    }

    private void viewExistingGuides() {
        ArrayList<ArrayList<SafetyGuide>> guides = guideService.getAllGuides();

        System.out.println("\n=== Guías Existentes ===");
        for (ArrayList<SafetyGuide> guideArrayList : guides) {
            for (SafetyGuide guide : guideArrayList) {
                System.out.println("\nID: " + guide.getId());
                System.out.println("Usuario: " + guide.getUser().getName());
                System.out.println("Fecha de creación: " + guide.getCreationDate());
            }
        }
    }

    private void generatePDF(String guideId) {
        System.out.print("Ingrese la ruta de salida para el PDF: ");
        String outputPath = scanner.nextLine();

        try {
            guideService.generatePDF(guideId, outputPath);
            System.out.println("PDF generado exitosamente en: " + outputPath);
        } catch (IOException e) {
            System.out.println("Error al generar el PDF: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}