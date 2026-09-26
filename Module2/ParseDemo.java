import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ParseDemo {
    public static void main(String[] args) {
        String filename = "numbers.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int value;
            double amount;
            while ((line = reader.readLine()) != null){
                value = Integer.parseInt(line.trim());
                System.out.println("\nParsed number: " + value);
                amount = value * 2;
                System.out.println("Parsed number doubled: " + amount);

            }
        } catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        }
    }
}