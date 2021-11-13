package A_B_control_flow_statements;

public class A_C_while_loop_HOMEWORK_2 {
    //Write a method with the name sumDigits that has one int parameter called number.
    //If parameter is >= 10 then the method should process the number and return sum of all digits, otherwise return -1 to indicate an invalid value.
    //The numbers from 0-9 have 1 digit so we donft want to process them, also we donft want to process negative numbers, so also return -1 for negative numbers.
    //For example calling the method sumDigits(125) should return 8 since 1 + 2 + 5 = 8.
    //Calling the method sumDigits(1) should return -1 as per requirements described above.
    //Add some code to the main method to test out the sumDigits method to determine that it is working correctly for valid and invalid values passed as arguments.
    //Hint:
    //	Use n % 10 to extract the least-significant digit.
    //	Use n = n / 10 to discard the least-significant digit.
    //	The method needs to be static like other methods so far in the course.
    //Tip:
    //	Create a project with the name DigitSumChallenge.

    public static void main(String[] args) {
        System.out.println(sumDigits(-50));     //-1
        System.out.println(sumDigits(100));     //1
        System.out.println(sumDigits(123));     //6
        System.out.println(sumDigits(5));       //-1
        System.out.println(sumDigits(234));     //9
        System.out.println(sumDigits(123456));  //21
        System.out.println(sumDigits(654321));  //21
        System.out.println(sumDigits(321));     //6
        System.out.println(sumDigits(147852));  //27

    }

    public static int sumDigits (int num){
        if(num < 10){
            return -1;
        }else {
            int sumOfDigitsInNum = 0;
            int number = num;
            int digit;
            while (number > 0){
                digit = number % 10;
                number = (number - digit) / 10;
                sumOfDigitsInNum += digit;
            }
            return sumOfDigitsInNum;
        }
    }


}
