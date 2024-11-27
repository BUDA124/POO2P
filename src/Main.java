import models.general.SafetyGuide;
import models.repositories.Repository;
import models.services.SafetyGuideService;
import models.repositories.FileBasedSafetyGuideRepository;
import control.SafetyGuideController;

public class Main {
    public static void main(String[] args) {
        // Initialize components
        FileBasedSafetyGuideRepository guidesRepository = new FileBasedSafetyGuideRepository();
        SafetyGuideService service = new SafetyGuideService(guidesRepository);
        SafetyGuideController controller = new SafetyGuideController(service);

        // Start the app
        controller.start();
    }
}

