package com.mycompany.datastructuresalgorithms;

/**
 *
 * @author bethan
 */
public class AnagramChecker {
    
    public static boolean isAnagram(String str1, String str2) {
        // Check if lengths of both strings are different
        if (str1.length() != str2.length()) {
            return false;
        }

        // Convert both strings to character arrays
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        // Sort both character arrays
        java.util.Arrays.sort(charArray1);
        java.util.Arrays.sort(charArray2);

        // Compare sorted character arrays
        return java.util.Arrays.equals(charArray1, charArray2);
    }
    
}