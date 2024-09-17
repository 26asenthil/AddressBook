import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookApp {
    private static boolean verbose = false; // Flag for verbose mode
    private static String autosaveFilename = null; // Autosave filename
    private static boolean autosaveEnabled = false; // Flag to check if autosave is enabled

    public static void main(String[] args) {
        String filename = null;

        // Parse command-line arguments
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-a") && i + 1 < args.length) {
                filename = args[i + 1]; // Get the filename for file I/O
                i++; // Skip the next argument as it's part of the filename option
            } else if (args[i].equals("-v")) {
                verbose = true; // Enable verbose mode
            } else if (args[i].equals("-s") && i + 1 < args.length) {
                autosaveFilename = args[i + 1]; // Get the autosave filename
                autosaveEnabled = true; // Enable autosave
                i++; // Skip the next argument as it's part of the filename option
            }
        }

        AddressBook addressBook = new AddressBook(); // Create an instance of AddressBook to manage contacts

        if (filename != null) {
            readContactsFromFile(addressBook, filename); // Read contacts from the file if provided
            System.out.println("Contacts loaded from file: " + filename);
        }

        Scanner scanner = new Scanner(System.in); // Create a Scanner object for reading user input

        while (true) { // Start an infinite loop to continuously prompt the user for options
            System.out.println("\nOptions:");
            System.out.println("\t1. Add Contact");
            System.out.println("\t2. Search Contact");
            System.out.println("\t3. Edit Contact");
            System.out.println("\t4. Delete Contact");
            System.out.println("\t5. Display All Contacts");
            System.out.println("\t6. Run Hardcoded Test");
            System.out.println("\t7. Save Contacts");
            System.out.println("\t8. Read Contacts from File");
            System.out.println("\t9. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine().trim().toLowerCase(); // Read the user's choice, trim spaces, and convert to lowercase

            switch (choice) {
                case "1":
                case "add contact":
                case "add":
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine(); // Read the contact's name

                    String phone;
                    while (true) { // Loop until a valid phone number is entered
                        System.out.print("Enter Phone Number: ");
                        phone = scanner.nextLine().trim(); // Read and trim the phone number input
                        if (isValidPhoneNumber(phone)) { // Check if the phone number is valid
                            break; // Exit the loop if valid
                        } else {
                            System.out.println("Invalid phone number. Please enter a 10-digit phone number.");
                        }
                    }

                    System.out.print("Enter Email Address: ");
                    String email = scanner.nextLine(); // Read the contact's email
                    addressBook.addContact(new Contact(name, phone, email)); // Add the contact to the address book

                    if (verbose) {
                        System.out.println("[VERBOSE] Successfully added contact: " + name);
                    }

                    if (autosaveEnabled && autosaveFilename != null) {
                        writeContactsToFile(addressBook, autosaveFilename); // Autosave after adding a contact
                    }
                    break;

                case "2":
                case "search contact":
                case "search":
                    System.out.print("Enter Name to Search: ");
                    name = scanner.nextLine(); // Read the name to search for
                    Contact contact = addressBook.searchContact(name); // Search for the contact by name
                    if (contact != null) { // If the contact is found
                        System.out.println(contact); // Display the contact's details
                    } else {
                        System.out.println("Contact not found."); // Notify the user if the contact is not found
                    }

                    if (verbose) {
                        System.out.println("[VERBOSE] Search operation complete for: " + name);
                    }
                    break;

                case "3":
                case "edit contact":
                case "edit":
                    System.out.print("Enter Name to Edit: ");
                    name = scanner.nextLine(); // Read the name of the contact to edit

                    while (true) { // Loop until a valid new phone number is entered
                        System.out.print("Enter New Phone Number: ");
                        phone = scanner.nextLine().trim(); // Read and trim the new phone number input
                        if (isValidPhoneNumber(phone)) { // Check if the new phone number is valid
                            break; // Exit the loop if valid
                        } else {
                            System.out.println("Invalid phone number. Please enter a 10-digit phone number.");
                        }
                    }

                    System.out.print("Enter New Email Address: ");
                    email = scanner.nextLine(); // Read the new email address
                    addressBook.editContact(name, new Contact(name, phone, email)); // Update the contact with the new details

                    if (verbose) {
                        System.out.println("[VERBOSE] Edited contact: " + name);
                    }

                    if (autosaveEnabled && autosaveFilename != null) {
                        writeContactsToFile(addressBook, autosaveFilename); // Autosave after editing a contact
                    }
                    break;

                case "4":
                case "delete contact":
                case "delete":
                    System.out.print("Enter Name to Delete: ");
                    name = scanner.nextLine(); // Read the name of the contact to delete
                    addressBook.deleteContact(name); // Delete the contact from the address book

                    if (verbose) {
                        System.out.println("[VERBOSE] Deleted contact: " + name);
                    }

                    if (autosaveEnabled && autosaveFilename != null) {
                        writeContactsToFile(addressBook, autosaveFilename); // Autosave after deleting a contact
                    }
                    break;

                case "5":
                case "display all contacts":
                case "display":
                    addressBook.displayContacts(); // Display all contacts in the address book
                    if (verbose) {
                        System.out.println("[VERBOSE] Displayed all contacts.");
                    }
                    break;

                case "6":
                case "run hardcoded test":
                case "run":
                    runHardcodedTest(addressBook); // Run a predefined set of actions for testing
                    break;



                case "7":
                case "save contacts":
                case "save":
                    System.out.print("Enter filename to save contacts: ");
                    filename = scanner.nextLine().trim(); // Ask the user for a filename
                    if (!filename.isEmpty()) {
                        writeContactsToFile(addressBook, filename); // Save contacts to the specified file
                        System.out.println("Contacts saved to file: " + filename);
                    } else {
                        System.out.println("Filename cannot be empty.");
                    }
                    break;

                case "8":
                case "read contacts from file":
                case "read":
                    System.out.print("Enter filename to read contacts from: ");
                    filename = scanner.nextLine().trim(); // Ask the user for a filename to read from
                    if (!filename.isEmpty()) {
                        readContactsFromFile(addressBook, filename); // Read contacts from the specified file
                        System.out.println("Contacts loaded from file: " + filename);
                    } else {
                        System.out.println("Filename cannot be empty.");
                    }
                    break;

                default:
                    System.out.println("Invalid option. Please choose a valid option.");
                    break;

                case "9":
                case "exit":
                case "close":
                case "leave":
                    if (autosaveEnabled) {
                        writeContactsToFile(addressBook, autosaveFilename); // Write contacts to file before exiting
                    }
                    System.out.println("Exiting...");
                    scanner.close(); // Close the Scanner
                    System.exit(0); // Exit the program
                    break;
            }
        }
    }

    // Method to read contacts from a file
    private static void readContactsFromFile(AddressBook addressBook, String filename) {
        File file = new File(filename); // Create a File object

        // Check if the file exists, if not, create it
        if (!file.exists()) {
            try {
                if (file.createNewFile()) { // Create a new file if it doesn't exist
                    System.out.println("File not found. A new file has been created: " + filename);
                }
            } catch (IOException e) {
                System.out.println("Error creating file: " + filename);
            }
            return; // Return since the file is newly created, no contacts to read
        }

        // If the file exists, proceed with reading contacts
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(","); // Split the line into parts by comma
                if (parts.length >= 3) { // Ensure there are at least three parts (name, phone, email)
                    String name = parts[0].trim();
                    String phone = parts[1].trim();
                    String email = parts[2].trim();
                    if (!name.isEmpty() && !phone.isEmpty() && !email.isEmpty()) {
                        addressBook.addContact(new Contact(name, phone, email));
                    } else {
                        throw new InvalidFileFormatException();
                    }
                } else {
                    throw new InvalidFileFormatException();
                }
            }
        } catch (InvalidFileFormatException e) {
            System.out.println(e.getErrorMessage());
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file: " + filename);
        }
        //The IDE was tell me that there was an error without this catch. I'm not sure
        catch (IOException e) {
            System.out.println("Catastrophic Failure has occured");
            throw new RuntimeException(e);
        }
    }


    // Method to write contacts to a file
    private static void writeContactsToFile(AddressBook addressBook, String filename) {
        File file = new File(filename); // Create a File object
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) { // Use try-with-resources to automatically close the writer
            for (Contact contact : addressBook.getAllContacts()) {
                bw.write(contact.toCSV()); // Write each contact in CSV format
                bw.newLine(); // Add a newline after each contact
            }
            System.out.println("Contacts saved to file: " + filename);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + filename);
        }
    }

    // Method to validate phone numbers
    private static boolean isValidPhoneNumber(String phone) {
        // Simple validation: check if the phone number is 10 digits long
        return phone.matches("\\d{10}");
    }

    // Method to run a hardcoded test
    private static void runHardcodedTest(AddressBook addressBook) {
        System.out.println("Running hardcoded test...");

        // Adding test contacts
        addressBook.addContact(new Contact("Alice", "1234567890", "alice@example.com"));
        addressBook.addContact(new Contact("Bob", "0987654321", "bob@example.com"));

        // Displaying test contacts
        addressBook.displayContacts();

        // Editing a test contact
        addressBook.editContact("Alice", new Contact("Alice", "1111111111", "alice_new@example.com"));

        // Displaying contacts after editing
        addressBook.displayContacts();

        // Deleting a test contact
        addressBook.deleteContact("Bob");

        // Displaying contacts after deletion
        addressBook.displayContacts();
    }
}