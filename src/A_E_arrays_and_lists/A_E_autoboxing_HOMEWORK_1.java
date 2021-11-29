package A_E_arrays_and_lists;
//BAD EXAMPLE!!!!!!!
//BAD EXAMPLE!!!!!!!
//BAD EXAMPLE!!!!!!!
//BAD EXAMPLE!!!!!!!
//BAD EXAMPLE!!!!!!!
//BAD EXAMPLE!!!!!!!
//BAD EXAMPLE!!!!!!!
//BAD EXAMPLE!!!!!!!
//BAD EXAMPLE!!!!!!!
//BAD EXAMPLE!!!!!!!
//BAD EXAMPLE!!!!!!!
//BAD EXAMPLE!!!!!!!
//BAD EXAMPLE!!!!!!!
//BAD EXAMPLE!!!!!!!
//BAD EXAMPLE!!!!!!!
//BAD EXAMPLE!!!!!!!
//BAD EXAMPLE!!!!!!!
//BAD EXAMPLE!!!!!!!
//BAD EXAMPLE!!!!!!!
//BAD EXAMPLE!!!!!!!
//BAD EXAMPLE!!!!!!!
//BAD EXAMPLE!!!!!!!
//BAD EXAMPLE!!!!!!!
//BAD EXAMPLE!!!!!!!
//BAD EXAMPLE!!!!!!!
//BAD EXAMPLE!!!!!!!
//BAD EXAMPLE!!!!!!!
//BAD EXAMPLE!!!!!!!
//BAD EXAMPLE!!!!!!!
//BAD EXAMPLE!!!!!!!
//BAD EXAMPLE!!!!!!!
//BAD EXAMPLE!!!!!!!
//BAD EXAMPLE!!!!!!!
//BAD EXAMPLE!!!!!!!
//BAD EXAMPLE!!!!!!!
//BAD EXAMPLE!!!!!!!
//BAD EXAMPLE!!!!!!!
//BAD EXAMPLE!!!!!!!
//BAD EXAMPLE!!!!!!!
//BAD EXAMPLE!!!!!!!
//BAD EXAMPLE!!!!!!!
//BAD EXAMPLE!!!!!!!
//BAD EXAMPLE!!!!!!!
//BAD EXAMPLE!!!!!!!
import java.util.ArrayList;

public class A_E_autoboxing_HOMEWORK_1 {
    // You job is to create a simple banking application.
    // There should be a Bank class
    // It should have an arraylist of Branches
    // Each Branch should have an arraylist of Customers
    // The Customer class should have an arraylist of Doubles (transactions)
    // Customer:
    // Name, and the ArrayList of doubles.
    // Branch:
    // Need to be able to add a new customer and initial transaction amount.
    // Also needs to add additional transactions for that customer/branch
    // Bank:
    // Add a new branch
    // Add a customer to that branch with initial transaction
    // Add a transaction for an existing customer for that branch
    // Show a list of customers for a particular branch and optionally a list
    // of their transactions
    // Demonstration autoboxing and unboxing in your code
    // Hint: Transactions
    // Add data validation.
    // e.g. check if exists, or does not exist, etc.
    // Think about where you are adding the code to perform certain actions
    public static void main(String[] args) {
        myBank mybank = new myBank("AlexBank");
        mybank.addNewBranch("AlexBranch");
        mybank.addCustomer("AlexBranch", "AlexCustomer1");
        mybank.addCustomer("AlexBranch", "AlexCustomer1");
        mybank.addCustomer("AlexBranch", "AlexCustomer2");
        mybank.addCustomer("AlexBranch", "AlexCustomer3",500);
        mybank.addTransactionsToCustomer("AlexBranch", "AlexCustomer1", 500);
        mybank.addTransactionsToCustomer("AlexBranch", "AlexCustomer1", -1500);
        mybank.addTransactionsToCustomer("AlexBranch", "AlexCustomer2", 5600);
        mybank.addTransactionsToCustomer("AlexBranch", "AlexCustomer3", 76500);
        mybank.addTransactionsToCustomer("AlexBranch", "AlexCustomer1", 6500);
        mybank.addTransactionsToCustomer("AlexBranch", "AlexCustomer2", 400);
        mybank.addTransactionsToCustomer("AlexBranch", "AlexCustomer3", 12300);
        mybank.addTransactionsToCustomer("AlexBranch", "AlexCustomer1", 50013);
        mybank.addTransactionsToCustomer("AlexBranch", "AlexCustomer2", 21200);
        mybank.getListOfCustomersWithTransactions("AlexBranch");
        mybank.getListOfCustomers("AlexBranch");
        mybank.getListOfTransactions("AlexBranch", "AlexCustomer3");
    }
}

