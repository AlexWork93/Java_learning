package A_E_arrays_and_lists;

import java.util.Scanner;

public class A_A_array_HOMEWORK_1 {
    // Create a program using arrays that sorts a list of integers in descending order.
    // Descending order is highest value to lowest.
    // In other words if the array had the values in it 106, 26, 81, 5, 15 your program should
    // ultimately have an array with 106,81,26, 15, 5 in it.
    // Set up the program so that the numbers to sort are read in from the keyboard.
    // Implement the following methods - getIntegers, printArray, and sortIntegers
    // getIntegers returns an array of entered integers from keyboard
    // printArray prints out the contents of the array
    // and sortIntegers should sort the array and return a new array containing the sorted numbers
    // you will have to figure out how to copy the array elements from the passed array into a new
    // array and sort them and return the new sorted array.
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Enter length of array");
        int arrLength = scan.nextInt();
        int[] arr = getInteger(arrLength);
        System.out.println("This is your array");
        printArray(arr);
        int[] sortedArr = sortIntegers(arr);
        System.out.println("This is your sorted array");
        printArray(sortedArr);
    }

    public static int[] getInteger(int arrLength){
        int[] arr = new int[arrLength];
        for (int i = 0; i < arrLength; i++){
            arr[i] = scan.nextInt();
        }
        return arr;
    }

    public static void printArray(int[] arr){
        for (int i = 0;i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    public static int[] sortIntegers(int[] arr){
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length - 1; j++){
                if (arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }


}

