import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactsApp {
    private String CONTACTS_FILE = "contacts.txt";
    private List<Contact> contacts;
    private Scanner scanner;

    public ContactsApp() {
        contacts = new ArrayList<>();
        scanner = new Scanner(System.in);
        loadContacts();
    }

    public static void main(String[] args) {
        ContactsApp app = new ContactsApp();
        app.run();
    }

    private void run() {
        while (true) {
            displayMenu();
            System.out.print("Choose waht you will like to do. ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addContact();
                    break;
                case "2":
                    viewContacts();
                    break;
                case "3":
                    searchContact();
                    break;
                case "4":
                    deleteContact();
                    break;
                case "5":
                    editContact();
                    break;
                case "6":
                    saveContacts();
                    System.out.println("Thankyou for using Contacts App.");
                    return;
                default:
                    System.out.println("Invalid choice! \n Try again.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\nContact List Application");
        System.out.println("1. Add New Contact");
        System.out.println("2. View All Contacts");
        System.out.println("3. Search Contact");
        System.out.println("4. Delete Contact");
        System.out.println("5. Edit Contact");
        System.out.println("6. Save and Exit");
    }

    private void loadContacts() {
        try (BufferedReader reader = new BufferedReader(new FileReader(CONTACTS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    contacts.add(new Contact(parts[0], parts[1]));
                }
            }
        } catch (IOException e) {
            System.out.println("No existing contacts.");
        }
    }

    private void saveContacts() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CONTACTS_FILE))) {
            for (Contact contact : contacts) {
                writer.write(contact.getName() + "," + contact.getPhoneNumber());
                writer.newLine();
            }
            System.out.println("Contacts saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving contacts. " + e.getMessage());
        }
    }

    private void addContact() {
        System.out.print("Enter contact name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        contacts.add(new Contact(name, phoneNumber));
        System.out.println("Contact added!");
    }

    private void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contact found.");
            return;
        }
        System.out.println("\n--- Contacts ---");
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println((i + 1) + ". " + contacts.get(i));
        }
        System.out.println("----------------");
    }

    private void searchContact() {
        System.out.print("Enter name to search: ");
        String searchName = scanner.nextLine().toLowerCase();
        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getName().toLowerCase().contains(searchName)) {
                System.out.println(contact);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No contact found with " +searchName);
        }
    }

    private void deleteContact() {
        System.out.print("Enter name of the contact you want to delete: ");
        String nameToDelete = scanner.nextLine();
        boolean removed = contacts.removeIf(contact -> contact.getName().equalsIgnoreCase(nameToDelete));
        if (removed) {
            System.out.println("Contact deleted!");
        } else {
            System.out.println("Contact not found.");
        }
    }

    private void editContact() {
        System.out.print("Enter name of the contact you want to edit: ");
        String nameToEdit = scanner.nextLine();
        
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(nameToEdit)) {
                System.out.print("Enter new name (or press Enter to keep unchanged): ");
                String newName = scanner.nextLine();
                if (!newName.trim().isEmpty()) {
                    contact.setName(newName);
                }
                
                System.out.print("Enter new phone number (or press Enter to keep unchanged): ");
                String newPhoneNumber = scanner.nextLine();
                if (!newPhoneNumber.trim().isEmpty()) {
                    contact.setPhoneNumber(newPhoneNumber);
                }
                
                System.out.println("Contact updated!");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    class Contact {
        private String name;
        private String phoneNumber;

        public Contact(String name, String phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        @Override
        public String toString() {
            return "Name: " + name + ", Phone: " + phoneNumber;
        }
    }
}
