import java.util.HashMap;
import java.util.Map;

/**
 * This class serves as a simulation environment to demonstrate the integration
 * of the Observer pattern
 *
 * @author Erdem Toruk
 * @version 1.3
 */
public class Main {
    /**
     * The main method that executes the simulation flow.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        // Initialize the system with the default strategy
        AppSystem controller = new AppSystem();

        // Create a user
        User u1 = new User(controller);
        
        // Register user to websites with different frequencies and channels
        u1.register("https://google.com", Frequency.ALWAYS, new MailChannel());
        u1.register("https://something.com", Frequency.DAILY, new SmsChannel());

        // Create random live data to simulation
        Map<String, String> liveWebData = new HashMap<>();
        liveWebData.put("https://google.com", "First content");
        liveWebData.put("https://something.com", "abcdef");

        // Trigger the system to check tracked websites against the live data
        controller.check(liveWebData);
    }
}