package A_B_control_flow_statements;

import java.util.Scanner;

public class A_E_input_HOMEWORK_2 {
    //-Read the numbers from the console entered by the user and print the minimum and maximum number the user has entered.
    //-Before the user enters the number, print the message gEnter number:h
    //-If the user enters an invalid number, break out of the loop and print the minimum and maximum number.
    //
    //Hint:
    //-Use an endless while loop.
    //
    //Bonus:
    //-Create a project with the name MinAndMaxInputChallenge.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int min = 0;
        int max = 0;
        int input = 0;
        while (true){
            System.out.println("Enter the number to comparing or pass any letter to exit");
            boolean isAnInt = scanner.hasNextInt();
            if (isAnInt){
                input = scanner.nextInt();
                if (min == 0 && max == 0){
                    min = input;
                    max = input;
                }else if (input < min){
                    min = input;
                }else if (input > max){
                    max = input;
                }
                System.out.printf("Min = %s and max = %s\n", min, max);
            }else break;
        }
        scanner.close();
        System.out.printf("Min = %s and max = %s", min, max);
    }
}
