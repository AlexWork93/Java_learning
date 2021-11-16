package A_B_control_flow_statements;

import java.util.Scanner;

public class A_F_HOMEWORK_27 {
    //Write a method called inputThenPrintSumAndAverage that does not have any parameters.
    //The method should not return anything (void) and it needs to keep reading int numbers from the keyboard.
    //When the user enters something that is not an int then it needs to print a message in the format "SUM = XX AVG = YY".
    //XX represents the sum of all entered numbers of type int.
    //YY represents the calculated average of all numbers of type long.
    //EXAMPLES OF INPUT/OUTPUT:
    //EXAMPLE 1:
    //INPUT:
    //1
    //2
    //3
    //4
    //5
    //a
    //OUTPUT
    //SUM = 15 AVG = 3
    //EXAMPLE 2:
    //INPUT:
    //hello
    //OUTPUT:
    //SUM = 0 AVG = 0
    //TIP: Use Scanner to read an input from the user.
    //TIP: Use casting when calling the round method since it needs double as a parameter.
    //NOTE: Use the method Math.round to round the calculated average (double). The method round returns long.
    //NOTE: Be mindful of spaces in the printed message.
    //NOTE: Be mindful of users who may type an invalid input right away (see example above).
    //NOTE: The method inputThenPrintSumAndAverage should be defined as public static like we have been doing so far in the course.
    //NOTE: Do not add the main method to the solution code.


    public static void main(String[] args) {
        inputThenPrintSumAndAverage();
    }
    public static void inputThenPrintSumAndAverage(){
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int avg = 0;
        int input;
        int counter = 0;
        while (true){
            boolean isInt = scanner.hasNextInt();
            if (isInt){
                input = scanner.nextInt();
                counter++;
                sum += input;
                avg = (int) Math.round((double) sum / (double) counter);
            }else break;
        }
        System.out.printf("SUM = %s AVG = %s\n", sum, avg);
        scanner.close();
    }
}































