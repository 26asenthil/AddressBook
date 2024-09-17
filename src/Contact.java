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
    private String phone;
    private String email;

    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phone + ", Email: " + email;
    }
}



// AddressBook Class
class AddressBook {
    private Map<String, Contact> contacts = new HashMap<>();

    public void addContact(Contact contact) {
        contacts.put(contact.getName(), contact);
    }

    public Contact searchContact(String name) throws AddressBookEmptyException{
        if (contacts.isEmpty()) {
            throw new AddressBookEmptyException();
        }
        return contacts.get(name);
    }

    public void editContact(String name, Contact newContact) throws AddressBookEmptyException, ContactInvalidException {
        if (contacts.isEmpty()) {
            throw new AddressBookEmptyException();
        }
        if (!contacts.containsKey(name)) {
            throw new ContactInvalidException(name); // Throw exception if contact is invalid or not found
        }
        contacts.put(name, newContact);
    }

    public void deleteContact(String name) throws AddressBookEmptyException {
        if (contacts.isEmpty()) {
            throw new AddressBookEmptyException();
        }
        contacts.remove(name);
    }

    public void displayContacts() throws AddressBookEmptyException {
        if (contacts.isEmpty()) {
            throw new AddressBookEmptyException();
        }
        for (Contact contact : contacts.values()) {
            System.out.println(contact);
        }
    }

    public Iterable<Contact> getAllContacts() {
        return contacts.values();
    }

    public boolean isEmpty() {
        return contacts.isEmpty();
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
class ContactInvalidException extends Exception {
    public ContactInvalidException(String name) {
        super("Contact with name '" + name + "' is invalid or not found.");
    }
}





