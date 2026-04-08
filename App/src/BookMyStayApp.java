import java.util.*;
/**
 * ============================================================
 UC10-BookingCancellation
 * CLASS - CancellationService
 * ============================================================
 * Use Case 10: Booking Cancellation & Inventory Rollback
 * Description:
 * This class is responsible for handling
 * booking cancellations.
 * It ensures that:
 * - Cancelled room IDs are tracked
 * - Inventory is restored correctly
 * - Invalid cancellations are prevented
 * A stack is used to model rollback behavior.
 * @version 10.0
 */
class RoomInventory {
    private Map<String, Integer> rooms;

    public RoomInventory() {
        rooms = new HashMap<>();
        rooms.put("Single", 5);
        rooms.put("Double", 3);
        rooms.put("Suite", 2);
    }

    public void increaseRoom(String roomType) {
        rooms.put(roomType, rooms.get(roomType) + 1);
    }

    public int getAvailability(String roomType) {
        return rooms.get(roomType);
    }
}

class CancellationService {
    private Stack<String> releasedRoomIds;
    private Map<String, String> reservationRoomTypeMap;

    public CancellationService() {
        releasedRoomIds = new Stack<>();
        reservationRoomTypeMap = new HashMap<>();
    }

    public void registerBooking(String reservationId, String roomType) {
        reservationRoomTypeMap.put(reservationId, roomType);
    }

    public void cancelBooking(String reservationId, RoomInventory inventory) {
        if (!reservationRoomTypeMap.containsKey(reservationId)) {
            System.out.println("Invalid reservation ID.");
            return;
        }

        String roomType = reservationRoomTypeMap.get(reservationId);
        inventory.increaseRoom(roomType);
        releasedRoomIds.push(reservationId);

        System.out.println("Booking cancelled successfully. Inventory restored for room type: " + roomType);
    }

    public void showRollbackHistory() {
        System.out.println("\nRollback History (Most Recent First):");

        while (!releasedRoomIds.isEmpty()) {
            String id = releasedRoomIds.pop();
            System.out.println("Released Reservation ID: " + id);
        }
    }
}

public class BookMyStayApp {
    public static void main(String[] args) {
        System.out.println("Booking Cancellation");

        RoomInventory inventory = new RoomInventory();
        CancellationService service = new CancellationService();

        service.registerBooking("Single-1", "Single");
        service.cancelBooking("Single-1", inventory);
        service.showRollbackHistory();

        System.out.println("\nUpdated Single Room Availability: "
                + inventory.getAvailability("Single"));
