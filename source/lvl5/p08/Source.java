package source.lvl5.p08;
import java.util.*;

/**
 * Dikjstra's Graph.
 */
class Source { // UNFINISHED
    /* %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% */
    class Vertex implements Comparable<Vertex> {
        Vertex previous;
        Edge[] adjacencies;
        double minDistance = Double.POSITIVE_INFINITY;
        final String name;
        Vertex(final String argName) {name = argName;}
        @Override
        public String toString() {return name;}
        @Override
        public int compareTo(final Vertex other) {
            return Double.compare(minDistance, other.minDistance);
        }
    }

    class Edge {
        final Vertex target;
        final double weight;
        Edge(final Vertex argTarget, final double argWeight) { 
            target = argTarget; 
            weight = argWeight; 
        }
    }
    /* ********************************************************************* */
    static List<Vertex> getShortestPath(final Vertex source, final Vertex target) {
        source.minDistance = 0.0;
        final PriorityQueue<Vertex> vertexQueue = new PriorityQueue<>();
        vertexQueue.add(source);
        while (!vertexQueue.isEmpty()) {
            final Vertex polledVertex = vertexQueue.poll();
            for (Edge e : polledVertex.adjacencies) {
                if(e == null) break; // DELETE ME AFTER TRUNCATION TEST
                final Vertex targetVertex = e.target;
                final double distance = polledVertex.minDistance + e.weight;
                if (distance < targetVertex.minDistance) {
                    vertexQueue.remove(targetVertex);
                    targetVertex.minDistance = distance;
                    targetVertex.previous = polledVertex;
                    vertexQueue.add(targetVertex);
                }
            }
        }
        final ArrayList<Vertex> shortestPath = new ArrayList<>();
        for(Vertex vertex = target; vertex != null; vertex = vertex.previous)
            shortestPath.add(vertex);
        Collections.reverse(shortestPath);
        return shortestPath;
    }
}
