import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

// The Contact class represents an individual contact in the address book.
public class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        if (phoneNumber != null) {
            this.phoneNumber = phoneNumber;
        } else {
            this.phoneNumber = "";
        }

        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phoneNumber + ", Email: " + email;
    }
    public String toCSV() {
        return name + "," + phoneNumber + "," + email;
    }
}





class AddressBook {
    private Map<String, Contact> contacts = new HashMap<>();

    public void addContact(Contact contact) {
        contacts.put(contact.getName(), contact);
    }

    public Contact searchContact(String name) {
        return contacts.get(name);
    }

    public void editContact(String name, Contact newContact) {
        contacts.put(name, newContact);
    }

    public void deleteContact(String name) {
        contacts.remove(name);
    }

    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            for (Contact contact : contacts.values()) {
                System.out.println(contact);
            }
        }
    }

    // Get all contacts for saving to file
    public Iterable<Contact> getAllContacts() {
        return contacts.values();
    }
}

class InvalidFileFormatException extends Exception {
    public InvalidFileFormatException() {
        super(); // Call the superclass constructor without an error message
    }

    // Method to get a specific error message
    public String getErrorMessage() {
        return "Invalid file format: The file does not conform to the expected format.";
    }
}
class AddressBookEmptyException extends Exception {
    public AddressBookEmptyException() {
        super("The address book is empty.");
    }
}
class ContactNotFoundException extends Exception {
    public ContactNotFoundException(String name) {
        super("Contact with name '" + name + "' not found.");
    }
}




