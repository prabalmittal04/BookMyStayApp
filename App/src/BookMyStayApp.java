/**
 * ================================================================
 * MAIN CLASS – UseCase2RoomInitialization
 * ================================================================
 *
 * Use Case 2: Basic Room Types & Static Availability
 *
 * Description:
 * This class demonstrates room initialization
 * using domain models before introducing
 * centralized inventory management.
 *
 * Availability is represented using
 * simple variables to highlight limitations.
 *
 * @version 2.1
 */

public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Hotel Room Initialization\n");

        // Create Room Objects
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        // Static availability variables
        int singleAvailable = 5;
        int doubleAvailable = 3;
        int suiteAvailable = 2;

        // Display Single Room
        System.out.println("Single Room:");
        System.out.println("Beds: " + singleRoom.getBeds());
        System.out.println("Size: " + singleRoom.getSize() + " sqft");
        System.out.println("Price per night: " + singleRoom.getPricePerNight());
        System.out.println("Available: " + singleAvailable);

        System.out.println();

        // Display Double Room
        System.out.println("Double Room:");
        System.out.println("Beds: " + doubleRoom.getBeds());
        System.out.println("Size: " + doubleRoom.getSize() + " sqft");
        System.out.println("Price per night: " + doubleRoom.getPricePerNight());
        System.out.println("Available: " + doubleAvailable);

        System.out.println();

        // Display Suite Room
        System.out.println("Suite Room:");
        System.out.println("Beds: " + suiteRoom.getBeds());
        System.out.println("Size: " + suiteRoom.getSize() + " sqft");
        System.out.println("Price per night: " + suiteRoom.getPricePerNight());
        System.out.println("Available: " + suiteAvailable);
    }
}


/**
 * ================================================================
 * DOMAIN MODEL – Room
 * ================================================================
 *
 * Abstract class representing a general hotel room.
 *
 * @version 2.0
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
 * ================================================================
 * DOMAIN MODEL – Single Room
 * ================================================================
 *
 * @version 2.0
 */

class SingleRoom extends Room {

    public SingleRoom() {
        super(1, 250, 1500.0);
    }
}


/**
 * ================================================================
 * DOMAIN MODEL – Double Room
 * ================================================================
 *
 * @version 2.0
 */

class DoubleRoom extends Room {

    public DoubleRoom() {
        super(2, 400, 2500.0);
    }
}


/**
 * ================================================================
 * DOMAIN MODEL – Suite Room
 * ================================================================
 *
 * @version 2.0
 */

class SuiteRoom extends Room {

    public SuiteRoom() {
        super(3, 750, 5000.0);
    }
}