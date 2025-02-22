import java.io.*;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = "task1.txt";

        try (FileWriter writer = new FileWriter(fileName, true); 
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            System.out.println("Enter text to write in the file:");
            String userInput = scanner.nextLine();
            bufferedWriter.write(userInput);
            bufferedWriter.newLine();
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing the file.");
            e.printStackTrace();
        }

        try (FileReader reader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(reader)) {
       System.out.println("\nReading file:");
       String line;
       while ((line = bufferedReader.readLine()) != null) {
           System.out.println(line);
       }
   } catch (IOException e) {
       System.out.println("An error occurred while reading the file.");
       e.printStackTrace();
   }

   scanner.close();

    }  
}
