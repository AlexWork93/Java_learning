package A_B_control_flow_statements;

public class A_C_while_loop_HOMEWORK_1 {

    // Create a method called isEvenNumber that takes a parameter of type int
    // Its purpose is to determine if the argument passed to the method is
    // an even number or not.
    // return true if an even number, otherwise return false;

    // Modify the while code above
    // Make it also record the total number of even numbers it has found
    // and break once 50 are found
    // and at the end, display the total number of even numbers found

    public static void main(String[] args) {
        System.out.println(amountOfEvenNumbers(-50));   //-1
        System.out.println(amountOfEvenNumbers(100));   //2450
        System.out.println(amountOfEvenNumbers(500));   //2450
        System.out.println(amountOfEvenNumbers(30));    //210
        System.out.println(amountOfEvenNumbers(1));     //0
        System.out.println(amountOfEvenNumbers(200));   //2450

    }

    public static boolean isEvenNumber(int number){
        if (number < 0){
            return false;
        }else return number % 2 == 0;
    }

    public static int amountOfEvenNumbers(int number){
        if (number < 0){
            return -1;
        }else{
            int counter = 0;
            int iterator = 0;
            int res = 0;
            while (iterator < number){
                if(counter >= 50){
                    break;
                }else if (isEvenNumber(iterator)){
                    res += iterator;
                    counter++;
                }
                iterator++;
            }
            return res;
        }
    }

}
