import java.util.HashMap;
import java.util.Map;

/**
 * ================================================================
 * MAIN CLASS – BookingMystayApp
 * ================================================================
 *
 * Book My Stay Application
 *
 * Use Case 3: Centralized Room Inventory Management
 *
 * Demonstrates centralized inventory using HashMap.
 *
 * @version 3.1
 */

public class BookingMystayApp {

    public static void main(String[] args) {

        System.out.println("Hotel Room Inventory Status\n");

        // Create room objects
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Display Single Room
        System.out.println("Single Room:");
        System.out.println("Beds: " + singleRoom.getBeds());
        System.out.println("Size: " + singleRoom.getSize() + " sqft");
        System.out.println("Price per night: " + singleRoom.getPricePerNight());
        System.out.println("Available Rooms: " +
                inventory.getRoomAvailability().get("Single Room"));

        System.out.println();

        // Display Double Room
        System.out.println("Double Room:");
        System.out.println("Beds: " + doubleRoom.getBeds());
        System.out.println("Size: " + doubleRoom.getSize() + " sqft");
        System.out.println("Price per night: " + doubleRoom.getPricePerNight());
        System.out.println("Available Rooms: " +
                inventory.getRoomAvailability().get("Double Room"));

        System.out.println();

        // Display Suite Room
        System.out.println("Suite Room:");
        System.out.println("Beds: " + suiteRoom.getBeds());
        System.out.println("Size: " + suiteRoom.getSize() + " sqft");
        System.out.println("Price per night: " + suiteRoom.getPricePerNight());
        System.out.println("Available Rooms: " +
                inventory.getRoomAvailability().get("Suite Room"));
    }
}


/**
 * ================================================================
 * CLASS – RoomInventory
 * ================================================================
 *
 * Manages centralized room availability.
 *
 * @version 3.0
 */

class RoomInventory {

    private Map<String, Integer> roomAvailability;

    public RoomInventory() {
        roomAvailability = new HashMap<>();
        initializeInventory();
    }

    private void initializeInventory() {

        roomAvailability.put("Single Room", 5);
        roomAvailability.put("Double Room", 3);
        roomAvailability.put("Suite Room", 2);

    }

    public Map<String, Integer> getRoomAvailability() {
        return roomAvailability;
    }

    public void updateAvailability(String roomType, int count) {
        roomAvailability.put(roomType, count);
    }
}


/**
 * ================================================================
 * ABSTRACT CLASS – Room
 * ================================================================
 *
 * Represents a general room type.
 */

abstract class Room {

    protected int beds;
    protected int size;
    protected double pricePerNight;

    public Room(int beds, int size, double pricePerNight) {
        this.beds = beds;
        this.size = size;
        this.pricePerNight = pricePerNight;
    }

    public int getBeds() {
        return beds;
    }

    public int getSize() {
        return size;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }
}


/**
 * Single Room Class
 */

class SingleRoom extends Room {

    public SingleRoom() {
        super(1, 250, 1500.0);
    }
}


/**
 * Double Room Class
 */

class DoubleRoom extends Room {

    public DoubleRoom() {
        super(2, 400, 2500.0);
    }
}


/**
 * Suite Room Class
 */

class SuiteRoom extends Room {

    public SuiteRoom() {
        super(3, 750, 5000.0);
    }
}