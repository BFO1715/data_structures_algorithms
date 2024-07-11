package com.mycompany.datastructuresalgorithms;

/**
 *
 * @author bethan
 */
public class ComplexityAnalysis2 {

    /**
     * This method provides the time complexity analysis for the getDecliningCities method.
     * 
     * @return String containing the time complexity analysis 2.
     */
    public static String getTimeComplexityAnalysis2() {
        return "The time complexity of the getDecliningCities method is O(n^2). " +
               "This is because for each node (city) in the graph (O(n)), we iterate through all nodes again " +
               "to calculate the incoming and outgoing populations (each O(n)). Nested iteration results in O(n^2) complexity.";
    }

    public static void main(String[] args) {
        // Output the time complexity analysis 2 answer
        System.out.println(getTimeComplexityAnalysis2());
    }
}
