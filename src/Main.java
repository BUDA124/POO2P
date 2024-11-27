import models.general.User;
import models.repositories.FileBasedUserRepository;
import models.services.SafetyGuideService;
import models.repositories.FileBasedSafetyGuideRepository;
import control.SafetyGuideController;
import models.services.ServicioCorreos;
import models.services.UserService;

public class Main {
    public static void main(String[] args) {
        // Initialize components
        FileBasedSafetyGuideRepository guidesRepository = new FileBasedSafetyGuideRepository();
        FileBasedUserRepository userRepository = new FileBasedUserRepository();
        SafetyGuideService guideService = new SafetyGuideService(guidesRepository);
        UserService userService = new UserService(userRepository);
        ServicioCorreos servicioCorreos = new ServicioCorreos();
        SafetyGuideController controller = new SafetyGuideController(guideService, userService, servicioCorreos);

        // Start the app
        controller.start();
    }
}

