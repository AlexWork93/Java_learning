package A_A_basics;

public class A_F_methods_HOMEWORK_2 {
//    1. Write a method called toMilesPerHour that has 1 parameter of type double with the name kilometersPerHour.
//    This method needs to return the rounded value of the calculation of type long.
//
//    If the parameter kilometersPerHour is less than 0, the method toMilesPerHour needs to return -1 to indicate an invalid value.
//
//            Otherwise, if it is positive, calculate the value of miles per hour, round it and return it. For conversion and rounding,
//            check the notes in the text below.
//
//    Examples of input/output:
//            * toMilesPerHour(1.5); → should return value 1
//            * toMilesPerHour(10.25); → should return value 6
//            * toMilesPerHour(-5.6); → should return value -1
//            * toMilesPerHour(25.42); → should return value 16
//            * toMilesPerHour(75.114); → should return value 47
//
//
//            2. Write another method called printConversion with 1 parameter of type double with the name kilometersPerHour.
//
//    This method should not return anything (void) and it needs to calculate milesPerHour from the kilometersPerHour parameter.
//
//    Then it needs to print a message in the format "XX km/h = YY mi/h".
//
//    XX represents the original value kilometersPerHour.
//    YY represents the rounded milesPerHour from the kilometersPerHour parameter.
//
//    If the parameter kilometersPerHour is < 0 then print the text "Invalid Value".

    public static void main(String[] args) {
        printConversion(1.5);
        printConversion(10.25);
        printConversion(-5.6);
        printConversion(25.42);
        printConversion(75.114);
    }
    public static long toMilesPerHour(double kilometersPerHour){
        if (kilometersPerHour > 0){
            return Math.round(kilometersPerHour / 1.608);
        }else
            return -1;
    }
    public static void printConversion(double kilometersPerHour){
        long milesPerHour = toMilesPerHour(kilometersPerHour);
        if (milesPerHour > 0) {
            System.out.printf("%s km/h = %s mi/h\n", kilometersPerHour, milesPerHour);
        }else
            System.out.println("Invalid Value");
    }
}
