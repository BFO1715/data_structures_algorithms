package com.mycompany.datastructuresalgorithms;

/**
 *
 * @author bethan
 */
import graph.WeightedDiGraph;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PopulationFlow {

    public static <N> Set<N> getDecliningCities(WeightedDiGraph<N, Integer> graph) {
        Set<N> decliningCities = new HashSet<>();

        for (N city : graph.getNodes()) {
            int incoming = 0;
            int outgoing = 0;

            // Calculate total incoming people
            for (N neighbor : graph.getNodes()) {
                if (graph.hasEdge(neighbor, city)) {
                    incoming += graph.getWeight(neighbor, city);
                }
            }

            // Calculate total outgoing people
            for (N neighbor : graph.getNodes()) {
                if (graph.hasEdge(city, neighbor)) {
                    outgoing += graph.getWeight(city, neighbor);
                }
            }

            if (outgoing > incoming) {
                decliningCities.add(city);
            }
        }

        return decliningCities;
    }
}
