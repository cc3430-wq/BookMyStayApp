import java.util.HashMap;
import java.util.Map;
/**
 * ============================================================
 * MAIN CLASS - UseCase4RoomSearch
 * ============================================================
 * Use Case 4: Room Search & Availability Check
 * Description:
 * This class demonstrates how guests
 * can view available rooms without
 * modifying inventory data.
 * The system enforces read-only access
 * by design and usage discipline.
 * @version 4.0
 */
public class BookMyStayApp {

    public static void main(String[] args) {

        // Create room objects
        Room singleRoom = new Room(1, 250, 1500.0);
        Room doubleRoom = new Room(2, 400, 2500.0);
        Room suiteRoom = new Room(3, 750, 5000.0);
        RoomInventory inventory = new RoomInventory();
        RoomSearchService service = new RoomSearchService();
        service.searchAvailableRooms(
                inventory,
                singleRoom,
                doubleRoom,
                suiteRoom);
    }
}
class Room {

    private int beds;
    private int size;
    private double price;

    public Room(int beds, int size, double price) {
        this.beds = beds;
        this.size = size;
        this.price = price;
    }

    public int getBeds() {
        return beds;
    }

    public int getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }
}

class RoomInventory {

    private Map<String, Integer> availability;

    // Constructor initializes data
    public RoomInventory() {
        availability = new HashMap<>();

        availability.put("Single", 5);
        availability.put("Double", 3);
        availability.put("Suite", 2);
    }

    // Getter method
    public Map<String, Integer> getRoomAvailability() {
        return availability;
    }
}

class RoomSearchService {

    public void searchAvailableRooms(
            RoomInventory inventory,
            Room singleRoom,
            Room doubleRoom,
            Room suiteRoom) {

        System.out.println("Room Search\n");

        // Get availability data
        Map<String, Integer> availability = inventory.getRoomAvailability();

        // Single Room
        if (availability.get("Single") > 0) {
            System.out.println("Single Room:");
            displayRoom(singleRoom, availability.get("Single"));
        }

        // Double Room
        if (availability.get("Double") > 0) {
            System.out.println("\nDouble Room:");
            displayRoom(doubleRoom, availability.get("Double"));
        }

        // Suite Room
        if (availability.get("Suite") > 0) {
            System.out.println("\nSuite Room:");
            displayRoom(suiteRoom, availability.get("Suite"));
        }
    }

    private void displayRoom(Room room, int available) {
        System.out.println("Beds: " + room.getBeds());
        System.out.println("Size: " + room.getSize() + " sqft");
        System.out.println("Price per night: " + room.getPrice());
        System.out.println("Available: " + available);
    }
}