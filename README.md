# **Address Book Application**

## **About**

The Address Book Application is a simple Java console-based application that allows users to manage a list of contacts. Users can add, search, edit, delete, and display contacts. Additionally, the application includes a feature to run a hardcoded test that performs predefined actions on the address book.

## **Features**

- **Add Contact:** Add a new contact with a name, phone number, and email address.
- **Search Contact:** Search for a contact by name and display the contact's details if found.
- **Edit Contact:** Update the phone number and email address of an existing contact.
- **Delete Contact:** Remove a contact from the address book by name.
- **Display All Contacts:** Show all contacts in the address book, sorted alphabetically by name.
- **Run Hardcoded Test:** Execute a series of predefined actions to test the application, including:
    - Adding two contacts.
    - Displaying all contacts.
    - Searching for a specific contact.
    - Editing contact details.
    - Deleting one contact.
    - Displaying all contacts again to verify changes.
- **Save Contacts to File:** Save the current list of contacts to a specified file.
- **Load Contacts from File:** Load contacts from a specified file into the address book.
- **Exit:** Exit the application.

## **Requirements**

- Java Development Kit (JDK) installed on your machine.
- A text editor or IDE to run and modify the code (e.g., IntelliJ IDEA, Visual Studio Code).


## **Command-Line Arguments**

The Address Book Application supports command-line arguments to customize its behavior. Here are the available options:

- `-a <filename>`: Load contacts from the specified file at startup. The file should contain one contact per line, with the format: `Name,Phone,Email`.
- `-s <filename>`: Autosave contacts to the specified file when the application exits. The file will be created if it doesn't exist, or overwritten if it does.
- `-v`: Enable verbose mode, which displays additional information during operations such as adding, searching, editing, and deleting contacts.

    To use these command-line arguments, run the application with the desired options followed by the corresponding values. For example:
    ```bash
    java AddressBookApp -a contacts.txt -s saved_contacts.txt -v


## **How to Run the Application**

1. **Clone or Download the Code:**
   Save the provided code in a file named `AddressBookApp.java`.

2. **Compile the Code:**
   Open a terminal or command prompt, navigate to the directory where `AddressBookApp.java` is located, and compile the code using:
   ```bash
   javac AddressBookApp.java


## **Run the Application:**

After successful compilation, run the application using the following command:

`java AddressBookApp`


## **Interact with the Application:**

Follow the on-screen prompts to add, search, edit, delete, or display contacts.
Use commandline arguements to interact with the application.
Enter the corresponding number or text for the desired action (e.g., 1 or add contact to add a new contact).
The application includes a hardcoded test option (Option 6) that:
Adds two contacts to the address book.
Displays all contacts.
Searches for a specific contact.
Edits the contact details.
Deletes one contact.
Displays all contacts again to verify the changes.

## **Credits**
1. RealESRGAN (https://github.com/xinntao/Real-ESRGAN/blob/master/README.md) on github for inspiration from their readme file
2. Tabnine chatai for assistance in javadocs, getters/setters, general syntax inquiries
3. Dhruv Singh for name usage
4. Stackoverflow with specifics listed below
## **Sources**
- [Java HashMap: Working with Key-Value Pairs](https://stackoverflow.com/questions/15528139/how-to-use-hashmap-in-java)
- [Handling Exceptions in Java: Best Practices](https://stackoverflow.com/questions/6415916/what-are-the-best-practices-for-handling-exceptions-in-java)
- [How to Sort a List in Java](https://stackoverflow.com/questions/3483068/sort-a-list-in-java)
- [Java Console Input and Output](https://stackoverflow.com/questions/5055141/how-to-get-input-from-console-in-java)
- [Java Method Overloading and Overriding](https://stackoverflow.com/questions/1465476/what-is-the-difference-between-method-overloading-and-method-overriding)
