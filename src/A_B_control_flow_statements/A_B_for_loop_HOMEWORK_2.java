package A_B_control_flow_statements;

public class A_B_for_loop_HOMEWORK_2 {

    //Create a for statement using a range of numbers from 1 to 1000 inclusive.
    //Sum all the numbers that can be divided with both 3 and also with 5.
    //For those numbers that met the above conditions, print out the number.
    //break out of the loop once you find 5 numbers that met the above conditions.
    //After breaking out of the loop print the sum of the numbers that met the above conditions.
    //Note: Type all code in main method

    public static void main(String[] args) {
        int res = 0;
        int count = 0;
        for (int i = 1; i <= 1000; i++){
            if (count >= 10){
                break;
            }else if((i % 3 == 0)&&(i % 5 == 0)){
                System.out.printf("%s. %s is divided both by 3 and 5 \n",count + 1 , i);
                res += i;
                count ++;
            }
        }
        System.out.printf("sum of selected numbers is: %s", res);
    }

}
