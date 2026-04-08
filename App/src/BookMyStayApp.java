 feature/UC1-WelcomePage
/**
 * ============================================================
 * MAIN CLASS - UseCase1HotelBookingApp
 * ============================================================
 *
 * Use Case 1: Application Entry & Welcome Message
 *
 * Description:
 * This class represents the entry point of the
 * Hotel Booking Management System.
 *
 * At this stage, the application:
 * - Starts execution from the main() method
 * - Displays a welcome message to the user
 * - Confirms that the system has started successfully
 *
 * No business logic, data structures, or user input
 * is implemented in this use case.
 *
 * The goal is to establish a clear and predictable
 * application startup point.
 *
 * @author chandu
 * @version 1.0
 */

public class BookMyStayApp {

    /**
     * Application entry point.
     *
     * This method is the first method executed
     * when the program is launched by the JVM.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        // Display welcome message
        System.out.println("Welcome to the Hotel Booking Management System");

        // Confirm system initialization
        System.out.println("System initialized successfully.");
    }

import java.util.*;
import java.io.*;
/**
 * ============================================================
 * MAIN CLASS - UseCase12DataPersistenceRecovery
 * ============================================================
 * Use Case 12: Data Persistence & System Recovery
 * Description:
 * This class demonstrates how system state
 * can be restored after an application restart.
 * Inventory data is loaded from a file
 * before any booking operations occur.
 * @version 12.0
 */

class RoomInventory {
    private Map<String, Integer> rooms;

    public RoomInventory() {
        rooms = new HashMap<>();
        rooms.put("Single", 5);
        rooms.put("Double", 3);
        rooms.put("Suite", 2);
    }

    public Map<String, Integer> getRooms() {
        return rooms;
    }

    public void setRoom(String type, int count) {
        rooms.put(type, count);
    }
}

class FilePersistenceService {

    public void saveInventory(RoomInventory inventory, String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (Map.Entry<String, Integer> entry : inventory.getRooms().entrySet()) {
                writer.println(entry.getKey() + "=" + entry.getValue());
            }
            System.out.println("Inventory saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving inventory.");
        }
    }
    public void loadInventory(RoomInventory inventory, String filePath) {
        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("No valid inventory data found. Starting fresh.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=");
                inventory.setRoom(parts[0], Integer.parseInt(parts[1]));
            }
        } catch (Exception e) {
            System.out.println("Error loading inventory.");
        }
    }
}

public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("System Recovery");

        RoomInventory inventory = new RoomInventory();
        FilePersistenceService service = new FilePersistenceService();

        String filePath = "inventory.txt";

        service.loadInventory(inventory, filePath);

        System.out.println("\nCurrent Inventory:");
        for (Map.Entry<String, Integer> entry : inventory.getRooms().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        service.saveInventory(inventory, filePath);
    }
 dev
}