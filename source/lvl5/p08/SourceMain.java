package source.lvl5.p08;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static source.lvl5.p08.Source.getShortestPath;

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
/* ********************************************************************* */
public class SourceMain {
    private static class Graph {
         final LinkedList<Source.Vertex> graph = new LinkedList<>();

        /**
         * Prints all details relating to the graph, including the graph connections itself.
         */
        private void print() {
            if(graph.size() == 1) {
                System.out.println("GRAPH\n-----\n");
                print(graph.iterator().next(), new LinkedList<Source.Vertex>());
            } else {
                System.out.println("DISJOINT GRAPHS : " + graph.size() + "\n-----------------");
                int i = 1;
                for(Source.Vertex v : graph) {
                    System.out.println("\ngraph : " + i + "\n-------");
                    print(v, new LinkedList<Source.Vertex>());
                    i++;
                }
            }
            System.out.println();
        }
        private void print(final Source.Vertex vertex) { // used for testing
            if(vertex != null) print(vertex, new LinkedList<Source.Vertex>());
        }
        private void print(final Source.Vertex vertex, final LinkedList<Source.Vertex> visited) {
            if(visited.contains(vertex)) return;
            visited.add(vertex);
            for(Source.Edge edge : vertex.adjacencies)
                if(edge != null) { // DELETE AFTER TRUNCATION WORKS
                    System.out.println(vertex + " --> " + edge.target + " | " + edge.weight);
                    print(edge.target, visited);
                } else break;
        }
        /**
         * If new vertex contains vertices that are within the set, the set is reassigned to
         * contain only the new vertex; the only time the set contains other elements, is
         * when the graph is disjoint.
         */
        private void add(final Source.Vertex vertex) {
            if(graph.isEmpty()) graph.add(vertex);
            else {
                for(Source.Vertex v : graph)
                    if(connectionExists(v, vertex))
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
         *
         *  NOTE : returning versus simply calling the recursive method changed the output a bit
         */
        private boolean connectionExists(final Source.Vertex source, final Source.Vertex target) {
            return connectionExists(source, target, new LinkedList<>(), new LinkedList<>());
        }
        private boolean connectionExists(
                final Source.Vertex source,
                final Source.Vertex target,
                final LinkedList<Source.Vertex> visitedSource,
                final LinkedList<Source.Vertex> visitedTarget) {
            if(source == null || target == null) return false;
            /*
             * Check first vertex to see if it is within source[adjacencies] and if that don't work,
             * check target's adjacencies one by one to see if they match. You should actually
             * check looking through target's adjacencies first to see if they match with
             * source's, since there exists a higher likelihood of success--especially if
             * the target vertex is a new one (as opposed to a previous one in the case
             * of C).
             */
            if(source == target) return true;
            visitedSource.add(source);
            visitedTarget.add(target);
            for(Source.Edge edge : source.adjacencies) {
                for(Source.Edge e : target.adjacencies)
                    if(e == null) break;
                    else if(visitedTarget.contains(e.target)) continue;
                    else if(source == e.target) return true;
                    else {
                        visitedTarget.add(e.target);
                        return connectionExists(source, e.target, visitedSource, visitedTarget);
                    }
                if(edge == null) break;
                if(visitedSource.contains(edge.target)) continue;
                if(edge.target == target) return true;
                visitedSource.add(edge.target);
                return connectionExists(edge.target, target, visitedSource, new LinkedList<>());
            }
            return false;
        }

        /**
         * Finds vertex based on name.
         */
        private Source.Vertex findVertex(final String name) {
            for(Source.Vertex v : graph) {
                final Source.Vertex vertex = findVertex(v, name, new LinkedList<>());
                if(vertex != null) return vertex;
            }
            return null;
        }
        private Source.Vertex findVertex(
                final Source.Vertex vertex,
                final String name,
                final LinkedList<Source.Vertex> visitedVertices) {
            if(visitedVertices.contains(vertex)) return null;
            System.out.println(vertex + " HERE");
            if(vertex.name.equals(name)) return vertex;
            visitedVertices.add(vertex);
            for(Source.Edge edge : vertex.adjacencies)
                if(edge == null) break;
                else return findVertex(edge.target, name, visitedVertices);
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

     public static void main(String[] args) {
        validateArgs(args);
        final Graph graph = new Graph();
        readInput(graph, args);
        graph.truncateAdjacencies();
        graph.print();
        // ********************************************************************************

        // ********************************************************************************
        // VALIDATE SOURCE / TARGET VERTICES
        final Source.Vertex source = graph.findVertex(args[0]);
        final Source.Vertex target = graph.findVertex(args[1]);
        if(source == null || target == null) {
            System.out.println(source + " -|- " + target);
            System.out.println("source / target graph not assigned");
            System.exit(1);
        }
        // ********************************************************************************
        final List<Source.Vertex> shortestPath = getShortestPath(source, target);
        final int SIZE_MIN_ONE = graph.size()-1;
        for(int i = 0; i < SIZE_MIN_ONE; i++)
            System.out.print(shortestPath.get(i) + " -> ");
        System.out.print(shortestPath.get(SIZE_MIN_ONE) + "\n");
    }

    // ******************************************************************************** //
    // HELPER METHODS
    // ******************************************************************************** //
    private static void readInput(final Graph graph, final String[] args) {
        final HashMap<String, Integer> vertexIndexMap = new HashMap<>();
        Source.Vertex previousVertex = null;
        boolean foundPrevious = false;
        int vertexArgumentLimit = 0;
        for(int i = 2; i < args.length; i++) {
            try {
                final double WEIGHT = Double.parseDouble(args[i]);
                i++;
                try {
                    Double.parseDouble(args[i]);
                    System.out.println("illegal input: continous weights " + WEIGHT  + " " + args[i]);
                    System.exit(1);
                } catch(NumberFormatException e) {/*silent*/}
                if(args[i].equals(previousVertex.name)) {
                    System.out.println("illegal input: vertex [" + args[i] + "] sequentially re-referenced");
                    System.exit(1);
                }

                // ===================================================================================

                /*
                 * A ->
                 * 1
                 * B -> [0] 1--> A | <B, 1>
                 *                -> [
                 * 2
                 * C
                 */
                final int PREV_VERT_INDEX = vertexIndexMap.get(previousVertex.name);
                Source.Vertex currentVertex = graph.findVertex(args[i]);
                if(currentVertex == null) {
                    currentVertex = new Source().new Vertex(args[i]);
                    currentVertex.adjacencies = new Source.Edge[10];
                    currentVertex.adjacencies[0] = new Source().new Edge(previousVertex, WEIGHT);
                    vertexIndexMap.put(currentVertex.name, 1);
                    previousVertex.adjacencies[PREV_VERT_INDEX] = new Source().new Edge(currentVertex, WEIGHT);
                } else {
                    final int CURR_VERT_INDEX = vertexIndexMap.get(currentVertex.name);
                    currentVertex.adjacencies[CURR_VERT_INDEX] = new Source().new Edge(previousVertex, WEIGHT);
                    vertexIndexMap.put(currentVertex.name, CURR_VERT_INDEX+1);
                    previousVertex.adjacencies[PREV_VERT_INDEX] = new Source().new Edge(currentVertex, WEIGHT);
                }
                final String prev = previousVertex.name;
                vertexIndexMap.put(previousVertex.name, PREV_VERT_INDEX+1);
                previousVertex = currentVertex;
                System.out.println(previousVertex + " attached to " + prev);
                graph.add(previousVertex); // C added?
                graph.print(previousVertex);
                System.out.println();
                // ===================================================================================

                vertexArgumentLimit = 1;
            } catch(NumberFormatException e) {
                if(previousVertex != null && args[i].equals(previousVertex.name)) {
                    vertexArgumentLimit++;
                    continue;
                }
                System.out.println("CATCH = " + previousVertex);
                // problem starts when we can't find C; however, it should've been added up there ^
                // let's say this is true--in the case of C, well, what to we do with this info
                previousVertex = graph.findVertex(args[i]);
                System.out.println(args[i] + " | " + previousVertex); // DEL
                if(previousVertex == null) {
                    final Source.Vertex currentVertex = new Source().new Vertex(args[i]);
                    currentVertex.adjacencies = new Source.Edge[10];
                    vertexIndexMap.put(currentVertex.name, 0);
                    previousVertex = currentVertex;
                    graph.add(previousVertex);
                } else System.out.println("FOUUUUUUUNNNNND " + previousVertex);
                vertexArgumentLimit++;
            }
            if(vertexArgumentLimit > 2) {
                System.out.println("illegal input: too many continous vertices");
                System.exit(1);
            }
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
}
