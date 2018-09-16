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
    /**
     * Custom graph class used to interact with Edge and Vertex.
     *
     *
     * The way this currently works is that as each vertex is added to the set; the other 
     * vertices in the set are updated along with matching adjacencies of the newest 
     * entries; thus the set essentially becomes different vertex starting points 
     * of the same graph. Therefore, at the end of the loop, you can choose any 
     * element and it will successfully represent a different starting point 
     * in the graph--pretty cool, but not what we want.
     *
     * We need to create a method that only adds a new element if is a disjoint path from 
     * the original graph; otherwise, why the hell do we need a set, we can just use a 
     * head vertex (like a linkedlist) and be done--except if a disjoint vertex came 
     * up, we would lose the previous graph.
     */
    private static class Graph {
         LinkedList<Vertex> graph = new LinkedList<>();

        /**
         * Prints all details relating to the graph, including the graph connections itself.
         */
        private void print(){
            if(graph.size() == 1) {
                System.out.println("GRAPH\n-----\n");
                print(graph.iterator().next(), new LinkedList<Vertex>());
            } else {
                System.out.println("DISJOINT GRAPHS : " + graph.size() + "\n-----------------\n");
                int i = 1;
                for(Vertex v : graph) {
                    System.out.println("graph : " + i);
                    print(v, new LinkedList<Vertex>());
                    System.out.println("----\n");
                    i++;
                }
            }
        }
        private void print(final Vertex vertex, final LinkedList<Vertex> visited) {
            if(visited.contains(vertex)) return;
            visited.add(vertex);
            for(Edge edge : vertex.adjacencies)
                if(edge != null && edge.target != null) { // DELETE AFTER TRUNCATION WORKS
                    System.out.println(vertex.name + " --> " + edge.target.name);
                    print(edge.target, visited);
                }
        }
        /**
         * If new vertex contains vertices that are within the set, the set is reassigned to 
         * contain only the new vertex; the only time the set contains other elements, is 
         * when the graph is disjoint.
         *
         * Remember that these elements are already being modified by that ain code in the main method.
         */
        // THE VERTEX I'M PROVIDING IS THE NEW VERTEX; THEREFORE IT WON'T BE IN THE ADJANCENCIES; 
        // WHAT I NEEED TO DO IS BACKTRACK TO ONE PREVIOUS VERTEX AND THEN CHECK
        private void add(final Vertex vertex) {
            if(graph.isEmpty()) graph.add(vertex);
            else {
                for(Vertex v : graph)
                    if(connectionExists(v, vertex.adjacencies))
                        return;
                graph.add(vertex);
            }
        }

        /**
         * Checks to see if new target adjacencies are connected to any of the source vertex's.
         * STEPS
         * -----
         *  1. recurse through all source vertices 
         *  2. recurse through all target vertices under source
         *  3. attempt to match any of the target's vertex's with one of the source's
         *  4. don't start next recursion of source until you have attempted to match all values 
         *     of target
         */
        private boolean connectionExists(final Vertex source, final Edge[] edges) {
            return connectionExists(source, edges, new LinkedList<Vertex>());
        }
        private boolean connectionExists(final Vertex source, final Edge[] edges, final LinkedList<Vertex> visited) {
            if(source == null || edges == null) return false;
            for(Edge edge : edges)
                if(edge == null || edge.target == null) break;
                else if(!visited.contains(edge.target) && source == edge.target) 
                    return true;
                else visited.add(edge.target);
            for(Edge edge : source.adjacencies) {
                for(Edge e : edges)
                    if(e != null && e.target != null && !visited.contains(e.target))
                        return connectionExists(edge.target, e.target.adjacencies, visited);
            }
            return false;
        }

        /**
         * Finds vertex based on name.
         */
        private Vertex find(final String name) {
            for(Vertex v : graph) {
                final Vertex vertex = find(v, name, new LinkedList<Vertex>());
                if(vertex != null) return vertex;
            }
            return null;
        }
        private Vertex find(final Vertex vertex, final String name, final LinkedList<Vertex> visitedVertices) {
            if(visitedVertices.contains(vertex)) return null;
            if(vertex.name.equals(name)) return vertex;
            visitedVertices.add(vertex);
            for(Edge edge : vertex.adjacencies)
                if(edge != null && edge.target != null)
                    find(edge.target, name, visitedVertices);
                else break;
            return null;
        }

        /**
         * For the array of edges from each vertex, reduce it's size to the length of the first 
         * index to the first null element.
         */
        private void truncateAdjacencies() {
            // don't finish until you have successfully been able to segregate the graph
        }

        private int size() {return graph.size();}
    }
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
    /* ********************************************************************* */
    public static void main(String[] args) { 
        validateArgs(args);
        final HashMap<String, Integer> vertexIndexMap = new HashMap<>();
        final Graph graph = new Graph();
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

                // we have validated that 'A 1 A' is not a thing 

                final int PREV_VERT_INDEX = vertexIndexMap.get(previousVertex.name);
                Vertex currentVertex = graph.find(args[i]);
                if(currentVertex == null) {
                    currentVertex = new Source().new Vertex(args[i]);
                    currentVertex.adjacencies = new Source.Edge[10];
                    currentVertex.adjacencies[0] = new Source().new Edge(previousVertex, WEIGHT);
                    vertexIndexMap.put(currentVertex.name, 1);
                    previousVertex.adjacencies[PREV_VERT_INDEX] = new Source().new Edge(currentVertex, WEIGHT);
                } else {
                    final int TEMP_VERT_INDEX = vertexIndexMap.get(currentVertex.name);
                    currentVertex.adjacencies[TEMP_VERT_INDEX] = new Source().new Edge(previousVertex, WEIGHT);
                    vertexIndexMap.put(currentVertex.name, TEMP_VERT_INDEX+1);
                    previousVertex.adjacencies[PREV_VERT_INDEX] = new Source().new Edge(currentVertex, WEIGHT);
                }
                previousVertex = currentVertex;
                graph.add(previousVertex);
                // ===================================================================================

                vertexIndexMap.put(previousVertex.name, PREV_VERT_INDEX+1);

                // ensures that corresponding index of vertex is increased regardless

                vertexArgumentLimit = 1;

                // reset argument limit
            } catch(NumberFormatException e) {
                if(previousVertex != null && args[i].equals(previousVertex.name)) {
                    vertexArgumentLimit++;
                    continue;
                }
                
                // keeps previous vertex the same if we find A 1 B B 2 C == A 1 B 2 C

                previousVertex = graph.find(args[i]);
                if(previousVertex == null) {
                    final Vertex currentVertex = new Source().new Vertex(args[i]);
                    currentVertex.adjacencies = new Source.Edge[10];
                    vertexIndexMap.put(currentVertex.name, 0);
                    previousVertex = currentVertex;
                    graph.add(previousVertex);
                } else
                    vertexIndexMap.put(previousVertex.name, vertexIndexMap.get(previousVertex.name)+1);
                vertexArgumentLimit++;

                // find existing vertex and use that as next prevVert; if not, create and use new one
            }
            if(vertexArgumentLimit > 2) {
                System.out.println("illegal input: too many continous vertices");
                System.exit(1);
            }

            // validates the A 1 B C D doesn't exist
        }
        graph.truncateAdjacencies();
        graph.print();
        // ********************************************************************************

        // ********************************************************************************
        // VALIDATE SOURCE / TARGET VERTICES
        final Vertex source = graph.find(args[0]);
        final Vertex target = graph.find(args[1]);
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
}
