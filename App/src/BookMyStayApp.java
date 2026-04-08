import java.util.*;
/**
 * ============================================================
 * CLASS - ConcurrentBookingProcessor
 * ============================================================
 * Use Case 11: Concurrent Booking Simulation
 * Description:
 * This class represents a booking processor
 * that can be executed by multiple threads.
 * It demonstrates how shared resources
 * such as booking queues and inventory
 * must be accessed in a thread-safe manner.
 * @version 11.0
 */
class Reservation {
    String guestName;
    String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }
}

class BookingRequestQueue {
    private Queue<Reservation> queue = new LinkedList<>();

    public BookingRequestQueue() {
        queue.add(new Reservation("Abhi", "Single"));
        queue.add(new Reservation("Vanmathi", "Double"));
        queue.add(new Reservation("Kural", "Suite"));
        queue.add(new Reservation("Subha", "Single"));
    }

    public Reservation getNext() {
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}

class RoomInventory {
    private Map<String, Integer> rooms = new HashMap<>();
    private Map<String, Integer> counters = new HashMap<>();

    public RoomInventory() {
        rooms.put("Single", 5);
        rooms.put("Double", 3);
        rooms.put("Suite", 2);

        counters.put("Single", 1);
        counters.put("Double", 1);
        counters.put("Suite", 1);
    }

    public boolean allocate(String roomType) {
        if (rooms.get(roomType) > 0) {
            rooms.put(roomType, rooms.get(roomType) - 1);
            return true;
        }
        return false;
    }

    public String generateRoomId(String roomType) {
        int id = counters.get(roomType);
        counters.put(roomType, id + 1);
        return roomType + "-" + id;
    }

    public Map<String, Integer> getRooms() {
        return rooms;
    }
}

class RoomAllocationService {
    public void allocateRoom(Reservation r, RoomInventory inventory) {
        if (inventory.allocate(r.roomType)) {
            String roomId = inventory.generateRoomId(r.roomType);
            System.out.println("Booking confirmed for Guest: " + r.guestName + ", Room ID: " + roomId);
        }
    }
}

class ConcurrentBookingProcessor implements Runnable {
    private BookingRequestQueue bookingQueue;
    private RoomInventory inventory;
    private RoomAllocationService allocationService;

    public ConcurrentBookingProcessor(BookingRequestQueue bookingQueue, RoomInventory inventory,
                                      RoomAllocationService allocationService) {
        this.bookingQueue = bookingQueue;
        this.inventory = inventory;
        this.allocationService = allocationService;
    }

    public void run() {
        while (true) {
            Reservation reservation;

            synchronized (bookingQueue) {
                if (bookingQueue.isEmpty()) return;
                reservation = bookingQueue.getNext();
            }

            synchronized (inventory) {
                allocationService.allocateRoom(reservation, inventory);
            }
        }
    }
}

public class BookMyStayApp {
    public static void main(String[] args) {

        System.out.println("Concurrent Booking Simulation");

        BookingRequestQueue bookingQueue = new BookingRequestQueue();
        RoomInventory inventory = new RoomInventory();
        RoomAllocationService allocationService = new RoomAllocationService();

        Thread t1 = new Thread(new ConcurrentBookingProcessor(bookingQueue, inventory, allocationService));
        Thread t2 = new Thread(new ConcurrentBookingProcessor(bookingQueue, inventory, allocationService));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread execution interrupted.");
        }

        System.out.println("\nRemaining Inventory:");
        for (Map.Entry<String, Integer> entry : inventory.getRooms().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}