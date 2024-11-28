import models.repositories.FileBasedUserRepository;
import models.services.SafetyGuideService;
import models.repositories.FileBasedSafetyGuideRepository;
import control.SystemController;
import models.services.MailService;
import models.services.UserService;
import models.utils.PDFGenerator;

public class Main {
    public static void main(String[] args) {
        // Inicialización de componentes
        FileBasedSafetyGuideRepository guidesRepository = new FileBasedSafetyGuideRepository();
        FileBasedUserRepository userRepository = new FileBasedUserRepository();
        SafetyGuideService guideService = new SafetyGuideService(guidesRepository);
        UserService userService = new UserService(userRepository);
        MailService mailService = new MailService();
        PDFGenerator pdfGenerator = new PDFGenerator();
        SystemController controller = new SystemController(guideService, userService, mailService, pdfGenerator);

        // Iniciar la aplicación
        controller.start();
    }
}

