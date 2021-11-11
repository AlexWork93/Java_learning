package A_B_control_flow_statements;

public class A_B_for_loop_HOMEWORK_1 {

    // using the for statement, call the calculateInterest method with
    // the amount of 10000 with an interestRate of 2,3,4,5,6,7, and 8
    // and print the results to the console window.



    public static void main(String[] args) {

        System.out.println(calculateInterest(10000, 8));
        System.out.println(calculateInterestBackwards(10000, 8));
        startFindingPrime(-40); //Invalid Input
        startFindingPrime(40);  //40 is prime and has 23 prime numbers before
        startFindingPrime(41);  //41 is not prime
        startFindingPrime(42);  //42 is prime and has 24 prime numbers before
    }

    public static String calculateInterest ( double amountMoney, double amountMonth){
        if (amountMoney > 0 && amountMonth > 0){
            String result = "Interests rate starts from 2% per month and increases on 1% every month.\n";
            for (int i = 2; i <= amountMonth; i++){
                double interestsRate = (amountMoney * i) / 100;
                result += String.format("For %s month interest rate would be %s\n", i, String.format("%.2f",interestsRate));
            }
            return result;
        }else return "Invalid input";
    }

    // How would you modify the for loop above to do the same thing as
    // shown but to start from 8% and work back to 2%

    public static String calculateInterestBackwards ( double amountMoney, double amountMonth){
        if (amountMoney > 0 && amountMonth > 0){
            String result = "Interests rate starts from 2% per month and increases on 1% every month.\n";
            for (double i = amountMonth; 2 <= i; i--){
                double interestsRate = (amountMoney * i) / 100;
                result += String.format("For %s month interest rate would be %s\n", i, String.format("%.2f",interestsRate));
            }
            return result;
        }else return "Invalid input";
    }


    // Create a for statement using any range of numbers
    // Determine if the number is a prime number using the isPrime method
    // if it is a prime number, print it out AND increment a count of the
    // number of prime numbers found
    // if that count is 3 exit the for loop
    // hint:  Use the break; statement to exit

    public static void startFindingPrime(int num){
        if (num < 1) {
            System.out.println("Invalid Input");
        }else if(isPrime(num)){
            int count = 0;
            for (int i = 10; i <= num; i++){
                if(isPrime(i)){
                    count++;
                }
            }
            System.out.printf("%s is prime and has %s prime numbers before\n", num, count);
        }else System.out.printf("%s is not prime\n", num);
    }

    public static boolean isPrime (int num){
            for(int i = 2; i <= Math.sqrt(num); i++){
                if(num % i == 0){
                    return true;
                }
            }
            return false;
    }


}
