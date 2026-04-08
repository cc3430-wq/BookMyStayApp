import java.util.*;/**
 * ============================================================
 * MAIN CLASS - UseCase6RoomAllocation
 * ============================================================
 * Use Case 6: Reservation Confirmation & Room Allocation
 * Description:
 * This class demonstrates how booking
 * requests are confirmed and rooms
 * are allocated safely.
 * It consumes booking requests in FIFO
 * order and updates inventory immediately.
 * @version 6.0
 */
public class BookMyStayApp {
    public static void main(String[] args) {
        System.out.println("Room Allocation Processing");
        Queue<Reservation> queue = new LinkedList<>();
        queue.offer(new Reservation("Abhi", "Single"));
        queue.offer(new Reservation("Subha", "Single"));
        queue.offer(new Reservation("Vanmathi", "Suite"));
        RoomInventory inventory = new RoomInventory();
        RoomAllocationService service = new RoomAllocationService();
        while (!queue.isEmpty()) {
            Reservation r = queue.poll();
            service.allocateRoom(r, inventory);
        }
    }
}
class Reservation {
    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }
    public String getGuestName() {
        return guestName;
    }
    public String getRoomType() {
        return roomType;
    }
}
class RoomInventory {
    private Map<String, Integer> availability;
    public RoomInventory() {
        availability = new HashMap<>();
        availability.put("Single", 2);
        availability.put("Double", 2);
        availability.put("Suite", 1);
    }
    public boolean allocate(String roomType) {
        int count = availability.getOrDefault(roomType, 0);
        if (count > 0) {
            availability.put(roomType, count - 1);
            return true;
        }
        return false;
    }
}
class RoomAllocationService {
    private Set<String> allocatedRoomIds;
    private Map<String, Integer> roomCounters;
    public RoomAllocationService() {
        allocatedRoomIds = new HashSet<>();
        roomCounters = new HashMap<>();
    }
    public void allocateRoom(Reservation reservation, RoomInventory inventory) {
        String type = reservation.getRoomType();
        if (!inventory.allocate(type)) {
            System.out.println("No rooms available for " + reservation.getGuestName());
            return;
        }
        String roomId = generateRoomId(type);
        System.out.println("Booking confirmed for Guest: "
                + reservation.getGuestName()
                + ", Room ID: "
                + roomId);
    }
    private String generateRoomId(String roomType) {
        int count = roomCounters.getOrDefault(roomType, 0) + 1;
        roomCounters.put(roomType, count);
        String roomId = roomType + "-" + count;
        allocatedRoomIds.add(roomId);
        return roomId;
    }
}