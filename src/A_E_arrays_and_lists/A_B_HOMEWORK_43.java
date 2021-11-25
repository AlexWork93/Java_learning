package A_E_arrays_and_lists;

import java.util.Arrays;

public class A_B_HOMEWORK_43 {
    //Write a method called reverse() with an int array as a parameter.
    //The method should not return any value. In other words, the method is allowed to modify the array parameter.
    //To reverse the array, you have to swap the elements, so that the first element is swapped with the last element and so on.
    //For example, if the array is [1, 2, 3, 4, 5], then the reversed array is [5, 4, 3, 2, 1].
    //The method should first print out the newly passed in array as Array = [1, 2, 3, 4, 5]
    //and then once it's been reversed, print it out as Reversed array = [5, 4, 3, 2, 1]
    //TIP: When swapping the elements, use a variable to temporarily hold the current element.
    //NOTE: The method should be defined as private static.
    //NOTE: Do not add a main method to the solution code.

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        reverse(arr);
    }

    private static void reverse(int[] arr){
        int[] reverseArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++){
            reverseArr[arr.length - i - 1] = arr[i];
        }
        System.out.println("Array = " + Arrays.toString(arr));
        System.out.println("Reversed array = " + Arrays.toString(reverseArr));
    }
}
