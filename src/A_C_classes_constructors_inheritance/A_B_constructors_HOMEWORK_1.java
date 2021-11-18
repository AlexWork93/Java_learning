package A_C_classes_constructors_inheritance;

public class A_B_constructors_HOMEWORK_1 {
    // Create a new class for a bank account
    // Create fields for the account number, balance, customer name, email and phone number.
    //
    // Create getters and setters for each field
    // Create two additional methods
    // 1. To allow the customer to deposit funds (this should increment the balance field).
    // 2. To allow the customer to withdraw funds. This should deduct from the balance field,
    // but not allow the withdrawal to complete if their are insufficient funds.
    // You will want to create various code in the Main class (the one created by IntelliJ) to
    // confirm your code is working.
    // Add some System.out.println's in the two methods above as well.
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setNumber(123456);
        bankAccount.setPhoneNumber(741258963);
        bankAccount.setBalance(800);
        bankAccount.setCustomerName("Chris");
        bankAccount.setEmail("chris@chris.lala");
        doSomeActions(bankAccount);
        BankAccount anotherAccount = new BankAccount(456789, 46547987, 5000, "Constructor Name", "Constructor Mail");
        doSomeActions(anotherAccount);
        BankAccount defaultAccount = new BankAccount();
        doSomeActions(defaultAccount);
    }
    public static void doSomeActions (BankAccount bankAccount){
        bankAccount.depositFunds(500);
        bankAccount.withdrawalFunds(200);
        bankAccount.withdrawalFunds(2000);
        bankAccount.getEntireInformation();
    }
}

class BankAccount{
    private int number;
    private int phoneNumber;
    private double balance;

    public BankAccount() {
        this(123456789, 123456789, 0, "Default Name", "Default Mail");
        System.out.println("Default constructor is called");
    }

    public BankAccount(int number, int phoneNumber, double balance, String customerName, String email) {
        this.number = number;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
        this.customerName = customerName;
        this.email = email;
        System.out.println("Constructor with parameters is called");
    }

    private String customerName;
    private String email;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void getEntireInformation(){
        System.out.printf("Number: %s; \nPhone number: %s; \nBalance: %s; \nMail: %s; \nCustomer name: %s. \n", number, phoneNumber, balance, email, customerName);
        System.out.println("==========================================================================\n\n\n");
    }
    public void depositFunds(double depositValue){
        if (depositValue > 0) {
            balance += depositValue;
            System.out.printf("Balance: %s\n",balance);
        }
        else System.out.println("Incorrect deposit value");
    }
    public void withdrawalFunds (double withdrawalValue){
        if (balance >= withdrawalValue){
            balance -= withdrawalValue;
            System.out.printf("Balance: %s\n",balance);
        }else System.out.printf("Operation is declined. \nBalance: %s\n",balance);
    }
}
