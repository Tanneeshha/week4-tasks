import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task2 {

    public void readFile(String fileName) {
        File file = new File(fileName);

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found - " + e.getMessage());
        }
        System.out.println("Finished reading file.");
    }

    public String getFileName() {
        try (Scanner scanner = new Scanner(System.in)) {
            String fileName = "";

            try {
                while (true) {
                    System.out.print("Enter the file name you want to read: ");
                    fileName = scanner.nextLine().trim();

                    if (!fileName.isEmpty()) {
                        break;
                    }
                    System.out.println("Invalid input. File name cannot be empty.");
                }
            } catch (Exception e) {
                System.out.println("An unexpected error occurred while taking input: " + e.getMessage());
            }

            return fileName;
        }
    }

    public static void main(String[] args) {
        Task2 example = new Task2();
        String fileName = example.getFileName();
        example.readFile(fileName);
    }
}
