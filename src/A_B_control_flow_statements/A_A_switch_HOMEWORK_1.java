package A_B_control_flow_statements;

public class A_A_switch_HOMEWORK_1 {
    //Write a method with the name printDayOfTheWeek that has one parameter of type int and name it day.
    //
    //The method should not return any value (hint: void)
    //
    //Using a switch statement print gSundayh, gMondayh, c ,gSaturdayh if the int parameter gdayh is 0, 1, c , 6
    // respectively, otherwise it should print gInvalid dayh.
    //
    //Bonus:
    //	Write a second solution using if then else, instead of using switch.
    //	Create a new project in IntelliJ with the  name gDayOfTheWeekChallengeh

    public static void main(String[] args) {
        printDayOfTheWeek_if(0);
        printDayOfTheWeek_if(1);
        printDayOfTheWeek_if(2);
        printDayOfTheWeek_if(3);
        printDayOfTheWeek_if(4);
        printDayOfTheWeek_if(5);
        printDayOfTheWeek_if(6);
        printDayOfTheWeek_if(7);
        System.out.println("\n===========================================================\n");
        printDayOfTheWeek_switch(0);
        printDayOfTheWeek_switch(1);
        printDayOfTheWeek_switch(2);
        printDayOfTheWeek_switch(3);
        printDayOfTheWeek_switch(4);
        printDayOfTheWeek_switch(5);
        printDayOfTheWeek_switch(6);
        printDayOfTheWeek_switch(7);
    }

    public static void printDayOfTheWeek_switch(int num){
        switch (num) {
            case 0 -> printDayName("Monday");
            case 1 -> printDayName("Tuesday");
            case 2 -> printDayName("Wednesday");
            case 3 -> printDayName("Thursday");
            case 4 -> printDayName("Friday");
            case 5 -> printDayName("Saturday");
            case 6 -> printDayName("Sunday");
            default -> printDayName("Unknown day");
        }

    }
    public static void printDayOfTheWeek_if(int num){
        if(num == 0){
            printDayName("Monday");
        }else if(num == 1){
            printDayName("Tuesday");
        }else if(num == 2){
            printDayName("Wednesday");
        }else if(num == 3){
            printDayName("Thursday");
        }else if(num == 4){
            printDayName("Friday");
        }else if(num == 5){
            printDayName("Saturday");
        }else if(num == 6){
            printDayName("Sunday");
        }else
            printDayName("Unknown day");
    }
    public static void printDayName(String dayName){
        System.out.println(dayName);
    }
}
