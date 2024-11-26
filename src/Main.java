import repositories.SafetyGuideRepository;
import services.SafetyGuideService;
import controllers.SafetyGuideController;
import repositories.FileBasedSafetyGuideRepository;

public class Main {
    public static void main(String[] args) {
        // Initialize components
        SafetyGuideRepository repository = new FileBasedSafetyGuideRepository();
        SafetyGuideService service = new SafetyGuideService(repository);
        SafetyGuideController controller = new SafetyGuideController(service);

        // Start the app
        controller.start();
    }
}