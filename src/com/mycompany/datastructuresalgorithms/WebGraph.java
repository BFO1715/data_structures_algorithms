package com.mycompany.datastructuresalgorithms;

/**
 *
 * @author bethan
 */
import graph.DiGraph;
import graph.Pair;
import java.util.*;

public class WebGraph {

    public static <N> Set<N> getURLs(DiGraph<N> graph, N start, int maxDepth) {
        Set<N> result = new HashSet<>();
        Queue<Pair<N, Integer>> queue = new LinkedList<>();
        Set<N> visited = new HashSet<>();

        queue.add(createPair(start, 0));
        visited.add(start);

        while (!queue.isEmpty()) {
            Pair<N, Integer> current = queue.poll();
            N currentNode = current.getFirst();
            int currentDepth = current.getSecond();

            if (currentDepth > maxDepth) {
                continue;
            }

            result.add(currentNode);

            for (N neighbor : graph.getOutNeighbours(currentNode)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(createPair(neighbor, currentDepth + 1));
                }
            }
        }

        return result;
    }

    private static <N> Pair<N, Integer> createPair(N first, Integer second) {
        return Pair.of(first, second);
    }
}
