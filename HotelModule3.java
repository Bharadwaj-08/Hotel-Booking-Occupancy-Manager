import java.util.Scanner;

public class HotelModule3 {

    // Method 1: Calculate total
    static double calculateTotal(double price, int rooms, int days) {
        return price * rooms * days;
    }

    // Method overloading
    static double calculateTotal(double price, int rooms) {
        return price * rooms;
    }

    // Method for searching
    static int searchBooking(int[] bookingRooms, int target) {

        for (int i = 0; i < bookingRooms.length; i++) {

            if (bookingRooms[i] == target) {
                return i;
            }
        }

        return -1;
    }

    // Method for summation
    static int findSum(int[] values) {

        int sum = 0;

        for (int value : values) {
            sum += value;
        }

        return sum;
    }

    // Method for average
    static double findAverage(int[] values) {

        int sum = findSum(values);

        return (double) sum / values.length;
    }

    // Method for counting
    static int countLargeBookings(int[] values) {

        int count = 0;

        for (int value : values) {

            if (value >= 3) {
                count++;
            }
        }

        return count;
    }

    // Recursion
    static int factorial(int n) {

        // Base case
        if (n == 0 || n == 1) {
            return 1;
        }

        // Recursive case
        return n * factorial(n - 1);
    }

    // 2D Matrix Addition
    static void matrixAddition(int[][] a, int[][] b) {

        int[][] result = new int[2][2];

        for (int i = 0; i < 2; i++) {

            for (int j = 0; j < 2; j++) {

                result[i][j] = a[i][j] + b[i][j];

                System.out.print(result[i][j] + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter room price: ");
        double price = sc.nextDouble();

        System.out.print("Enter number of rooms: ");
        int rooms = sc.nextInt();

        System.out.print("Enter number of days: ");
        int days = sc.nextInt();

        // Method invocation
        double total = calculateTotal(price, rooms, days);

        System.out.println("\nTotal Amount = Rs. " + total);

        // 1D Array
        int[] bookingRooms = {2, 1, 3, 4, 2};

        System.out.println("\nBooking Room Counts:");

        // Enhanced for loop
        for (int value : bookingRooms) {
            System.out.println(value);
        }

        // Searching
        System.out.print("\nEnter room count to search: ");
        int target = sc.nextInt();

        int position = searchBooking(bookingRooms, target);

        if (position != -1) {
            System.out.println("Found at position: " + position);
        } else {
            System.out.println("Booking not found");
        }

        // Summation
        int sum = findSum(bookingRooms);

        System.out.println("Total rooms booked: " + sum);

        // Average
        double average = findAverage(bookingRooms);

        System.out.println("Average rooms: " + average);

        // Counting
        int largeBookings = countLargeBookings(bookingRooms);

        System.out.println("Bookings with 3 or more rooms: "
                + largeBookings);

        // Recursion
        System.out.print("\nEnter number for factorial: ");
        int number = sc.nextInt();

        System.out.println("Factorial = " + factorial(number));

        // 2D Arrays
        int[][] matrixA = {
            {1, 2},
            {3, 4}
        };

        int[][] matrixB = {
            {5, 6},
            {7, 8}
        };

        System.out.println("\nMatrix Addition:");

        matrixAddition(matrixA, matrixB);

        sc.close();
    }
}