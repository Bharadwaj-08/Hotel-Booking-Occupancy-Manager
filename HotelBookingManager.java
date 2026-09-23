import java.util.Scanner;

public class HotelBookingManager {

    // Constants - Module 1
    static final double STANDARD_PRICE = 1000;
    static final double DELUXE_PRICE = 1500;
    static final double SUITE_PRICE = 2500;

    // Module 3: Method
    static double getRoomPrice(int choice) {

        // Module 2: switch
        switch (choice) {

            case 1:
                return STANDARD_PRICE;

            case 2:
                return DELUXE_PRICE;

            case 3:
                return SUITE_PRICE;

            default:
                return 0;
        }
    }

    // Module 3: Method
    static String getRoomType(int choice) {

        switch (choice) {

            case 1:
                return "Standard";

            case 2:
                return "Deluxe";

            case 3:
                return "Suite";

            default:
                return "Invalid";
        }
    }

    // Method with parameters and return value
    static double calculateTotal(
            double price,
            int rooms,
            int days) {

        return price * rooms * days;
    }

    // Method overloading
    static double calculateTotal(
            double price,
            int rooms) {

        return price * rooms;
    }

    // Customer category
    static String getCategory(double total) {

        if (total < 5000) {
            return "Regular";

        } else if (total < 10000) {
            return "Premium";

        } else {
            return "VIP";
        }
    }

    // Array summation
    static int calculateSum(int[] rooms) {

        int sum = 0;

        for (int value : rooms) {
            sum += value;
        }

        return sum;
    }

    // Array average
    static double calculateAverage(int[] rooms) {

        return (double) calculateSum(rooms)
                / rooms.length;
    }

    // Array searching
    static int searchBooking(int[] rooms, int target) {

        for (int i = 0; i < rooms.length; i++) {

            if (rooms[i] == target) {
                return i;
            }
        }

        return -1;
    }

    // Array counting
    static int countLargeBookings(int[] rooms) {

        int count = 0;

        for (int value : rooms) {

            if (value >= 3) {
                count++;
            }
        }

        return count;
    }

    // Recursion
    static int factorial(int n) {

        // Base case
        if (n <= 1) {
            return 1;
        }

        // Recursive case
        return n * factorial(n - 1);
    }

    // 2D Matrix addition
    static void matrixAddition(int[][] a, int[][] b) {

        System.out.println("\nMatrix Addition:");

        for (int i = 0; i < a.length; i++) {

            for (int j = 0; j < a[i].length; j++) {

                int result = a[i][j] + b[i][j];

                System.out.print(result + "\t");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Module 1
        System.out.println("=================================");
        System.out.println(" HOTEL BOOKING & OCCUPANCY");
        System.out.println("          MANAGER");
        System.out.println("=================================");

        System.out.print("Enter customer name: ");
        String name = sc.nextLine();

        char again='Y';

        // Module 2: do-while
        do {

            System.out.println("\nRoom Types:");
            System.out.println("1. Standard - Rs.1000");
            System.out.println("2. Deluxe   - Rs.1500");
            System.out.println("3. Suite    - Rs.2500");

            System.out.print("Enter room choice: ");
            int choice = sc.nextInt();

            // if validation
            if (choice < 1 || choice > 3) {

                System.out.println("Invalid room choice!");

                continue;
            }

            System.out.print("Enter number of rooms: ");
            int rooms = sc.nextInt();

            System.out.print("Enter number of days: ");
            int days = sc.nextInt();

            if (rooms <= 0 || days <= 0) {

                System.out.println(
                    "Rooms and days must be greater than zero."
                );

                continue;
            }

            // Method invocation
            double price = getRoomPrice(choice);

            String roomType = getRoomType(choice);

            double total = calculateTotal(
                    price,
                    rooms,
                    days
            );

            System.out.println("\n========== BOOKING ==========");
            System.out.println("Customer : " + name);
            System.out.println("Room     : " + roomType);
            System.out.println("Rooms    : " + rooms);
            System.out.println("Days     : " + days);

            System.out.printf(
                "Total    : Rs. %.2f%n",
                total
            );

            System.out.println(
                "Category : " + getCategory(total)
            );

            System.out.print(
                "\nDo you want another booking? (Y/N): "
            );

            again = sc.next().charAt(0);

        } while (again == 'Y' || again == 'y');

        // =====================================
        // ARRAY SECTION
        // =====================================

        int[] bookingRooms = {
            2, 1, 3, 4, 2
        };

        System.out.println(
            "\n===== BOOKING ARRAY ====="
        );

        // Enhanced for loop
        for (int value : bookingRooms) {

            System.out.print(value + " ");
        }

        // Sum
        System.out.println(
            "\nTotal Rooms = "
            + calculateSum(bookingRooms)
        );

        // Average
        System.out.println(
            "Average Rooms = "
            + calculateAverage(bookingRooms)
        );

        // Count
        System.out.println(
            "Large Bookings = "
            + countLargeBookings(bookingRooms)
        );

        // Searching
        System.out.print(
            "Enter room count to search: "
        );

        int target = sc.nextInt();

        int position =
            searchBooking(bookingRooms, target);

        if (position != -1) {

            System.out.println(
                "Booking found at position "
                + position
            );

        } else {

            System.out.println(
                "Booking not found"
            );
        }

        // =====================================
        // RECURSION
        // =====================================

        System.out.print(
            "\nEnter number for factorial: "
        );

        int number = sc.nextInt();

        System.out.println(
            "Factorial = "
            + factorial(number)
        );

        // =====================================
        // 2D ARRAY
        // =====================================

        int[][] matrixA = {
            {1, 2},
            {3, 4}
        };

        int[][] matrixB = {
            {5, 6},
            {7, 8}
        };

        matrixAddition(matrixA, matrixB);

        System.out.println(
            "\nProgram completed successfully."
        );

        sc.close();
    }
}