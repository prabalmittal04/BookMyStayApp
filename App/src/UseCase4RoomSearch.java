import java.util.*;

// Domain Model: Room
class Room {
    private String type;
    private int beds;
    private int size;
    private double price;

    public Room(String type, int beds, int size, double price) {
        this.type = type;
        this.beds = beds;
        this.size = size;
        this.price = price;
    }

    public void displayRoomDetails() {
        System.out.println(type + " Room:");
        System.out.println("Beds: " + beds);
        System.out.println("Size: " + size + " sqft");
        System.out.println("Price per night: " + price);
    }
}

// Inventory (State Holder)
class RoomInventory {
    private Map<String, Integer> availability = new HashMap<>();

    public void addRoom(String type, int count) {
        availability.put(type, count);
    }

    // READ-ONLY ACCESS
    public Map<String, Integer> getRoomAvailability() {
        return availability;
    }
}

/**
 * CLASS - RoomSearchService
 *
 * Use Case 4: Room Search & Availability Check
 */
class RoomSearchService {

    public void searchAvailableRooms(
            RoomInventory inventory,
            Room singleRoom,
            Room doubleRoom,
            Room suiteRoom) {

        Map<String, Integer> availability = inventory.getRoomAvailability();

        System.out.println("Room Search\n");

        // Single Room
        if (availability.get("Single") > 0) {
            singleRoom.displayRoomDetails();
            System.out.println("Available: " + availability.get("Single"));
            System.out.println();
        }

        // Double Room
        if (availability.get("Double") > 0) {
            doubleRoom.displayRoomDetails();
            System.out.println("Available: " + availability.get("Double"));
            System.out.println();
        }

        // Suite Room
        if (availability.get("Suite") > 0) {
            suiteRoom.displayRoomDetails();
            System.out.println("Available: " + availability.get("Suite"));
            System.out.println();
        }
    }
}

/**
 * MAIN CLASS - UseCase4RoomSearch
 */
public class UseCase4RoomSearch {

    public static void main(String[] args) {

        // Create Inventory
        RoomInventory inventory = new RoomInventory();
        inventory.addRoom("Single", 5);
        inventory.addRoom("Double", 3);
        inventory.addRoom("Suite", 2);

        // Create Room Objects
        Room singleRoom = new Room("Single", 1, 250, 1500.0);
        Room doubleRoom = new Room("Double", 2, 400, 2500.0);
        Room suiteRoom = new Room("Suite", 3, 750, 5000.0);

        // Search Service
        RoomSearchService searchService = new RoomSearchService();

        // Perform Search (READ-ONLY)
        searchService.searchAvailableRooms(
                inventory,
                singleRoom,
                doubleRoom,
                suiteRoom
        );
    }
}