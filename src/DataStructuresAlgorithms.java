/**
 *
 * @author bethan
 */
import graph.DiGraph;
import graph.WeightedDiGraph;
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
        
        System.out.println("----------------------------");
        
        // Test cases for the WebGraph
        DiGraph<String> graph = new DiGraph<>();
        graph.addEdge("A", "B");
        graph.addEdge("A", "H"); 
        graph.addEdge("B", "C");
        graph.addEdge("C", "D");
        graph.addEdge("D", "F");
        graph.addEdge("E", "G");
        graph.addEdge("F", "C");
        graph.addEdge("F", "I");
        graph.addEdge("G", "A");
        graph.addEdge("H", "G");
        graph.addEdge("I", "D");
        graph.addEdge("I", "E");
        graph.addEdge("J", "B"); 
        graph.addEdge("J", "D");

        // Get URLs from node "J" with max depth 3
        Set<String> urlsFromJ = WebGraph.getURLs(graph, "J", 3);
        System.out.println("URLs from J with max depth 3: " + urlsFromJ);

        // Get URLs from node "E" with max depth 2
        Set<String> urlsFromE = WebGraph.getURLs(graph, "E", 2);
        System.out.println("URLs from E with max depth 2: " + urlsFromE);
        
        System.out.println("----------------------------");
        
        // Test cases for the PopulationFlow
        WeightedDiGraph<String, Integer> populationGraph = new WeightedDiGraph<>();
        populationGraph.addEdge("A", "B", 1);
        populationGraph.addEdge("A", "H", 9);
        populationGraph.addEdge("B", "C", 2);
        populationGraph.addEdge("C", "D", 1);
        populationGraph.addEdge("D", "F", 8);
        populationGraph.addEdge("E", "G", 3);
        populationGraph.addEdge("F", "C", 14);
        populationGraph.addEdge("F", "I", 11);
        populationGraph.addEdge("G", "A", 2);
        populationGraph.addEdge("H", "G", 10);
        populationGraph.addEdge("I", "D", 6);
        populationGraph.addEdge("I", "E", 12);
        populationGraph.addEdge("J", "D", 9);
        populationGraph.addEdge("J", "B", 14);

        // Get declining cities
        Set<String> decliningCities = PopulationFlow.getDecliningCities(populationGraph);
        System.out.println("Declining cities: " + decliningCities);
        
        System.out.println("----------------------------");
        
        // Test cases for the vehicle charge
                List<Capture> captures = new ArrayList<>();
        captures.add(new Capture(1211424, "I", "GA13DSA"));
        captures.add(new Capture(2223332, "A", "AC21WAT")); // This will be ignored for GA13DSA
        captures.add(new Capture(3518399, "C", "GA13DSA"));
        captures.add(new Capture(3658471, "D", "GA13DSA"));

        WeightedDiGraph<String, Integer> cityGraph = new WeightedDiGraph<>();
        cityGraph.addEdge("A", "B", 1);
        cityGraph.addEdge("A", "H", 9);
        cityGraph.addEdge("B", "C", 2);
        cityGraph.addEdge("B", "J", 14);
        cityGraph.addEdge("C", "D", 1);
        cityGraph.addEdge("C", "F", 14);
        cityGraph.addEdge("D", "F", 8);
        cityGraph.addEdge("D", "J", 9);
        cityGraph.addEdge("E", "G", 3);
        cityGraph.addEdge("E", "I", 12);
        cityGraph.addEdge("F", "C", 14);
        cityGraph.addEdge("F", "I", 11);
        cityGraph.addEdge("G", "A", 2);
        cityGraph.addEdge("G", "H", 10);
        cityGraph.addEdge("I", "D", 6);
        cityGraph.addEdge("I", "E", 12);
        cityGraph.addEdge("J", "D", 9);
        cityGraph.addEdge("J", "B", 14);

        int charge = VehicleChargeCalculator.getVehicleCharge(cityGraph, captures, "GA13DSA");
        System.out.println("Vehicle charge for GA13DSA: " + charge + "p");
        
    }
    
}
