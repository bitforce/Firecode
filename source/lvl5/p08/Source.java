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
            for (Edge e : polledVertex.adjacencies) {
                if(e == null) break; // based on current edge array creation | should delete
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
        validateArgs(args);
        final HashMap<String, Integer> vertexIndexMap = new HashMap<>();
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
                    System.out.println("illegal input: vertex [" + args[i] + "] sequentially re-referenced");
                    System.exit(1);
                }

                // ===================================================================================
                // ===================================================================================

                // we have validated that 'A 1 A' is not a thing 
                // System.out.println("TRYING " + args[i]);
                final int PREV_VERT_INDEX = vertexIndexMap.get(previousVertex.name);
                final Vertex tempVertex = findVertex(graph, args[i]);
                System.out.println(args[i]);
                if(tempVertex == null) {
                    final Vertex currentVertex = new Source().new Vertex(args[i]);
                    currentVertex.adjacencies = new Source.Edge[10];
                    currentVertex.adjacencies[0] = new Source().new Edge(previousVertex, WEIGHT);
                    vertexIndexMap.put(currentVertex.name, 1);
                    previousVertex.adjacencies[PREV_VERT_INDEX] = new Source().new Edge(currentVertex, WEIGHT);
                    previousVertex = currentVertex;
                    addVertex(graph, previousVertex);
                } else {
                    final int TEMP_VERT_INDEX = vertexIndexMap.get(tempVertex.name);
                    tempVertex.adjacencies[TEMP_VERT_INDEX] = new Source().new Edge(previousVertex, WEIGHT);
                    vertexIndexMap.put(tempVertex.name, TEMP_VERT_INDEX+1);
                    previousVertex.adjacencies[PREV_VERT_INDEX] = new Source().new Edge(tempVertex, WEIGHT);
                }

                // ===================================================================================
                // if pervious vertex is not contained within graph, then create new one and instantiate its
                // adjacencies, assign new vertex's first adjacency to previous vertex and then assign 
                // previous vertex's next available adjacency to new vertex 
                // increment new vertex's index to 1

                // otherwise, assign found vertex's next adjacency to previous and previous' next adjacency
                // to newfound one while incrementing newfound's index
                // ===================================================================================

                vertexIndexMap.put(previousVertex.name, PREV_VERT_INDEX+1);

                // ensures that corresponding index of vertex is increased regardless

                vertexArgumentLimit = 1;

                // reset argument limit
            } catch(NumberFormatException e) {
                //System.out.println("CATCHING " + args[i]);
                if(previousVertex != null && args[i].equals(previousVertex.name)) {
                    vertexArgumentLimit++;
                    continue;
                }
                
                // keeps previous vertex the same if we find A 1 B B 2 C == A 1 B 2 C

                previousVertex = findVertex(graph, args[i]);
                if(previousVertex == null) {
                    final Vertex currentVertex = new Source().new Vertex(args[i]);
                    currentVertex.adjacencies = new Source.Edge[100];
                    vertexIndexMap.put(currentVertex.name, 0);
                    previousVertex = currentVertex;
                    addVertex(graph, previousVertex);
                } else
                    vertexIndexMap.put(previousVertex.name, vertexIndexMap.get(previousVertex.name)+1);
                vertexArgumentLimit++;

                // find existing vertex and use that as next prevVert; if not, create and use new one
            }
            // don't forget to check if disjoint values exist in graph
            if(vertexArgumentLimit > 2) {
                System.out.println("illegal input: too many continous vertices");
                System.exit(1);
            }

            // validates the A 1 B C D doesn't exist
        }

        printGraphDetails(graph);
        // ********************************************************************************

        // ********************************************************************************
        // VALIDATE SOURCE / TARGET VERTICES
        final Vertex source = findVertex(graph, args[0]);
        final Vertex target = findVertex(graph, args[1]);
        if(source == null || target == null) {
            System.out.println("source / target graph not assigned");
            System.exit(1);
        }
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
    
    private static void addVertex(HashSet<Vertex> graph, final Vertex vertex) {
        graph.add(vertex);
    }

    private static void printGraphDetails(final HashSet<Vertex> graph) {
        if(graph.size() == 1) {
            System.out.println("Non-disjoint graph\n");
            printVertexGraph(graph.iterator().next());
        } else {
            System.out.println("Disjoint graphs contained : " + graph.size() + "\n");
            int i = 1;
            for(Vertex v : graph) {
                System.out.println("graph : " + i);
                printVertexGraph(v);
                System.out.println("----\n");
                i++;
            }
        }
    }
    private static void printVertexGraph(final Vertex graph) {
        printVertexGraph(graph, new HashSet<Vertex>());
    }
    private static void printVertexGraph(final Vertex vertex, final HashSet<Vertex> visited) {
        if(visited.contains(vertex))
            return;
        visited.add(vertex);
        for(Edge edge : vertex.adjacencies)
            if(edge != null && edge.target != null) {
                System.out.println(vertex.name + " --> " + edge.target.name);
                printVertexGraph(edge.target, visited);
            }
    }
    private static void validateArgs(String[] args) {
        if(!argIsVertex(args, 2)) {
            System.out.println("illegal input: vertex should be first argument");
            System.exit(1);
        }
        if(!argIsVertex(args, args.length-1)) {
            System.out.println("illegal input: last value cannot be integer");
            System.exit(1);
        }
        if(argIsVertex(args, args.length-1) && argIsVertex(args, args.length-2)) {
            System.out.println("illegal input: last two values cannot be vertices");
            System.exit(1);
        }
    }

    private static boolean argIsVertex(String[] args, final int INDEX) {
         try {
            Double.parseDouble(args[INDEX]);
            return false;
        } catch(NumberFormatException e) {
            return true;
        }
    }

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
        if(vertex == null || visitedVertices.contains(vertex))
            return null;
        if(vertex.name.equals(name))
            return vertex;
        visitedVertices.add(vertex);
        for(Edge edge : vertex.adjacencies)
            if(edge != null && edge.target != null)
                findVertex(edge.target, name, visitedVertices);
        return null;
    }

    /**
     * Custom graph class used to interact with Edge and Vertex classes using problem-tailored methods.
     */
    private static class Graph {
        final HashSet<Vertex> graph = new HashSet<>();
        private void printDetails(){}
        private void add(final Vertex vertex) {}
    }
}
