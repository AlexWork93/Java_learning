package A_A_basics;

public class A_A_primitive_types {
    public static void main(String[] args) {
        String mess = "All primitive types has range of minimum and maximum values: \n";
        //To find out end of this range we should use next expressions
        int minValueOfInteger = Integer.MIN_VALUE;
        int maxValueOfInteger = Integer.MAX_VALUE;
        mess += "Minimal value of Integer type is: " + minValueOfInteger + "\n";
        mess += "Maximal value of Integer type is: " + maxValueOfInteger + "\n\n";
        mess += "If we try to add 1 to max value, it will reverse to a negative \n";
        mess += "Max value + 1 = " + (maxValueOfInteger + 1) + "\n";
        mess += "It is called Overflow \n \n";
        mess += "Also if we try to subtract 1 from minimum value it will reverse too \n";
        mess += "Min value - 1 = " + (minValueOfInteger - 1) + "\n";
        mess += "It is called Underflow \n \n";
        mess += "Both of them are bad things and we should avoid them\n \n";
        mess += "Now let's try to repeat this action with byte, short and long types \n";
        byte minValueOfByte = Byte.MIN_VALUE;
        byte maxValueOfByte = Byte.MAX_VALUE;
        mess += "Minimal value of Byte type is: " + minValueOfByte + "\n";
        mess += "Maximal value of Byte type is: " + maxValueOfByte + "\n\n";
        short minValueOfShort = Short.MIN_VALUE;
        short maxValueOfShort = Short.MAX_VALUE;
        mess += "Minimal value of Short type is: " + minValueOfShort + "\n";
        mess += "Maximal value of Short type is: " + maxValueOfShort + "\n\n";
        long minValueOfLong = Long.MIN_VALUE;
        long maxValueOfLong = Long.MAX_VALUE;
        mess += "Minimal value of Short type is: " + minValueOfLong + "\n";
        mess += "Maximal value of Short type is: " + maxValueOfLong + "\n\n";
        mess += "To store in long variable value greater than integer, we have to put L after number like 9273946239746L \n";
        mess += "==============================================================================\n\n";
        mess += "If we need to convert some types into another, we should use casting expressions \n";
        mess += "expression like <int number = 654645 / 2 will work properly\n";
        mess += "But if we try to <byte number = 50 / 2 it will give an error\n";
        mess += "When we perform any evaluation, java automatically cast types into int\n";
        mess += "So we need to cast it backwards\n";
        byte someResult = 100 ;
        System.out.println(someResult);


        System.out.println(mess);
    }
}
