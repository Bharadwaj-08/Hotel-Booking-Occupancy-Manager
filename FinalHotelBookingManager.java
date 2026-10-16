
import java.util.*;
import java.io.*;
import java.util.stream.*;

// CO4: Custom Exception
class InvalidBookingException extends Exception {
    InvalidBookingException(String message) {
        super(message);
    }
}

// CO4: Class and Object
class Booking {
    private String customerName;
    private String roomType;
    private int rooms;
    private int days;
    private double total;

    // CO4: Constructor
    Booking(String customerName, String roomType,
            int rooms, int days, double total)
            throws InvalidBookingException {

        if (rooms <= 0 || days <= 0) {
            throw new InvalidBookingException(
                "Rooms and days must be positive!"
            );
        }

        this.customerName = customerName;
        this.roomType = roomType;
        this.rooms = rooms;
        this.days = days;
        this.total = total;
    }

    // CO4: Getters
    public String getCustomerName() {
        return customerName;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getTotal() {
        return total;
    }

    // CO4: Display method
    void display() {
        System.out.println("Customer: " + customerName);
        System.out.println("Room Type: " + roomType);
        System.out.println("Rooms: " + rooms);
        System.out.println("Days: " + days);
        System.out.println("Total Amount: Rs." + total);
    }
}

public class FinalHotelBookingManager {

    // CO1: Constants
    static final double STANDARD = 1000;
    static final double DELUXE = 1500;
    static final double SUITE = 2500;

    static Scanner sc = new Scanner(System.in);

    // CO2: Switch statement
    static double getRoomPrice(int choice) {
        switch (choice) {
            case 1:
                return STANDARD;
            case 2:
                return DELUXE;
            case 3:
                return SUITE;
            default:
                return 0;
        }
    }

    // CO2: If-else-if ladder
    static String getMembership(double total) {
        if (total < 5000)
            return "Basic";
        else if (total < 10000)
            return "Silver";
        else if (total < 15000)
            return "Gold";
        else
            return "Platinum";
    }

    // CO3: Method with parameters and return value
    static double calculateTotal(double price,
                                 int rooms, int days) {
        return price * rooms * days;
    }

    // CO3: Method overloading
    static double calculateTotal(double price, int rooms) {
        return price * rooms;
    }

    // CO3: Recursion
    static int factorial(int n) {
        if (n <= 1)
            return 1;

        return n * factorial(n - 1);
    }

    // CO5: Save booking details into a file
    static void saveBookings(ArrayList<Booking> bookings) {
        try (FileWriter fw = new FileWriter("bookings.txt")) {

            for (Booking b : bookings) {
                fw.write(b.getCustomerName() + ","
                        + b.getRoomType() + ","
                        + b.getTotal() + "\n");
            }

            System.out.println("Bookings saved successfully.");
        }
        catch (IOException e) {
            System.out.println("File writing error.");
        }
    }

    // CO5: Read booking details from file
    static void readBookings() {
        try (BufferedReader br =
                new BufferedReader(new FileReader("bookings.txt"))) {

            String line;

            System.out.println("\nSaved Bookings:");

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (IOException e) {
            System.out.println("File reading error.");
        }
    }

    public static void main(String[] args) {

        // CO6: ArrayList
        ArrayList<Booking> bookings = new ArrayList<>();

        // CO2: do-while loop
        char again;

        do {
            try {
                System.out.println("\n--- HOTEL BOOKING ---");

                // CO1: Scanner input
                System.out.print("Enter Customer Name: ");
                String name = sc.nextLine().trim();

                // CO5: String methods
                name = name.toLowerCase();
                name = name.substring(0, 1).toUpperCase()
                        + name.substring(1);

                System.out.println("\n1. Standard - Rs.1000");
                System.out.println("2. Deluxe - Rs.1500");
                System.out.println("3. Suite - Rs.2500");

                System.out.print("Select Room: ");
                int choice = sc.nextInt();

                double price = getRoomPrice(choice);

                if (price == 0) {
                    System.out.println("Invalid Room Choice!");
                    sc.nextLine();
                    continue;
                }

                System.out.print("Enter Number of Rooms: ");
                int rooms = sc.nextInt();

                System.out.print("Enter Number of Days: ");
                int days = sc.nextInt();

                sc.nextLine();

                // CO4: Object creation and exception handling
                double total = calculateTotal(price, rooms, days);

                Booking b = new Booking(
                    name,
                    choice == 1 ? "Standard" :
                    choice == 2 ? "Deluxe" : "Suite",
                    rooms, days, total
                );

                // CO6: Store booking object
                bookings.add(b);

                System.out.println("\n--- BOOKING DETAILS ---");
                b.display();

                System.out.println("Membership: "
                        + getMembership(total));

            }
            catch (InvalidBookingException e) {
                System.out.println(e.getMessage());
            }
            catch (InputMismatchException e) {
                System.out.println("Please enter valid numbers.");
                sc.nextLine();
            }
            finally {
                System.out.println("Booking process checked.");
            }

            System.out.print("\nDo you want another booking? (Y/N): ");
            again = sc.nextLine().trim().toUpperCase().charAt(0);

        } while (again == 'Y');

        // CO3: One-dimensional array
        int[] roomCounts = new int[bookings.size()];

        for (int i = 0; i < bookings.size(); i++) {
            roomCounts[i] = 1;
        }

        // CO3: Array summation and average
        int sum = 0;

        for (int value : roomCounts) {
            sum += value;
        }

        if (roomCounts.length > 0) {
            System.out.println("\nTotal Bookings: " + sum);
            System.out.println("Average: "
                    + (double) sum / roomCounts.length);
        }

        // CO3: Searching
        System.out.print("\nEnter customer name to search: ");
        String search = sc.nextLine().trim();

        boolean found = false;

        for (Booking b : bookings) {
            if (b.getCustomerName().equalsIgnoreCase(search)) {
                System.out.println("Booking Found!");
                b.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Booking Not Found.");
        }

        // CO3: Recursion demonstration
        System.out.println("\nFactorial of 5: " + factorial(5));

        // CO5: Save and read file
        saveBookings(bookings);
        readBookings();

        // CO6: HashMap
        HashMap<String, Double> roomTotals = new HashMap<>();

        for (Booking b : bookings) {
            roomTotals.put(
                b.getRoomType(),
                roomTotals.getOrDefault(b.getRoomType(), 0.0)
                        + b.getTotal()
            );
        }

        System.out.println("\nRoom Wise Booking Amounts:");
        System.out.println(roomTotals);

        // CO6: Stream API - filter()
        List<Booking> expensiveBookings = bookings.stream()
                .filter(b -> b.getTotal() >= 5000)
                .collect(Collectors.toList());

        System.out.println("Bookings above Rs.5000: "
                + expensiveBookings.size());

        // CO6: Stream API - map()
        List<String> customerNames = bookings.stream()
                .map(b -> b.getCustomerName())
                .collect(Collectors.toList());

        System.out.println("Customer Names: " + customerNames);

        // CO6: mapToDouble() and sum()
        double grandTotal = bookings.stream()
                .mapToDouble(b -> b.getTotal())
                .sum();

        System.out.println("Grand Total: Rs." + grandTotal);

        // CO3: Two-dimensional array and matrix addition
        int[][] A = {{1, 2}, {3, 4}};
        int[][] B = {{5, 6}, {7, 8}};
        int[][] C = new int[2][2];

        System.out.println("\nMatrix Addition:");

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                C[i][j] = A[i][j] + B[i][j];
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nThank You!");
        sc.close();
    }
}

