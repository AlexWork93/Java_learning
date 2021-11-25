package A_E_arrays_and_lists;

import java.util.Scanner;

public class A_A_array_HOMEWORK_2 {
    //-Write a method called readIntegers() with a parameter called count that represents how many integers the user needs to enter.
    //-The method needs to read from the console until all the numbers are entered, and then return an array containing the numbers entered.
    //-Write a method findMin() with the array as a parameter. The method needs to return the minimum value in the array.
    //-In the main() method read the count from the console and call the method readIntegers() with the count parameter.
    //-Then call the findMin() method passing the array returned from the call to the readIntegers() method.
    //-Finally, print the minimum element in the array.
    //Tips:
    //	-Assume that the user will only enter numbers, never letters
    //	-For simplicity, create a Scanner as a static field to help with data input
    //	-Create a new console project with the name eMinElementChallengef

    public static void main(String[] args) {
        int[] arr = readIntegers(5);
        int minFromArr = findMin(arr);
        System.out.println(minFromArr);
    }
    public static int[] readIntegers (int arrLength){
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[arrLength];
        for (int i =0; i < arr.length; i++){
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

    public static int findMin (int[] arr) {
        int res = arr[0];
        for (int i = 0; i < arr.length - 1; i++){
            if (res > arr[i + 1]){
                res = arr[i + 1];
            }
        }
        return res;
    }
}
