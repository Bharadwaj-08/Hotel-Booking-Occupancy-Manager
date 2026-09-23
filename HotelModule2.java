
import java.util.Scanner;

public class HotelModule2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        final double STANDARD = 1000;
        final double DELUXE = 1500;
        final double SUITE = 2500;

        int choice;
        int rooms;
        int days;
        double price;
        double total;

        char continueBooking='N';

        do {

            System.out.println("\n==============================");
            System.out.println("      HOTEL BOOKING");
            System.out.println("==============================");

            System.out.print("Enter number of rooms: ");
            rooms = sc.nextInt();

            System.out.print("Enter number of days: ");
            days = sc.nextInt();

            // Validation
            if (rooms <= 0 || days <= 0) {

                System.out.println("Invalid number of rooms/days!");

            } else {

                System.out.println("\nSelect Room Type:");
                System.out.println("1. Standard");
                System.out.println("2. Deluxe");
                System.out.println("3. Suite");

                System.out.print("Enter choice: ");
                choice = sc.nextInt();

                // Switch
                switch (choice) {

                    case 1:
                        price = STANDARD;
                        System.out.println("Standard Room Selected");
                        break;

                    case 2:
                        price = DELUXE;
                        System.out.println("Deluxe Room Selected");
                        break;

                    case 3:
                        price = SUITE;
                        System.out.println("Suite Selected");
                        break;

                    default:
                        System.out.println("Invalid room type!");
                        continue;
                }

                total = price * rooms * days;

                System.out.println("Total Amount = Rs. " + total);

                // if-else-if ladder
                if (total < 5000) {
                    System.out.println("Customer Category: Regular");
                } else if (total < 10000) {
                    System.out.println("Customer Category: Premium");
                } else {
                    System.out.println("Customer Category: VIP");
                }
            }

            System.out.print("\nDo you want another booking? (Y/N): ");
            continueBooking = sc.next().charAt(0);

        } while (continueBooking == 'Y' || continueBooking == 'y');

        // for loop
        System.out.println("\nBooking Counter:");

        for (int i = 1; i <= 5; i++) {

            if (i == 3) {
                continue;
            }

            System.out.println("Booking Number: " + i);
        }

        // while loop
        int count = 1;

        while (count <= 3) {
            System.out.println("Checking room availability...");
            count++;
        }

        sc.close();
    }
}