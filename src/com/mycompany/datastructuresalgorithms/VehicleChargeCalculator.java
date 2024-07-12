package com.mycompany.datastructuresalgorithms;

/**
 *
 * @author bethan
 */
import graph.WeightedDiGraph;
import graph.Pair;
import java.util.*;

public class VehicleChargeCalculator {

    public static int getVehicleCharge(WeightedDiGraph<String, Integer> graph, List<Capture> captures, String regNum) {
        List<String> locations = new ArrayList<>();
        
        // Filter captures for the registration number
        for (Capture capture : captures) {
            if (capture.getRegNum().equals(regNum)) {
                locations.add(capture.getLocation());
            }
        }

        if (locations.size() < 2) {
            return 0; // Not enough data to calculate the charge
        }

        int totalCharge = 0;
        for (int i = 0; i < locations.size() - 1; i++) {
            String start = locations.get(i);
            String end = locations.get(i + 1);
            int distance = getShortestDistance(graph, start, end);
            totalCharge += distance * 2;
        }

        return totalCharge;
    }

    public static int getShortestDistance(WeightedDiGraph<String, Integer> graph, String start, String end) {
        Map<String, Integer> distances = new HashMap<>();
        PriorityQueue<Pair<Integer, String>> priorityQueue = new PriorityQueue<>(Comparator.comparing(Pair::getFirst));
        Set<String> visited = new HashSet<>();
        distances.put(start, 0);
        priorityQueue.add(Pair.of(0, start));

        while (!priorityQueue.isEmpty()) {
            Pair<Integer, String> current = priorityQueue.poll();
            int currentDistance = current.getFirst();
            String currentNode = current.getSecond();

            if (!visited.add(currentNode)) {
                continue;
            }

            if (currentNode.equals(end)) {
                return currentDistance;
            }

            for (String neighbor : graph.getNodes()) {
                if (graph.hasEdge(currentNode, neighbor)) {
                    int weight = graph.getWeight(currentNode, neighbor);
                    int newDistance = currentDistance + weight;

                    if (newDistance < distances.getOrDefault(neighbor, Integer.MAX_VALUE)) {
                        distances.put(neighbor, newDistance);
                        priorityQueue.add(Pair.of(newDistance, neighbor));
                    }
                }
            }
        }

        return Integer.MAX_VALUE; // If no path found, return a large number
    }

    public static Set<String> getSpeedingVehicles(WeightedDiGraph<String, Integer> graph, List<Capture> captures) {
        Set<String> speedingVehicles = new HashSet<>();
        Map<String, List<Capture>> vehicleCaptures = new HashMap<>();

        // Group captures by vehicle registration number
        for (Capture capture : captures) {
            vehicleCaptures.computeIfAbsent(capture.getRegNum(), k -> new ArrayList<>()).add(capture);
        }

        // Calculate speed for each vehicle and check for speeding
        for (Map.Entry<String, List<Capture>> entry : vehicleCaptures.entrySet()) {
            List<Capture> vehicleCaptureList = entry.getValue();
            if (vehicleCaptureList.size() < 2) {
                continue; // Not enough data 
            }

            for (int i = 0; i < vehicleCaptureList.size() - 1; i++) {
                Capture startCapture = vehicleCaptureList.get(i);
                Capture endCapture = vehicleCaptureList.get(i + 1);
                String startLocation = startCapture.getLocation();
                String endLocation = endCapture.getLocation();
                int distance = getShortestDistance(graph, startLocation, endLocation);

                long timeTakenMillis = endCapture.getTime() - startCapture.getTime();
                double timeTakenHours = timeTakenMillis / 3600000.0; // Convert milliseconds to hours

                if (timeTakenHours > 0) {
                    double speed = distance / timeTakenHours;
                    if (speed > 30) {
                        speedingVehicles.add(entry.getKey());
                        break; // No need to check further captures for this vehicle
                    }
                }
            }
        }

        return speedingVehicles;
    }
}

