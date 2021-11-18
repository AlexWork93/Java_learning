package A_C_classes_constructors_inheritance;

public class A_B_constructors_HOMEWORK_2 {
    // Create a new class for a bank account
    // Create fields for the account number, balance, customer name, email and phone number.
    //
    // Create getters and setters for each field
    // Create two additional methods
    // 1.  To allow the customer to deposit funds (this should increment the balance field).
    // 2.  To allow the customer to withdraw funds.  This should deduct from the balance field,
    // but not allow the withdrawal to complete if their are insufficient funds.
    // You will want to create various code in the Main class (the one created by IntelliJ) to
    // confirm your code is working.
    // Add some System.out.println's in the two methods above as well.

    // Account bobsAccount = new Account(); // "12345", 0.00, "Bob Brown", "myemail@bob.com",
    //  //  "(087) 123-4567");
    // System.out.println(bobsAccount.getNumber());
    // System.out.println(bobsAccount.getBalance());
    //
    // bobsAccount.withdrawal(100.0);
    //
    // bobsAccount.deposit(50.0);
    // bobsAccount.withdrawal(100.0);
    //
    // bobsAccount.deposit(51.0);
    // bobsAccount.withdrawal(100.0);
    //
    // Account timsAccount = new Account("Tim", "tim@email.com","12345");
    // System.out.println(timsAccount.getNumber() + " name " + timsAccount.getCustomerName());

    // Create a new class VipCustomer
    // it should have 3 fields name, credit limit, and email address.
    // create 3 constructors
    // 1st constructor empty should call the constructor with 3 parameters with default values
    // 2nd constructor should pass on the 2 values it receives and add a default value for the 3rd
    // 3rd constructor should save all fields.
    // create getters only for this using code generation of intellij as setters wont be needed
    // test and confirm it works.
    public static void main(String[] args) {
         Account bobsAccount = new Account(); // "12345", 0.00, "Bob Brown", "myemail@bob.com",
          //  "(087) 123-4567");
         System.out.println(bobsAccount.getNumber());
         System.out.println(bobsAccount.getBalance());

         bobsAccount.withdrawal(100.0);

         bobsAccount.deposit(50.0);
         bobsAccount.withdrawal(100.0);

         bobsAccount.deposit(51.0);
         bobsAccount.withdrawal(100.0);

         Account timsAccount = new Account("Tim", "tim@email.com","12345");
         System.out.println(timsAccount.getNumber() + " name " + timsAccount.getCustomerName());

         //===============================================================================================

        VipCustomer vipCustomer1 = new VipCustomer();
        System.out.println(vipCustomer1.getAllFields());
        VipCustomer vipCustomer2 = new VipCustomer("Entered name", "Entered Mail");
        System.out.println(vipCustomer2.getAllFields());
        VipCustomer vipCustomer3 = new VipCustomer("Entered second name", 61456987, "Entered second mail");
        System.out.println(vipCustomer3.getAllFields());
    }
}

class Account{
    private String number;
    private double balance;
    private String name;
    private String email;
    private String phoneNumber;

    public Account() {
        this("default Number", 123456789, "default name", "Default email", "Default phone number");
    }

    public Account(String number, String name, String email) {
        this(number,0,name,email,"123456");
        this.number = number;
        this.name = name;
        this.email = email;
    }

    public Account(String number, double balance, String name, String email, String phoneNumber) {
        this.number = number;
        this.balance = balance;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getNumber() {
        return number;
    }

    public double getBalance() {
        return balance;
    }

    public String getCustomerName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void withdrawal(double value){
        balance -= value;
    }
    public void deposit(double value){
        balance += value;
    }
}

class VipCustomer{
    private String name;
    private double creditLimit;
    private String email;

    public VipCustomer() {
        this("Name", "Email@mail");
    }

    public VipCustomer(String name, String email) {
        this(name, 5000, email);
    }

    public VipCustomer(String name, double creditLimit, String email) {
        this.name = name;
        this.creditLimit = creditLimit;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public String getEmail() {
        return email;
    }
    public String getAllFields(){
        return "name = " + getName() +"\nCredit Limit = " + getCreditLimit() + "\nemail = " + getEmail() + "\n============================================\n\n\n";
    }
}