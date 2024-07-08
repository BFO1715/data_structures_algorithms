/**
 *
 * @author betha
 */
public class ComplexityAnalysis {

    /**
     * This method provides the time complexity analysis for the getNextPatient method.
     * 
     * @return String containing the time complexity analysis.
     */
    public static String getTimeComplexityAnalysis() {
        return "Time Complexity Analysis:\n" +
               "The time complexity of the getNextPatient method is O(n log n) due to the sorting step, " +
               "n is the number of patients in the list. Sorting takes O(n log n) time, and " +
               "iterating through the list takes O(n) time. As the overall time complexity is dominated " +
               "by the sorting step, it is: O(n log n).";
    }

    public static void main(String[] args) {
        // Output the time complexity analysis answer
        System.out.println(getTimeComplexityAnalysis());
    }
}
