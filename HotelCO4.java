
class InvalidBookingException extends Exception {
    InvalidBookingException(String message) {
        super(message);
    }
}

class Booking {
    private String customerName;
    private String roomType;
    private int rooms;
    private int days;

    // Parameterized constructor
    Booking(String customerName, String roomType, int rooms, int days)
            throws InvalidBookingException {

        if (rooms <= 0 || days <= 0) {
            throw new InvalidBookingException("Invalid booking details!");
        }

        this.customerName = customerName;
        this.roomType = roomType;
        this.rooms = rooms;
        this.days = days;
    }

    // Getters
    public String getCustomerName() {
        return customerName;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getRooms() {
        return rooms;
    }

    public int getDays() {
        return days;
    }

    // Setter
    public void setCustomerName(String name) {
        customerName = name;
    }

    void display() {
        System.out.println("Customer: " + customerName);
        System.out.println("Room Type: " + roomType);
        System.out.println("Rooms: " + rooms);
        System.out.println("Days: " + days);
    }
}

public class HotelCO4 {
    public static void main(String[] args) {

        try {
            Booking b = new Booking("Rahul", "Deluxe", 2, 3);
            b.display();
        }
        catch (InvalidBookingException e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Booking process completed.");
        }
    }
}
