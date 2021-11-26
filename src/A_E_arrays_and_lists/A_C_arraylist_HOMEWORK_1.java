package A_E_arrays_and_lists;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class A_C_arraylist_HOMEWORK_1 {
    // Create a program that implements a simple mobile phone with the following capabilities.
    // Able to store, modify, remove and query contact names.
    // You will want to create a separate class for Contacts (name and phone number).
    // Create a master class (MobilePhone) that holds the ArrayList of Contacts
    // The MobilePhone class has the functionality listed above.
    // Add a menu of options that are available.
    // Options:  Quit, print list of contacts, add new contact, update existing contact, remove contact
    // and search/find contact.
    // When adding or updating be sure to check if the contact already exists (use name)
    // Be sure not to expose the inner workings of the Arraylist to MobilePhone
    // e.g. no ints, no .get(i) etc
    // MobilePhone should do everything with Contact objects only.
    public static void main(String[] args) {
        myMobilePhone mobilePhone = new myMobilePhone();
        mobilePhone.startPhone();
    }
}

class myContact {
    private String name;
    private String phoneNumber;

    public myContact(String name, String phoneNumber) {
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
}

class myMobilePhone {
    private static Scanner scanner = new Scanner(System.in);
    private String name;
    private ArrayList<myContact> contacts;
    private boolean quit;;

    public myMobilePhone() {
        this.name = "Phone";
        this.contacts  = new ArrayList<>();;
        this.quit = true;
    }

    public void startPhone(){
        System.out.println("Phone is powered on.");
        showMenu();
        while (quit){
            System.out.println("Select option:");
            String choose;
                choose = scanner.nextLine();

            switch (choose){
                case "0":
                    quit = false;
                    System.out.println("Phone is powered off");
                    break;
                case "1":
                    System.out.println("Add new contact");
                    addNewContact();
                    break;
                case "2":
                    System.out.println("Update contact");
                    updateExistingContact();
                    break;
                case "3":
                    System.out.println("Remove contact");
                    removeContact();
                    break;
                case "4":
                    System.out.println("Search contact");
                    searchContact();
                    break;
                case "5":
                    System.out.println("Print list of contacts");
                    printContacts();
                    break;
                case "9":
                    showMenu();
                    break;
                default:
                    System.out.println("Incorrect input");
                    break;
            }
        }
    }
    private void showMenu(){
        System.out.println("1. Add new contact.");
        System.out.println("2. Update contact.");
        System.out.println("3. Remove contact.");
        System.out.println("4. Search contact.");
        System.out.println("5. Print list of contacts.");
        System.out.println("9. Show menu.");
        System.out.println("0. Quit.");
    }
    private void addNewContact(){
        int numberOfContact = getContact();
        if (numberOfContact >= 0){
            System.out.println("Contact already exists.");
        }else {
            System.out.println("Enter new contact name");
            String name = scanner.nextLine();
            System.out.println("Enter new contact number");
            String number = scanner.nextLine();
            myContact contact = new myContact(name, number);
            contacts.add(contact);
        }
    }
    private void updateExistingContact(){
        int numberOfContact = getContact();
        if (numberOfContact < 0){
            System.out.println("Contact does not exist.");
        }else {
            System.out.println("Enter contact name");
            String name = scanner.nextLine();
            System.out.println("Enter contact number");
            String number = scanner.nextLine();
            contacts.get(numberOfContact).setName(name);
            contacts.get(numberOfContact).setPhoneNumber(number);
        }
    }
    private void removeContact(){
        int numberOfContact = getContact();
        if (numberOfContact < 0){
            System.out.println("Contact does not exist.");
        }else {
            contacts.remove(numberOfContact);
        }
    }
    private void searchContact(){
        int numberOfContact = getContact();
        if (numberOfContact < 0){
            System.out.println("Contact does not exist.");
        }else {
            System.out.println("name: "
                    + contacts.get(numberOfContact).getName() + " phone: "
                    + contacts.get(numberOfContact).getPhoneNumber() + ".");
        }
    }
    private void printContacts(){
        String mess = "Contacts stored in your phone: \n";
        for (int i = 0; i < contacts.size(); i++){
            mess += i + 1 + ". name: " + contacts.get(i).getName()
                    + " phone: " + contacts.get(i).getPhoneNumber() + ".\n";
        }
        System.out.println(mess);
    }
    private int getContact() {
        String choose = "0";
        while (true){
            if (choose.equals("1")) break;
            else if (choose.equals("2")) break;
        System.out.println("Select option:");
        System.out.println("1. Search by name");
        System.out.println("2. Search by number");
        choose = scanner.nextLine();

        }
        if (choose.equals("1")) {
            System.out.println("Enter name: ");
            String name = scanner.nextLine().toLowerCase(Locale.ROOT).trim();
            for (int i = 0; i < contacts.size(); i++){
                if (name.equals(contacts.get(i).getName().toLowerCase().trim())) return i;
            }
        }else{
            System.out.println("Enter number: ");
            String phone = scanner.nextLine();
            for (int i = 0; i < contacts.size(); i++){
                if (phone.equals(contacts.get(i).getPhoneNumber().toLowerCase().trim())) return i;
            }
        }
        return -1;
    }

}