class myCustomer {
    private String name;
    private double accountBalance;
    private ArrayList<Double> transactions;

    public myCustomer(String name, double accountBalance) {
        this.name = name;
        this.accountBalance = accountBalance;
        this.transactions = new ArrayList<>();
        transactions.add(0.0);
    }

    public String getName() {
        return name;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void addTransaction(double value) {
        if ((accountBalance + value) >= 0) {
            accountBalance += value;
            transactions.add(value);
            System.out.printf("Transaction successful!\nTransaction value: %s;\nYour balance: %s.\n", value, accountBalance);
        } else
            System.out.printf("Transaction declined!\nTransaction value: %s;\nYour balance: %s.\n", value, accountBalance);
        System.out.println("======================================================");
    }

    public void GetListOfTransactions() {
        if (transactions.size() > 0) {
            String temp = "Transactions of " + name + " account:\n";
            for (int i = 0; i < transactions.size(); i++) {
                temp += transactions.get(i) + "\n";
            }
            System.out.println(temp);
        }else System.out.println("You don't have any transactions");
        System.out.println("======================================================");
    }
}

class myBranch {
    private String nameOfBranch;
    private ArrayList<myCustomer> myCustomers;

    public myBranch(String nameOfBranch) {
        this.nameOfBranch = nameOfBranch;
        this.myCustomers = new ArrayList<>();
        myCustomers.add(new myCustomer("TestCustomer", 0));
    }

    public String getNameOfBranch() {
        return nameOfBranch;
    }

    public void addCustomer(String nameOfCustomer, double accountBalance) {
        boolean flag = false;
        int i = 0;
        for (; i < myCustomers.size(); i++){
            if(myCustomers.get(i).getName().equals(nameOfCustomer)){
                flag = true;
                break;
            }
        }
        if(flag){
            System.out.printf("Customer with name %s is already exist.\n", nameOfCustomer);
        }else {
            myCustomers.add(new myCustomer(nameOfCustomer, accountBalance));
            System.out.printf("Customer with name %s was created\n", nameOfCustomer);
        }
        System.out.println("======================================================");
    }

    public void addTransactionToCustomer(String nameOfCustomer, double valueOfTransaction){
        boolean flag = false;
        int i = 0;
        for (; i < myCustomers.size(); i++){
            if(myCustomers.get(i).getName().equals(nameOfCustomer)){
                flag = true;
                break;
            }
        }
        if(flag){
            myCustomers.get(i).addTransaction(valueOfTransaction);
        }else {
            System.out.printf("Customer with name %s doesn't exist\n", nameOfCustomer);
            System.out.println("======================================================");
        }
    }

    public void getListOfTransactions(String nameOfCustomer){
        boolean flag = false;
        int i = 0;
        for (; i < myCustomers.size(); i++){
            if(myCustomers.get(i).getName().equals(nameOfCustomer)){
                flag = true;
                break;
            }
        }
        if(flag){
            myCustomers.get(i).GetListOfTransactions();
        }else {
            System.out.printf("Customer with name %s doesn't exist\n", nameOfCustomer);
            System.out.println("======================================================");
        }
    }

    public void getListOfCustomers(){
        String temp = String.format("Customers of branch %S:\n", nameOfBranch);
        for (int i = 0; i < myCustomers.size(); i++){
            temp += myCustomers.get(i).getName() + "\n";
        }
        System.out.println(temp);
        System.out.println("======================================================");
    }

    public void getListOfCustomersWithBalance(){
        String temp = String.format("Customers of branch %S:\n", nameOfBranch);
        for (int i = 0; i < myCustomers.size(); i++){
            temp += myCustomers.get(i).getName() + " " + myCustomers.get(i).getAccountBalance() +"\n";
        }
        System.out.println(temp);
        System.out.println("======================================================");
    }
}

class myBank {
    private String nameOfBank;
    private ArrayList<myBranch> myBranches;

    public myBank(String nameOfBank) {
        this.nameOfBank = nameOfBank;
        this.myBranches = new ArrayList<>();
        myBranches.add(new myBranch("TestBranch"));
    }

    public String getNameOfBank() {
        return nameOfBank;
    }

