package com.mycompany.datastructuresalgorithms;

/**
 *
 * @author bethan
 */
public class RecursiveSearch {
    
    public static boolean search(int[] array, int target) {
        return searchHelper(array, target, 0);
    }
    
    private static boolean searchHelper(int[] array, int target, int index) {
        // Base case: If the index reaches the end of the array, return false
        if (index == array.length) {
            return false;
        }
        // If the current element is the target, return true
        if (array[index] == target) {
            return true;
        }
        // Recursive case: Move to the next element
        return searchHelper(array, target, index + 1);
    }
}
