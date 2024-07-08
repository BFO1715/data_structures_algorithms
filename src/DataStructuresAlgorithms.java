/**
 *
 * @author bethan
 */
import java.util.*;

public class DataStructuresAlgorithms {

    /**
     * @param args Testing
     */
    public static void main(String[] args) {
        // Test cases for the AnagramChecker
        System.out.println(AnagramChecker.isAnagram("listen", "silent")); // true
        System.out.println(AnagramChecker.isAnagram("triangle", "integral")); // true
        System.out.println(AnagramChecker.isAnagram("apple", "pale")); // false
        
        System.out.println("----------------------------");
    
        // Test cases for the RecursiveSearch
        int[] array = {1, 2, 3, 4, 5};
        System.out.println(RecursiveSearch.search(array, 3)); // true
        System.out.println(RecursiveSearch.search(array, 6)); // false
        System.out.println(RecursiveSearch.search(array, 1)); // true
        System.out.println(RecursiveSearch.search(array, 5)); // true
        
        System.out.println("----------------------------");

        // Test cases for the SetChecker
        java.util.List<Integer> list1 = java.util.Arrays.asList(1, 2, 3, 4, 5);
        java.util.List<Integer> list2 = java.util.Arrays.asList(1, 2, 2, 4, 5);
        System.out.println(SetChecker.isSet(list1)); // true
        System.out.println(SetChecker.isSet(list2)); // false
        
         System.out.println("----------------------------");

        // Test cases for the HospitalQueue
        java.util.List<Patient> patients = new java.util.ArrayList<>();
        patients.add(new Patient(1, Priority.EMERGENCY, System.currentTimeMillis() - 60000)); // 1 minute ago
        patients.add(new Patient(2, Priority.URGENT, System.currentTimeMillis() - 120000)); // 2 minutes ago
        patients.add(new Patient(3, Priority.STANDARD, System.currentTimeMillis() - 180000)); // 3 minutes ago
        patients.add(new Patient(4, Priority.TRIVIAL, System.currentTimeMillis() - 240000)); // 4 minutes ago
        patients.add(new Patient(5, Priority.RESUSCITATION, System.currentTimeMillis())); // now

        // Get queue report
        Map<Priority, Integer> report = HospitalQueue.getQueueReport(patients);
        for (Map.Entry<Priority, Integer> entry : report.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("----------------------------");

        // Get next patient to be treated
        Patient nextPatient = HospitalQueue.getNextPatient(patients, System.currentTimeMillis());
        System.out.println("Next patient to be treated: " + nextPatient.getPatientID());

        System.out.println("----------------------------");

        // Calculate percentage of patients seen on time
        for (Patient patient : patients) {
            patient.setTreatmentTime(System.currentTimeMillis() - 5000); // set treatment time 5 seconds ago
        }
        double pctSeenOnTime = HospitalQueue.pctSeenOntime(patients);
        System.out.println("Percentage of patients seen on time: " + pctSeenOnTime + "%");

        System.out.println("----------------------------");

        // Calculate average overwait time
        double avgOverwaitTime = HospitalQueue.avgOverwaitTime(patients);
        System.out.println("Average overwait time: " + avgOverwaitTime + " minutes");
        
    }
   
}
