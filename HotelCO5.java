
import java.io.*;

public class HotelCO5 {
    public static void main(String[] args) {

        String details = " Rahul , Deluxe , 2 , 3 ";

        // String operations
        details = details.trim();

        String[] data = details.split(",");

        String name = data[0].trim();
        String room = data[1].trim();

        System.out.println("Name: " + name);
        System.out.println("Room: " + room);
        System.out.println("Name Length: " + name.length());
        System.out.println("Lowercase: " + room.toLowerCase());

        if (room.equals("Deluxe")) {
            System.out.println("Deluxe Room Selected");
        }

        // Writing booking details into a file
        try {
            FileWriter fw = new FileWriter("bookings.txt");
            fw.write(name + "," + room + "," + data[2].trim()
                    + "," + data[3].trim() + "\n");
            fw.close();

            System.out.println("Booking saved successfully.");
        }
        catch (IOException e) {
            System.out.println("File writing error.");
        }

        // Reading and searching booking details
        try (BufferedReader br =
                     new BufferedReader(new FileReader("bookings.txt"))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] booking = line.split(",");

                if (booking[0].equalsIgnoreCase("Rahul")) {
                    System.out.println("Booking Found: " + line);
                }
            }
        }
        catch (IOException e) {
            System.out.println("File reading error.");
        }
    }
}
