package source.lvl5.p08;
import source.temp.help.FileReader;
import source.temp.help.GraphPrinter;
import java.util.*;
import javafx.util.Pair;
/**
 * Dikjstra's Graph.
 */
class Source {
    /* ********************************************************************* */
    private class Vertex implements Comparable<Vertex> {
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

    private class Edge {
        final Vertex target;
        final double weight;
        Edge(final Vertex argTarget, final double argWeight) { 
            target = argTarget; 
            weight = argWeight; 
        }
    }
    /* ********************************************************************* */
    private static List<Vertex> getShortestPath(final Vertex source, final Vertex target) {
        source.minDistance = 0.0;
        final PriorityQueue<Vertex> vertexQueue = new PriorityQueue<>();
        vertexQueue.add(source);
        while (!vertexQueue.isEmpty()) {
            final Vertex polledVertex = vertexQueue.poll();
            System.out.println(polledVertex);
            for (Edge e : polledVertex.adjacencies) {
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
    /* ********************************************************************* */
    public static void main(String[] args) { 
        try {
            Double.parseDouble(args[2]);
            System.out.println("illegal input: vertex should be first argument");
            System.exit(1);
        } catch(NumberFormatException e) {/*silent*/}
        final HashMap<String, Integer> vertexAdjacencyIndices = new HashMap<>();
        final HashSet<Vertex> graph = new HashSet<>();
        Vertex previousVertex = null;
        int vertexArgumentLimit = 0;
        for(int i = 2; i < args.length; i++) {
            try {
                final double WEIGHT = Double.parseDouble(args[i]);
                i++;

                // integer @ i was assigned, i++ is now presumed to be next vertex

                try {
                    Double.parseDouble(args[i]);
                    System.out.println("illegal input: continous weights " + WEIGHT  + " " + args[i]);
                    System.exit(1);
                } catch(NumberFormatException e) {/*silent*/}

                // we have validated that they are not continuous integers

                if(args[i].equals(previousVertex.name)) {
                    System.out.println("illegal input: vertex [" + args[i] + "] re-referenced");
                    System.exit(1);
                }

                // we have validated that 'A 1 A' is not a thing 

                final Vertex tempVertex = findVertex(graph, args[i]);
                final int PREV_VERT_INDEX = vertexAdjacencyIndices.get(previousVertex.name);
                if(tempVertex == null) {
                    final Vertex currentVertex = new Source().new Vertex(args[i]);
                    currentVertex.adjacencies = new Source.Edge[100];
                    currentVertex.adjacencies[0] = new Source().new Edge(previousVertex, WEIGHT);
                    vertexAdjacencyIndices.put(currentVertex.name, 1);
                    previousVertex.adjacencies[PREV_VERT_INDEX] = new Source().new Edge(currentVertex, WEIGHT);
                    previousVertex = currentVertex;
                    graph.add(previousVertex); // when are you supposed to add it
                } else {
                    final int TEMP_VERT_INDEX = vertexAdjacencyIndices.get(tempVertex.name);
                    tempVertex.adjacencies[TEMP_VERT_INDEX] = new Source().new Edge(previousVertex, WEIGHT);
                    vertexAdjacencyIndices.put(tempVertex.name, TEMP_VERT_INDEX+1);
                    previousVertex.adjacencies[PREV_VERT_INDEX] = new Source().new Edge(tempVertex, WEIGHT);
                }

                // IFF args[i] is not same as prev vertex, then create new one and assign it's back-edge

                vertexAdjacencyIndices.put(previousVertex.name, PREV_VERT_INDEX+1);

                // ensures that corresponding index of vertex is increased

                vertexArgumentLimit = 1;

                // reset argument limit
            } catch(NumberFormatException e) {
                if(args[i].equals(previousVertex.name)) {
                    vertexArgumentLimit++;
                    continue;
                }
                
                // keeps previous vertex the same if we find A 1 B B 2 C == A 1 B 2 C

                previousVertex = findVertex(graph, args[i]);
                if(previousVertex == null) {
                    final Vertex currentVertex = new Source().new Vertex(args[i]);
                    currentVertex.adjacencies = new Source.Edge[100];
                    vertexAdjacencyIndices.put(currentVertex.name, 0);
                    previousVertex = currentVertex;
                    graph.add(previousVertex);
                }
                vertexArgumentLimit++;

                // find existing vertex and use that as next prevVert; if not, create and use new one
            }
            // don't forget to check if disjoint values exist in graph
            if(vertexArgumentLimit > 2) {
                System.out.println("illegal input: too many continous vertices");
                System.exit(1);
            }

            // validates the A 1 B C D doesn't exist

            compactGraph(graph);

            // removes any set elements which already exist within a previous one's adjacencies
        }
        // ********************************************************************************

        // ********************************************************************************
        // VALIDATE SOURCE / TARGET VERTICES
        Vertex source = null;
        Vertex target = null;
        boolean sourceAssigned = false;
        boolean targetAssigned = false;
        for(Vertex v : graph) {
            if(sourceAssigned && targetAssigned) break;
            if(v.name.equals(args[0])) {
                source = v;
                sourceAssigned = true;
            }
            if(v.name.equals(args[1])) {
                target = v;
                targetAssigned = true;
            }
        }
        if(source == null || target == null) {
            System.out.println("source / target graph not assigned");
            System.exit(1);
        }
        System.out.println();
        // ********************************************************************************
        final List<Vertex> shortestPath = getShortestPath(source, target);
        final int SIZE_MIN_ONE = graph.size()-1;
        for(int i = 0; i < SIZE_MIN_ONE; i++)
            System.out.print(shortestPath.get(i) + " -> ");
        System.out.print(shortestPath.get(SIZE_MIN_ONE) + "\n");
    }

    // ******************************************************************************** //
    // HELPER METHODS
    // ******************************************************************************** //

    private static Vertex findVertex(final HashSet<Vertex> graph, final String name) {
        Vertex vertex = null;
        for(Vertex v : graph) {
            vertex = findVertex(v, name, new HashSet<Vertex>());
            if(vertex != null)
                break;
        }
        return vertex;
    }
    private static Vertex findVertex(final Vertex vertex, final String name, final HashSet<Vertex> visitedVertices) {
        if(vertex == null)
            return null;
        if(vertex.name.equals(name))
            return vertex;
        if(visitedVertices.contains(vertex))
            return null;
        visitedVertices.add(vertex);
        for(Edge edge : vertex.adjacencies)
            findVertex(edge.target, name, visitedVertices);
        return null;
    }

    /**
     * Loops through set values and then attempts to find them within 
     * the graph's vertex-adjacencies.
     */
    private static void compactGraph(final HashSet<Vertex> graph) {
        //
    }
}
