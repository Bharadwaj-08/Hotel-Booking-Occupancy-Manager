
import java.util.Scanner;

public class HotelModule1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Constant
        final double STANDARD_PRICE = 1000.0;
        final double DELUXE_PRICE = 1500.0;
        final double SUITE_PRICE = 2500.0;

        // Variables
        String customerName;
        int roomType;
        int rooms;
        int days;
        double price;
        double total;

        // Input
        System.out.print("Enter customer name: ");
        customerName = sc.nextLine();

        System.out.println("\nRoom Types:");
        System.out.println("1. Standard");
        System.out.println("2. Deluxe");
        System.out.println("3. Suite");

        System.out.print("Enter room type: ");
        roomType = sc.nextInt();

        System.out.print("Enter number of rooms: ");
        rooms = sc.nextInt();

        System.out.print("Enter number of days: ");
        days = sc.nextInt();

        // Selecting price
        if (roomType == 1) {
            price = STANDARD_PRICE;
        } else if (roomType == 2) {
            price = DELUXE_PRICE;
        } else {
            price = SUITE_PRICE;
        }

        // Arithmetic expression
        total = price * rooms * days;

        // Typecasting example
        int roundedTotal = (int) total;

        // Formatted output
        System.out.println("\n=================================");
        System.out.println("       HOTEL BOOKING");
        System.out.println("=================================");

        System.out.printf("Customer Name : %s%n", customerName);
        System.out.printf("Rooms         : %d%n", rooms);
        System.out.printf("Days          : %d%n", days);
        System.out.printf("Room Price    : Rs. %.2f%n", price);
        System.out.printf("Total Amount  : Rs. %.2f%n", total);

        System.out.println("Integer Total : Rs. " + roundedTotal);

        sc.close();
    }
}