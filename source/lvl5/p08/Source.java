package source.lvl5.p08;
import source.temp.help.FileReader;
import source.temp.help.GraphPrinter;
import java.util.*;
import javafx.util.Pair;
/**
 * BACKGROUND.
 * The <b>Vertex</b> and <b>Edge</b> classes were provided by Firecode; however, in order to interact 
 * with the problem method, a custom <b>Graph</b> had to be created in order to provide nodal 
 * structure for Dijkstra's traversal. In addition, since I follow given definitions, such as 
 * the beforementioned classes; strictyl, I did not alter <code>Edge[] adjacencies</code> to 
 * an <code>ArrayList</code>, which would have made life generally easier; however, 
 * especially designing the main logic input handler.
 *
 * Currently, I did update Vertex to have equals and hashCode overrides, but those will be taken out 
 * once I finish tuning things up.
 *
 * TODO
 * change ArrayList of Vertex to set (more aptly designed) and get rid of additional methods (equals 
 * and hashCode) and then correct code appropriately to ensure you have worked with the explicit 
 * given clasess. Use lambdas where possible.
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

        // PERSONAL ADDITION
        @Override
        public boolean equals(Object o) {
            if(o == this) return true;
            if(!(o instanceof Vertex)) return false;
            return ((Vertex) o).name.equals(name);
        }

        @Override
        public int hashCode() {return name.hashCode();} // gets ride of warning
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
    /*
     * YOU FORGOT TO USE THE PREVIOUS VERTEX ATTRIBUTE AND MIN DISTANCE
     */
    public static void main(String[] args) { 
        try {
            Double.parseDouble(args[2]);
            System.out.println("illegal input: vertex should be first argument");
            System.exit(1);
        } catch(NumberFormatException e) {/*silent*/}
        final HashMap<Vertex, HashSet<Pair<Vertex, Double>>> initialGraph = new HashMap<>();
        final ArrayList<Vertex> vertices = new ArrayList<>();
        Vertex previousVertex = null;
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
                final Vertex currentVertex = new Source().new Vertex(args[i]);
                if(currentVertex.equals(previousVertex)) {
                    System.out.println("illegal input: vertex [" + currentVertex + "] re-referenced");
                    System.exit(1);
                }
                final Pair<Vertex, Double> vertexWeightPair = new Pair<>(currentVertex, WEIGHT);
                if(initialGraph.keySet().contains(previousVertex)) 
                    initialGraph.get(previousVertex).add(vertexWeightPair);
                else {
                    final HashSet<Pair<Vertex, Double>> vertexWeightPairSet = new HashSet<>();
                    vertexWeightPairSet.add(vertexWeightPair);
                    initialGraph.put(previousVertex, vertexWeightPairSet);
                }
                previousVertex = currentVertex;
                if(!vertices.contains(previousVertex))
                    vertices.add(previousVertex);
                vertexArgumentLimit = 1;
            } catch(NumberFormatException e) {
                boolean vertexListed = false;
                
                // ATTENTION HERE

                // this should be checking the map rather to see if anything in keyset or values 
                // matches up with this and if so, reassign previous vertex to that object
                for(Vertex v : vertices)
                    if(v.name.equals(args[i])) {
                        previousVertex = v;
                        vertexListed = true;
                        break;
                    }
                // if not, then create a new vertex
                if(!vertexListed) {
                    final Vertex currentVertex = new Source().new Vertex(args[i]);
                    previousVertex = currentVertex;
                    vertices.add(currentVertex);
                }
                vertexArgumentLimit++;
            }
            if(vertexArgumentLimit > 2) {
                System.out.println("illegal input: too many continous vertices");
                System.exit(1);
            }
        }
        // ********************************************************************************
        // CREATE EDGES FROM EACH KEY VERTEX TO VALUE SET OF VERTICES 
        for(Vertex keyVertex : initialGraph.keySet())
            for(int i = 0; i < vertices.size(); i++) {
                if(!keyVertex.equals(vertices.get(i))) continue;
                final HashSet<Pair<Vertex, Double>> vertexWeightPairSet = initialGraph.get(keyVertex);
                keyVertex.adjacencies = new Source.Edge[vertexWeightPairSet.size()];
                final Iterator<Pair<Vertex, Double>> iterator = vertexWeightPairSet.iterator();
                for(int j = 0; iterator.hasNext(); j++) {
                    final Pair<Vertex, Double> vertexWeightPair = iterator.next();
                    keyVertex.adjacencies[j] = 
                        new Source().new Edge(vertexWeightPair.getKey(), vertexWeightPair.getValue());
                }
                vertices.set(i, keyVertex);
            }
        // ********************************************************************************
        // INVERTS PREVIOUS GRAPH
        final HashMap<Vertex, HashSet<Pair<Vertex, Double>>> completeGraph = new HashMap<>();
        for(Map.Entry<Vertex, HashSet<Pair<Vertex, Double>>> entry : initialGraph.entrySet())
            for(Pair<Vertex, Double> vertexWeightPair : entry.getValue()) {
                Vertex sourceKey = null;
                boolean assigned = false;
                for(Vertex v : initialGraph.keySet())
                    if(v.equals(vertexWeightPair.getKey())) {
                        sourceKey = v;
                        assigned = true;
                        break;
                    }
                if(!assigned) 
                    sourceKey = vertexWeightPair.getKey();
                final Pair<Vertex, Double> newPair = 
                    new Pair<>(entry.getKey(), vertexWeightPair.getValue());
                if(completeGraph.keySet().contains(sourceKey))
                    completeGraph.get(sourceKey).add(newPair);
                else {
                    final HashSet<Pair<Vertex, Double>> newSet = new HashSet<>();
                    newSet.add(newPair);
                    completeGraph.put(sourceKey, newSet);
                }
            }
        // ********************************************************************************
        // CREATE EDGES BACK TO EACH EACH KEY VERTEX TO VALUE SET OF VERTICES OF ORIGINAL GRAPH
        for(Vertex keyVertex : completeGraph.keySet())
            for(int i = 0; i < vertices.size(); i++) { // CAUTIOUS : vertices may no longer be relevant
                if(!keyVertex.equals(vertices.get(i))) continue;
                final HashSet<Pair<Vertex, Double>> vertexWeightPairSet = completeGraph.get(keyVertex);
                if(keyVertex.adjacencies != null)
                    for(Edge e : keyVertex.adjacencies)
                        vertexWeightPairSet.add(new Pair<Vertex, Double>(e.target, e.weight));
                keyVertex.adjacencies = new Source.Edge[vertexWeightPairSet.size()];
                final Iterator<Pair<Vertex, Double>> iterator = vertexWeightPairSet.iterator();
                for(int j = 0; iterator.hasNext(); j++) {
                    final Pair<Vertex, Double> vertexWeightPair = iterator.next();
                    // if vwp.getKey() name is in the map, assign it to be that reference
                    keyVertex.adjacencies[j] = 
                        new Source().new Edge(vertexWeightPair.getKey(), vertexWeightPair.getValue());
                }
                vertices.set(i, keyVertex);
            }
        // ********************************************************************************
        // REPLACE ALL MATCHING NODES WITH THOSE IN LIST USING ENTRY SET?

        // ********************************************************************************
        // VALIDATE SOURCE / TARGET VERTICES
        Vertex source = null;
        Vertex target = null;
        boolean sourceAssigned = false;
        boolean targetAssigned = false;
        for(Vertex v : vertices) {
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
            System.out.println("source / target vertices not assigned");
            System.exit(1);
        }
        System.out.println();
        // ********************************************************************************
        // PRINT GRAPH
        System.out.println("GRAPH");
        for(Map.Entry<Vertex, HashSet<Pair<Vertex, Double>>> entry : completeGraph.entrySet()) {
            System.out.print(entry.getKey() + " | ");
            for(Pair<Vertex, Double> pair : entry.getValue()) {
                System.out.print("(" + pair.getKey() + ", " + pair.getValue() +") ");
            }
            System.out.println();
        }
        System.out.println();
        // ********************************************************************************
        // PRINT OUT ALL VERTICES AND CORRESPONDING EDGES
        for(Vertex v : vertices) {
            for(Edge e : v.adjacencies)
                System.out.println(v + " -> " + e.target);
            System.out.println("----");
        }
        System.out.println();
        // ********************************************************************************
        // PRINT OUT SOURCE / TARGET WITH CORRESPONDING EDGES
        System.out.println("source" + "\n------");
        for(Edge e : source.adjacencies) 
            System.out.println(source + "-" + e.target);
        System.out.println();
        System.out.println("target" + "\n------");
        for(Edge e : target.adjacencies) 
            System.out.println(target + "-" + e.target);
        // ********************************************************************************
        // TRAVERSE ALL VERTICES FROM SOURCE TO SEE IF ALL EDGES ARE CONNECTED
        System.out.println();
        final HashSet<String> visitedVertices = new HashSet<>();
        final Stack<Vertex> vertexStack = new Stack<>();
        vertexStack.push(source);
        while(!vertexStack.isEmpty()) {
            final Vertex currentVertex = vertexStack.pop();
            System.out.print(currentVertex.name + " -> ");
            visitedVertices.add(currentVertex.name);
            for(Edge edge : currentVertex.adjacencies) {
                if(visitedVertices.contains(edge.target.name))
                    continue;
                vertexStack.push(edge.target);
            }

            // the vertices referenced in the adjacencies are not necessarily the 
            // same as the corresponding vertices found in the list
        }
        System.out.println("\n");
        // ********************************************************************************
        // MAIN RUN
        final List<Vertex> shortestPath = getShortestPath(source, target);
        final int SIZE_MIN_ONE = vertices.size()-1;
        for(int i = 0; i < SIZE_MIN_ONE; i++)
            System.out.print(shortestPath.get(i) + " -> ");
        System.out.print(shortestPath.get(SIZE_MIN_ONE) + "\n");
    }
}
