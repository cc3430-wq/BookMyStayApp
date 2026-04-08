
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
import java.util.HashMap;
import java.util.Map;

    // RoomInventory.java - Version 3.1
    class RoomInventory {
        // Single source of truth using HashMap
        private Map<String, Integer> inventory;

        public RoomInventory() {
            inventory = new HashMap<>();
            // Initialize with default room types and availability
            inventory.put("Deluxe", 10);
            inventory.put("Suite", 5);
            inventory.put("Family", 3);
        }

        // Method to check availability - O(1) complexity
        public int getAvailability(String roomType) {
            return inventory.getOrDefault(roomType, 0);
        }

        // Method to update availability - Controlled update
        public boolean updateAvailability(String roomType, int count) {
            if (inventory.containsKey(roomType)) {
                int current = inventory.get(roomType);
                if (current + count >= 0) {
                    inventory.put(roomType, current + count);
                    return true;
                }
            }
            return false; // Cannot have negative rooms
        }

        public void displayInventory() {
            System.out.println("Current Inventory: " + inventory);
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
