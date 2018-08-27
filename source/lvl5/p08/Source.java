package source.lvl5.p08;
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
        return null;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        try {
            Double.parseDouble(args[2]);
            System.out.println("illegal input: vertex should be first argument");
            System.exit(1);
        } catch(NumberFormatException e) {/*silent*/}
        final HashMap<Vertex, HashSet<Pair<Vertex, Double>>> graph = new HashMap<>();
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
                final Vertex keyVertex = new Source().new Vertex(args[i]);
                if(keyVertex.equals(previousVertex)) {
                    System.out.println("illegal input: vertex [" + keyVertex + "] re-referenced");
                    System.exit(1);
                }
                final Pair<Vertex, Double> vertexWeightPair = new Pair<>(keyVertex, WEIGHT);
                if(graph.keySet().contains(previousVertex)) 
                    graph.get(previousVertex).add(vertexWeightPair);
                else {
                    final HashSet<Pair<Vertex, Double>> vertexWeightPairSet = new HashSet<>();
                    vertexWeightPairSet.add(vertexWeightPair);
                    graph.put(previousVertex, vertexWeightPairSet);
                }
                previousVertex = keyVertex;
                if(!vertices.contains(previousVertex))
                    vertices.add(previousVertex);
                vertexArgumentLimit = 1;
            } catch(NumberFormatException e) {
                boolean vertexListed = false;
                for(Vertex v : vertices)
                    if(v.name.equals(args[i])) {
                        previousVertex = v;
                        vertexListed = true;
                        break;
                    }
                if(!vertexListed) {
                    final Vertex keyVertex = new Source().new Vertex(args[i]);
                    previousVertex = keyVertex;
                    vertices.add(keyVertex);
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
        for(Vertex keyVertex : graph.keySet())
            for(int i = 0; i < vertices.size(); i++) {
                if(!keyVertex.equals(vertices.get(i))) continue;
                final Set<Pair<Vertex, Double>> vertexWeightPairSet = graph.get(keyVertex);
                keyVertex.adjacencies = new Source.Edge[vertexWeightPairSet.size()];
                final Iterator<Pair<Vertex, Double>> iterator = vertexWeightPairSet.iterator();
                for(int j = 0; iterator.hasNext(); j++) {
                    final Pair<Vertex, Double> vertexWeightPair = iterator.next();
                    keyVertex.adjacencies[j] = 
                        new Source().new Edge(vertexWeightPair.getKey(), vertexWeightPair.getValue());
                }
                vertices.set(i, keyVertex);
            }
        
        // object introspection: somehow you are changing references and the the vertices follow the map
        // you need to look at how you are initializing an re-initializing vertices

        // ********************************************************************************
        // INVERTS PREVIOUS GRAPH
        final HashMap<Vertex, HashSet<Pair<Vertex, Double>>> invertedGraph = new HashMap<>();
        for(Map.Entry<Vertex, HashSet<Pair<Vertex, Double>>> entry : graph.entrySet())
            for(Pair<Vertex, Double> vertexWeightPair : entry.getValue()) {
                final Vertex sourceKey = vertexWeightPair.getKey();
                final Pair<Vertex, Double> newPair = 
                    new Pair<>(entry.getKey(), vertexWeightPair.getValue());
                if(invertedGraph.keySet().contains(sourceKey))
                    invertedGraph.get(sourceKey).add(newPair);
                else {
                    final HashSet<Pair<Vertex, Double>> newSet = new HashSet<>();
                    newSet.add(newPair);
                    invertedGraph.put(sourceKey, newSet);
                }
            }
        // ********************************************************************************
        // CREATE EDGES BACK TO EACH EACH KEY VERTEX TO VALUE SET OF VERTICES OF ORIGINAL GRAPH
        for(Vertex keyVertex : invertedGraph.keySet())
            for(int i = 0; i < vertices.size(); i++) { // CAUTIOUS : vertices may no longer be relevant
                if(!keyVertex.equals(vertices.get(i))) continue;
                final HashSet<Pair<Vertex, Double>> vertexWeightPairSet = invertedGraph.get(keyVertex);
                // somewhere in here, you simply reassign edge references instead of add to them
                // copy over previous edges!
                if(keyVertex.adjacencies != null)
                    for(Edge e : keyVertex.adjacencies)// possible same vals?
                        vertexWeightPairSet.add(new Pair<Vertex, Double>(e.target, e.weight));
                keyVertex.adjacencies = new Source.Edge[vertexWeightPairSet.size()];
                final Iterator<Pair<Vertex, Double>> iterator = vertexWeightPairSet.iterator();
                for(int j = 0; iterator.hasNext(); j++) {
                    final Pair<Vertex, Double> vertexWeightPair = iterator.next();
                    keyVertex.adjacencies[j] = 
                        new Source().new Edge(vertexWeightPair.getKey(), vertexWeightPair.getValue());
                }
                vertices.set(i, keyVertex);
            }
        // graph check
        for(Vertex v : vertices)
            for(Edge e : v.adjacencies)
                System.out.println(v + " -> " + e.target);
        System.out.println();
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
        System.out.println("ORIGINAL GRAPH");
        for(Map.Entry<Vertex, HashSet<Pair<Vertex, Double>>> entry : graph.entrySet()) {
            System.out.print(entry.getKey() + " | ");
            for(Pair<Vertex, Double> pair : entry.getValue()) {
                System.out.print("(" + pair.getKey() + ", " + pair.getValue() +") ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("INVERTED GRAPH");
        for(Map.Entry<Vertex, HashSet<Pair<Vertex, Double>>> entry : invertedGraph.entrySet()) {
            System.out.print(entry.getKey() + " | ");
            for(Pair<Vertex, Double> pair : entry.getValue()) {
                System.out.print("(" + pair.getKey() + ", " + pair.getValue() +") ");
            }
            System.out.println();
        }
        System.out.println();
        // big problem: if source points to target, target should also be initialized 
        // to have edge back to source
        for(Edge e : source.adjacencies) System.out.println(source + "-" + e.target);
        for(Edge e : target.adjacencies) System.out.println(target + "-" + e.target);
        System.exit(0); // DELETE ME
        final List<Vertex> shortestPath = getShortestPath(source, target);
        final int SIZE_MIN_ONE = vertices.size()-1; // causing exception until I solve method
        for(int i = 0; i < SIZE_MIN_ONE; i++)
            System.out.print(shortestPath.get(i) + " -> ");
        System.out.print(shortestPath.get(SIZE_MIN_ONE) + "\n");
    }
}
