package A_B_control_flow_statements;

public class A_A_switch_statement {

    //Switch statement does the same thing like if-else does.
    //Here we will look on general form of switch statement.

    public static void main(String[] args) {

        // Create a new switch statement using char instead of int
        // create a new char variable
        // create a switch statement testing for
        // A, B, C, D, or E
        // display a message if any of these are found and then break
        // Add a default which displays a message saying not found

        System.out.println(switchTest('A'));
        System.out.println(switchTest('B'));
        System.out.println(switchTest('C'));
        System.out.println(switchTest('D'));
        System.out.println(switchTest('E'));
        System.out.println(switchTest('F'));

        //Switch statement works well with eny types of data
        System.out.println(nameOfMonth(1));
        System.out.println(nameOfMonth(2));
        System.out.println(nameOfMonth(3));
        System.out.println(nameOfMonth(4));

    }

    public static String switchTest(char liter){
        switch (liter){
            case 'A':
                return  "This is: " + liter;
            case 'B':
                return  "This is: " + liter;
            case 'C':
                return  "This is: " + liter;
            case 'D':
                return  "This is: " + liter;
            case 'E':
                return  "This is: " + liter;
            default:
                return  "I do not find current liter\n";
        }


    }

    // Or the form based on lambda expressions
    public static String nameOfMonth ( int numberOfMonth){
        return switch (numberOfMonth){
            case 1 -> "January";
            case 2 -> "February";
            case 3 -> "March";
            default -> "I do not know month anymore";
        };
    }

}
