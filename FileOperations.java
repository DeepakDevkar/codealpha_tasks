import java.io.*;
import java.util.*;

public class FileOperations {

    // Method to write content to a file
    public static void writeToFile(String filename, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
            System.out.println("✔ File written successfully.");
        } catch (IOException e) {
            System.err.println("✖ Error writing to file: " + e.getMessage());
        }
    }

    // Method to read content from a file
    public static void readFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            System.out.println("📄 File content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("✖ Error reading from file: " + e.getMessage());
        }
    }

    // Method to modify file by replacing specific word
    public static void modifyFile(String filename, String oldWord, String newWord) {
        try {
            // Read entire content
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            StringBuilder content = new StringBuilder();

            while (scanner.hasNextLine()) {
                content.append(scanner.nextLine()).append(System.lineSeparator());
            }
            scanner.close();

            // Replace word
            String newContent = content.toString().replace(oldWord, newWord);

            // Write back to file
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            writer.write(newContent);
            writer.close();

            System.out.println("✏ File modified successfully.");
        } catch (IOException e) {
            System.err.println("✖ Error modifying file: " + e.getMessage());
        }
    }

    // Main method to demonstrate functionality
    public static void main(String[] args) {
        String filename = "internship_certificate.txt";
        String content = """
        CREATE A JAVA PROGRAM TO READ,
        WRITE, AND MODIFY TEXT FILES.

        COMPLETION CERTFICATE WILL BE
        ISSUED ON Y0UR INTERNSHIP

        END DATE .

        CODTECH

        INS T R U C T I O NS :
        FILE HANDLING

        UTILITY

        DELIVERABLE: A SCRIPT
        DEMONSTRATING FILE OPERATIONS
        WITH CLEAR DOCUMENTATION.
        """;

        // 1. Write to file
        writeToFile(filename, content);

        // 2. Read file
        readFromFile(filename);

        // 3. Modify file: fix typo "Y0UR" to "YOUR"
        modifyFile(filename, "Y0UR", "YOUR");

        // 4. Read again after modification
        readFromFile(filename);
    }
}
