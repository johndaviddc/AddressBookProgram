import java.util.ArrayList;
import java.util.Scanner;

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone Number: " + phoneNumber;
    }
}

class AddressBook {
    private ArrayList<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void editContact(int index, Contact newContact) {
        if (index >= 0 && index < contacts.size()) {
            contacts.set(index, newContact);
        }
    }

    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Address book is empty.");
        } else {
            for (int i = 0; i < contacts.size(); i++) {
                System.out.println((i + 1) + ". " + contacts.get(i));
            }
        }
    }

    public int searchContact(String name) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }
    
    public Contact getContact(int index) {
    	if (index >= 0 && index < contacts.size()) {
    		return contacts.get(index);
    	}
    	
    	return null;
    }
    
    public ArrayList<Contact> getContacts() {
    	return contacts;
    }
}

public class AddressBookProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();

        while (true) {
            System.out.println("\nAddress Book Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Search Contact");
            System.out.println("4. Display Contacts");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    Contact newContact = new Contact(name, phoneNumber);
                    addressBook.addContact(newContact);
                    System.out.println("Contact added successfully!");
                    break;

                case 2:
                    addressBook.displayContacts();
                    System.out.print("Enter the index of the contact to edit: ");
                    int index = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    int contactCount = addressBook.getContacts().size();
                    if (index >= 1 && index <= contactCount) {
                        System.out.print("Enter new name: ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter new phone number: ");
                        String newPhoneNumber = scanner.nextLine();
                        Contact editedContact = new Contact(newName, newPhoneNumber);
                        addressBook.editContact(index - 1, editedContact);
                        System.out.println("Contact edited successfully!");
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;

                case 3:
                    System.out.print("Enter name to search: ");
                    String searchName = scanner.nextLine();
                    int searchIndex = addressBook.searchContact(searchName);
                    if (searchIndex != -1) {
                    	Contact foundContact = addressBook.getContact(searchIndex);
                        System.out.println("Contact found: " + foundContact);
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 4:
                    addressBook.displayContacts();
                    break;

                case 5:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
