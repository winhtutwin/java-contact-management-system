import java.util.ArrayList;
import java.util.Scanner;

public class ContactManagement {

    static ArrayList<Contact> contacts = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int option;

        do {
            // Menu
            System.out.println("Contact Management System");
            System.out.println("1. Add New Contact");
            System.out.println("2. List All Contacts");
            System.out.println("3. Search Contacts");
            System.out.println("4. Delete Contact");
            System.out.println("5. Edit Contact");
            System.out.println("0. Exit");
            System.out.print("Enter your option: ");
            option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1:
                    addNewContact();
                    break;
                case 2:
                    listAllContacts();
                    break;
                case 3:
                    searchContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    editContact();
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 0);
    }

    private static void addNewContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.println("1. Personal Contact");
        System.out.println("2. Business Contact");
        System.out.print("Enter your contact option: ");
        int contactOption = scanner.nextInt();
        scanner.nextLine(); // consume newline

        String type = (contactOption == 1) ? "Personal" : "Business";

        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        // Create a new Contact (email is no longer required)
        Contact newContact = new Contact(name, type, phoneNumber);
        contacts.add(newContact);
        System.out.println("Contact added successfully!");
    }

    private static void listAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            System.out.println("All Contacts:");
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    private static void searchContact() {
        System.out.print("Enter name to search: ");
        String searchName = scanner.nextLine();

        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(searchName)) {
                System.out.println("Contact found: " + contact);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No contact found with the name: " + searchName);
        }
    }

    private static void deleteContact() {
        System.out.print("Enter name of the contact to delete: ");
        String nameToDelete = scanner.nextLine();

        boolean deleted = false;
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equalsIgnoreCase(nameToDelete)) {
                contacts.remove(i);
                System.out.println("Contact deleted successfully!");
                deleted = true;
                break;
            }
        }
        if (!deleted) {
            System.out.println("No contact found with the name: " + nameToDelete);
        }
    }

    private static void editContact() {
        System.out.print("Enter name of the contact to edit: ");
        String nameToEdit = scanner.nextLine();

        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(nameToEdit)) {
                found = true;
                System.out.println("Editing contact: " + contact);

                System.out.print("Enter new phone number (or press Enter to keep the current): ");
                String newPhoneNumber = scanner.nextLine();
                if (!newPhoneNumber.isEmpty()) {
                    contact.setPhoneNumber(newPhoneNumber); // Use setter method
                }

                System.out.println("Contact updated successfully!");
                break;
            }
        }

        if (!found) {
            System.out.println("No contact found with the name: " + nameToEdit);
        }
    }
}
