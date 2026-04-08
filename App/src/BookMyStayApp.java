 UC4-Room-Search-And-Availability-Check


 main
    // Abstract class to define common attributes and behavior
    abstract class Room {
        private String roomType;
        private int bedCount;
        private double pricePerNight;
        // Static representation of availability (true = available, false = booked)
        protected boolean isAvailable;

        public Room(String roomType, int bedCount, double pricePerNight, boolean isAvailable) {
            this.roomType = roomType;
            this.bedCount = bedCount;
            this.pricePerNight = pricePerNight;
            this.isAvailable = isAvailable;
        }

        // Abstract method to force specific room behavior
        public abstract void displayRoomDetails();

        // Getters
        public String getRoomType() { return roomType; }
        public int getBedCount() { return bedCount; }
        public double getPricePerNight() { return pricePerNight; }
        public boolean isAvailable() { return isAvailable; }
    }

    class SingleRoom extends Room {
        public SingleRoom(boolean isAvailable) {
            super("Single Room", 1, 100.0, isAvailable);
        }

        @Override
        public void displayRoomDetails() {
            System.out.println(getRoomType() + " | Beds: " + getBedCount() +
                    " | Price: $" + getPricePerNight() +
                    " | Available: " + isAvailable());
        }
    }

    class DoubleRoom extends Room {
        public DoubleRoom(boolean isAvailable) {
            super("Double Room", 2, 180.0, isAvailable);
        }

        @Override
        public void displayRoomDetails() {
            System.out.println(getRoomType() + " | Beds: " + getBedCount() +
                    " | Price: $" + getPricePerNight() +
                    " | Available: " + isAvailable());
        }
    }

    class SuiteRoom extends Room {
        public SuiteRoom(boolean isAvailable) {
            super("Suite Room", 2, 350.0, isAvailable);
        }

        @Override
        public void displayRoomDetails() {
            System.out.println(getRoomType() + " | Beds: " + getBedCount() +
                    " | Price: $" + getPricePerNight() +
                    " | Available: " + isAvailable());
        }
    }

    public class BookMyStayApp {
        public static void main(String[] args) {
            System.out.println("--- Book My Stay App: Room Inventory ---");

            // Initialize room objects with static availability
            Room room1 = new SingleRoom(true);  // Available
            Room room2 = new DoubleRoom(true);  // Available
            Room room3 = new SuiteRoom(false);  // Booked

            // Display room details
            room1.displayRoomDetails();
            room2.displayRoomDetails();
            room3.displayRoomDetails();

            System.out.println("----------------------------------------");
        }
    }
dev
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
 UC4-Room-Search-And-Availability-Check

    private void displayRoom(Room room, int available) {
        System.out.println("Beds: " + room.getBeds());
        System.out.println("Size: " + room.getSize() + " sqft");
        System.out.println("Price per night: " + room.getPrice());
        System.out.println("Available: " + available);
    }
}

public class BookMyStayApp {
    public static void main(String[] args) {
        RoomInventory manager = new RoomInventory();
        System.out.println("Initial State:");
        manager.displayInventory();

        // Simulate booking: Reduce 2 Deluxe rooms
        System.out.println("\nBooking 2 Deluxe rooms...");
        manager.updateAvailability("Deluxe", -2);
        manager.displayInventory();

        // Simulate adding new inventory: 1 Suite
        System.out.println("\nAdding 1 Suite room...");
        manager.updateAvailability("Suite", 1);
        manager.displayInventory();
}
 dev
 dev