    public void addNewBranch(String nameOfBranch){
        boolean flag = false;
        for (int i = 0; i < myBranches.size(); i++){
            if(myBranches.get(i).getNameOfBranch().equals(nameOfBranch)){
                flag = true;
            }
        }
        if(flag){
            System.out.printf("Branch with name %s is already exist\n", nameOfBranch);
        }else {
            myBranch myBranch = new myBranch(nameOfBranch);
            myBranches.add(myBranch);
            System.out.printf("Branch with name %s was created\n", nameOfBranch);
        }
        System.out.println("======================================================");
    }
    public void addCustomerIntoBranch(String nameOfBranch, String nameOfCustomer, double balanceOfCustomer){
        boolean flag = false;
        int i = 0;
        for (;i < myBranches.size(); i++){
            if (myBranches.get(i).getNameOfBranch().equals(nameOfBranch)){
                flag = true;
                break;
            }
        }
        if (flag){
            myBranches.get(i).addCustomer(nameOfCustomer, balanceOfCustomer);
        }else {
            System.out.printf("Branch with name %s doesn't exist\n", nameOfBranch);
            System.out.println("======================================================");
        }
    }

    public void addCustomerIntoBranch(String nameOfBranch, String nameOfCustomer){
        addCustomerIntoBranch(nameOfBranch, nameOfCustomer, 0);
    }
    public void getListOfBranches(){
        String temp = String.format("Customers of branch %S:\n", nameOfBank);
        for (int i = 0; i < myBranches.size(); i++){
            temp += myBranches.get(i).getNameOfBranch() + "\n";
        }
        System.out.println(temp);
        System.out.println("======================================================");
    }

    public void getListOfCustomers(String nameOfBranch){
        boolean flag = false;
        int i = 0;
        for (; i < myBranches.size(); i++){
            if (myBranches.get(i).getNameOfBranch().equals(nameOfBranch)){
                flag = true;
                break;
            }
        }
        if (flag){
            myBranches.get(i).getListOfCustomers();
        }else {
            System.out.printf("Branch with name %s doesn't exist\n", nameOfBranch);
            System.out.println("======================================================");
        }
    }

    public void getListOfCustomersWithTransactions(String nameOfBranch){
        boolean flag = false;
        int i = 0;
        for (; i < myBranches.size(); i++){
            if (myBranches.get(i).getNameOfBranch().equals(nameOfBranch)){
                flag = true;
                break;
            }
        }
        if (flag){
            myBranches.get(i).getListOfCustomersWithBalance();
        }else {
            System.out.printf("Branch with name %s doesn't exist\n", nameOfBranch);
            System.out.println("======================================================");
        }
    }

    public void addTransactionsToCustomer(String nameOfBranch, String nameOfCustomer, double valueOfTransaction){
        boolean flag = false;
        int i = 0;
        for (; i < myBranches.size(); i++){
            if (myBranches.get(i).getNameOfBranch().equals(nameOfBranch)){
                flag = true;
                break;
            }
        }
        if (flag){
            myBranches.get(i).addTransactionToCustomer(nameOfCustomer, valueOfTransaction);
        }else {
            System.out.printf("Branch with name %s doesn't exist\n", nameOfBranch);
            System.out.println("======================================================");
        }
    }

    public void addCustomer(String nameOfBranch, String nameOfCustomer, double valueOfTransaction){
        boolean flag = false;
        int i = 0;
        for (; i < myBranches.size(); i++){
            if (myBranches.get(i).getNameOfBranch().equals(nameOfBranch)){
                flag = true;
                break;
            }
        }
        if (flag){
            myBranches.get(i).addCustomer(nameOfCustomer, valueOfTransaction);
        }else {
            System.out.printf("Branch with name %s doesn't exist\n", nameOfBranch);
            System.out.println("======================================================");
        }
    }

    public void addCustomer(String nameOfBranch, String nameOfCustomer){
        addCustomer(nameOfBranch, nameOfCustomer, 0);
    }

    public void getListOfTransactions(String nameOfBranch, String nameOfCustomer){
        boolean flag = false;
        int i = 0;
        for (; i < myBranches.size(); i++){
            if (myBranches.get(i).getNameOfBranch().equals(nameOfBranch)){
                flag = true;
                break;
            }
        }
        if (flag){
            myBranches.get(i).getListOfTransactions(nameOfCustomer);
        }else {
            System.out.printf("Branch with name %s doesn't exist\n", nameOfBranch);
            System.out.println("======================================================");
        }
    }
}













































