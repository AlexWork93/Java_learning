package A_E_arrays_and_lists;

import java.util.ArrayList;

public class A_E_autoboxing_HOMEWORK_2 {

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
        MyBank2 mybank = new MyBank2("AlexBank");
        result(mybank.addBranch("AlexBranch"));
        result(mybank.addCustomer("AlexBranch", "AlexCustomer1"));
        result(mybank.addCustomer("AlexBranch", "AlexCustomer1")); //expected false
        result(mybank.addCustomer("AlexBranch", "AlexCustomer2"));
        result(mybank.addCustomer("AlexBranch", "AlexCustomer3",500));
        result(mybank.addTransaction("AlexBranch", "AlexCustomer1", 500));
        result(mybank.addTransaction("AlexBranch", "AlexCustomer1", -1500)); //expected false
        result(mybank.addTransaction("AlexBranch", "AlexCustomer2", 5600));
        result(mybank.addTransaction("AlexBranch", "AlexCustomer3", 76500));
        result(mybank.addTransaction("AlexBranch", "AlexCustomer1", 6500));
        result(mybank.addTransaction("AlexBranch", "AlexCustomer2", 400));
        result(mybank.addTransaction("AlexBranch", "AlexCustomer3", 12300));
        result(mybank.addTransaction("AlexBranch", "AlexCustomer1", 50013));
        result(mybank.addTransaction("AlexBranch", "AlexCustomer2", 21200));
        result(mybank.printListOfBranches());

        mybank.printListOfCustomers("AlexBranch", true);
        mybank.printListOfCustomers("AlexBranch", false);

    }

    private static void result (boolean bool){
        if(bool){
            System.out.println("Operation was successful\n");
        }else System.out.println("Operation was declined\n");
    }

}
class MyCustomer2 {
    private String nameOfCustomer;
    private double customerBalance;
    private ArrayList<Double> transactions;

    public MyCustomer2(String nameOfCustomer, double customerBalance) {
        this.nameOfCustomer = nameOfCustomer;
        this.customerBalance = customerBalance;
        this.transactions = new ArrayList<>();
    }

    public String getName() {
        return nameOfCustomer;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public boolean addTransaction (double transactionVale){
        if ((customerBalance + transactionVale) >= 0){
            customerBalance += transactionVale;
            transactions.add(transactionVale);
            return true;
        }else return false;
    }
}

class MyBranch2 {
    private String nameOfBranch;
    private ArrayList<MyCustomer2> customers;

    public MyBranch2(String nameOfBranch) {
        this.nameOfBranch = nameOfBranch;
        this.customers = new ArrayList<>();
    }

    public String getNameOfBranch() {
        return nameOfBranch;
    }

    private MyCustomer2 getCustomer (String customerName) {
        for (int i = 0; i < customers.size(); i++){
            if (customers.get(i).getName().equals(customerName)){
                return customers.get(i);
            }
        }
        return null;
    }

    public boolean addCustomer(String customerName, double customerBalance){
        if (getCustomer(customerName) == null){
            customers.add(new MyCustomer2(customerName, customerBalance));
            return true;
        }else return false;
    }

    public boolean addTransaction(String customerName, double transactionValue){
        MyCustomer2 myCustomer2 = getCustomer(customerName);
        if (myCustomer2 != null){
            return myCustomer2.addTransaction(transactionValue);
        }else return false;
    }

    public boolean printListOfCustomers(boolean ifWithTransactions){
        if (!customers.isEmpty()){
            String mess = "List of customers of branch " + nameOfBranch + "\n";
            for (int i = 0; i < customers.size(); i++){
                MyCustomer2 myCustomer2 = customers.get(i);
                mess += i + 1 + ". " + myCustomer2.getName() + "\n";
                if (ifWithTransactions){
                    for (int j = 0; j < myCustomer2.getTransactions().size(); j++){
                        mess += "  " + (j + 1) + ". " + myCustomer2.getTransactions().get(j) + "\n";
                    }
                }
            }
            System.out.println(mess);
            System.out.println("========================================================");
            return true;
        }else {
            System.out.println("Customers list is empty");
            System.out.println("========================================================");
            return false;
        }
    }

}

class MyBank2 {
    private String nameOfBank;
    private ArrayList<MyBranch2> branches;

    public MyBank2(String nameOfBank) {
        this.nameOfBank = nameOfBank;
        this.branches = new ArrayList<>();
    }

    private MyBranch2 getBranch (String branchName) {
        for (int i = 0; i < branches.size(); i++){
            if (branches.get(i).getNameOfBranch().equals(branchName)){
                return branches.get(i);
            }
        }
        return null;
    }

    public boolean addBranch(String branchName){
        if (getBranch(branchName) == null){
            return branches.add(new MyBranch2(branchName));
        }else return false;
    }

    public boolean addCustomer(String branchName, String customerName, double customerBalance){
        MyBranch2 myBranch2 = getBranch(branchName);
        if (myBranch2 != null){
            return myBranch2.addCustomer(customerName, customerBalance);
        }else return false;
    }

    public boolean addCustomer(String branchName, String customerName){
        return addCustomer(branchName, customerName, 0);
    }

    public boolean addTransaction(String branchName, String customerName, double transactionValue){
        MyBranch2 myBranch2 = getBranch(branchName);
        if (myBranch2 != null){
            return myBranch2.addTransaction(customerName, transactionValue);
        }else return false;
    }

    public boolean printListOfBranches(){
        if (!branches.isEmpty()){
            String mess = "List of branches of list " + nameOfBank + "\n";
            for (int i = 0; i < branches.size(); i++){
                MyBranch2 myBranch2 = branches.get(i);
                mess += i + 1 + ". " + myBranch2.getNameOfBranch() + "\n";
            }
            System.out.println(mess);
            System.out.println("========================================================");
            return true;
        }else {
            System.out.println("Branches list is empty");
            System.out.println("========================================================");
            return false;
        }
    }

    public boolean printListOfCustomers(String branchName, boolean ifWithTransactions){
        MyBranch2 myBranch2 = getBranch(branchName);
        if (myBranch2 != null){
            return myBranch2.printListOfCustomers(ifWithTransactions);
        }else {
            System.out.println("Branches list is empty");
            System.out.println("========================================================");
            return false;
        }
    }
}



































