
import java.util.*;
import java.util.stream.*;

class HotelBooking {
    String name;
    String roomType;
    double amount;

    HotelBooking(String name, String roomType, double amount) {
        this.name = name;
        this.roomType = roomType;
        this.amount = amount;
    }
}

public class HotelCO6 {
    public static void main(String[] args) {

        // ArrayList
        ArrayList<HotelBooking> bookings = new ArrayList<>();

        bookings.add(new HotelBooking("Rahul", "Deluxe", 9000));
        bookings.add(new HotelBooking("Amit", "Standard", 3000));
        bookings.add(new HotelBooking("Priya", "Suite", 15000));

        // Display all bookings
        for (HotelBooking b : bookings) {
            System.out.println(b.name + " - " + b.roomType);
        }

        // HashMap
        HashMap<String, Double> totals = new HashMap<>();

        for (HotelBooking b : bookings) {
            totals.put(b.roomType,
                    totals.getOrDefault(b.roomType, 0.0) + b.amount);
        }

        System.out.println("Room Type Totals: " + totals);

        // Stream filter()
        List<HotelBooking> deluxeBookings = bookings.stream()
                .filter(b -> b.roomType.equals("Deluxe"))
                .collect(Collectors.toList());

        System.out.println("Deluxe Bookings: " + deluxeBookings.size());

        // Stream map()
        List<String> names = bookings.stream()
                .map(b -> b.name)
                .collect(Collectors.toList());

        System.out.println("Customer Names: " + names);

        // mapToDouble() and sum()
        double total = bookings.stream()
                .mapToDouble(b -> b.amount)
                .sum();

        System.out.println("Total Booking Amount: ₹" + total);
    }
}

