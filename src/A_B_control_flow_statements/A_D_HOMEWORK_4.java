package A_B_control_flow_statements;

public class A_D_HOMEWORK_4 {
    //Write a method named hasSharedDigit with two parameters of type int.
    //Each number should be within the range of 10 (inclusive) - 99 (inclusive). If one of the numbers is not within the range, the method should return false.
    //The method should return true if there is a digit that appears in both numbers, such as 2 in 12 and 23; otherwise, the method should return false.
    //EXAMPLE INPUT/OUTPUT:
    //* hasSharedDigit(12, 23); → should return true since the digit 2 appears in both numbers
    //* hasSharedDigit(9, 99); → should return false since 9 is not within the range of 10-99
    //* hasSharedDigit(15, 55); → should return true since the digit 5 appears in both numbers
    //NOTE: The method hasSharedDigit should be defined as public static like we have been doing so far in the course.
    //NOTE: Do not add a main method to the solution code.

    public static void main(String[] args) {
        System.out.println(hasSharedDigit(12, 23));
        System.out.println(hasSharedDigit(9, 99));
        System.out.println(hasSharedDigit(15, 55));
    }

    public static boolean hasSharedDigit(int lowBorder, int topBorder){
        if(((lowBorder >= 10)&&(lowBorder <= 99))&&((topBorder >= 10)&&(topBorder <= 99))){
            int lowBorderDigit;
            int topBorderDigit;
            int topBorderTemp = topBorder;
            while (lowBorder > 0){
                lowBorderDigit = lowBorder % 10;
                lowBorder /= 10;
                while (topBorderTemp > 0){
                    topBorderDigit = topBorderTemp % 10;
                    topBorderTemp /= 10;
                    if (lowBorderDigit == topBorderDigit){
                        return true;
                    }
                }
                topBorderTemp = topBorder;
            }
        }
        return false;
    }
}
