
package graphe.algos;


import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import graphe.core.IGrapheConst;


public class Dijkstra {

    public static void dijkstra(IGrapheConst graphe, String source, Map<String, Integer> dist, Map<String, String> pred) {
        PriorityQueue<String> nearest_sommets_sorted = new PriorityQueue<>(Comparator.comparingInt(dist::get));
        Set<String> sommet_visite = new HashSet<>();
        dist.put(source, 0);
        nearest_sommets_sorted.offer(source);
    
        while (!nearest_sommets_sorted.isEmpty()) {
            String current_sommet = nearest_sommets_sorted.poll();
    
            if (sommet_visite.contains(current_sommet)) {
                continue;
            }
            sommet_visite.add(current_sommet);
    
            for (String succ : graphe.getSucc(current_sommet)) {
                int current_distance = dist.get(current_sommet) + graphe.getValuation(current_sommet, succ);
                if (current_distance < dist.getOrDefault(succ, Integer.MAX_VALUE)) {
                    dist.put(succ, current_distance);
                    pred.put(succ, current_sommet);
                    nearest_sommets_sorted.offer(succ);
                }
            }
        }
    }

}
