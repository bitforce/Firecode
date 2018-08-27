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
            Integer.parseInt(args[2]);
            System.out.println("illegal input: vertex should be first argument");
            System.exit(1);
        } catch(NumberFormatException e) {/*silent*/}
        final HashMap<Vertex, HashSet<Pair<Vertex, Integer>>> graph = new HashMap<>();
        final ArrayList<Vertex> vertices = new ArrayList<>();
        Vertex previousVertex = null;
        int vertexArgumentLimit = 0;
        for(int i = 2; i < args.length; i++) {
            try {
                final int WEIGHT = Integer.parseInt(args[i]);
                i++;
                try {
                    Integer.parseInt(args[i]);
                    System.out.println("illegal input: continous weights " + WEIGHT  + " " + args[i]);
                    System.exit(1);
                } catch(NumberFormatException e) {/*silent*/}
                final Vertex targetVertex = new Source().new Vertex(args[i]);
                if(targetVertex.equals(previousVertex)) {
                    System.out.println("illegal input: vertex [" + targetVertex + "] re-referenced");
                    System.exit(1);
                }
                final Pair<Vertex, Integer> vertexWeightPair = new Pair<>(targetVertex, WEIGHT);
                if(graph.keySet().contains(previousVertex)) 
                    graph.get(previousVertex).add(vertexWeightPair);
                else {
                    final HashSet<Pair<Vertex, Integer>> vertexWeightPairSet = new HashSet<>();
                    vertexWeightPairSet.add(vertexWeightPair);
                    graph.put(previousVertex, vertexWeightPairSet);
                }
                previousVertex = targetVertex;
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
                    final Vertex targetVertex = new Source().new Vertex(args[i]);
                    previousVertex = targetVertex;
                    vertices.add(targetVertex);
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
        for(Vertex key : graph.keySet())
            for(int i = 0; i < vertices.size(); i++) {
                if(!key.equals(vertices.get(i))) continue;
                final Vertex targetVertex = vertices.get(i);
                final Set<Pair<Vertex, Integer>> vertexWeightPairSet = graph.get(targetVertex);
                targetVertex.adjacencies = new Source.Edge[vertexWeightPairSet.size()];
                final Iterator<Pair<Vertex, Integer>> iterator = vertexWeightPairSet.iterator();
                for(int j = 0; iterator.hasNext(); j++) {
                    final Pair<Vertex, Integer> vertexWeightPair = iterator.next();
                    targetVertex.adjacencies[j] = 
                        new Source().new Edge(vertexWeightPair.getKey(), vertexWeightPair.getValue());
                }
                vertices.set(i, targetVertex);
            }
        // ********************************************************************************
        // INVERTS PREVIOUS GRAPH
        final HashMap<Vertex, HashSet<Pair<Vertex, Integer>>> invertedGraph = new HashMap<>();
        for(Map.Entry<Vertex, HashSet<Pair<Vertex, Integer>>> entry : graph.entrySet())
            for(Pair<Vertex, Integer> vertexWeightPair : entry.getValue()) {
                final Vertex sourceKey = vertexWeightPair.getKey();
                final Pair<Vertex, Integer> newPair = 
                    new Pair<>(entry.getKey(), vertexWeightPair.getValue());
                if(invertedGraph.keySet().contains(sourceKey))
                    invertedGraph.get(sourceKey).add(newPair);
                else {
                    final HashSet<Pair<Vertex, Integer>> newSet = new HashSet<>();
                    newSet.add(newPair);
                    invertedGraph.put(sourceKey, newSet);
                }
            }
        // ********************************************************************************
        // CREATE EDGES BACK TO EACH EACH KEY VERTEX TO VALUE SET OF VERTICES OF ORIGINAL GRAPH
        for(Vertex key : invertedGraph.keySet())
            for(int i = 0; i < vertices.size(); i++) { // CAUTIOUS : vertices may no longer be relevant
                if(!key.equals(vertices.get(i))) continue;
                final Vertex targetVertex = vertices.get(i);
                final Set<Pair<Vertex, Integer>> vertexWeightPairSet = invertedGraph.get(targetVertex);
                targetVertex.adjacencies = new Source.Edge[vertexWeightPairSet.size()];
                final Iterator<Pair<Vertex, Integer>> iterator = vertexWeightPairSet.iterator();
                for(int j = 0; iterator.hasNext(); j++) {
                    final Pair<Vertex, Integer> vertexWeightPair = iterator.next();
                    targetVertex.adjacencies[j] = 
                        new Source().new Edge(vertexWeightPair.getKey(), vertexWeightPair.getValue());
                }
                vertices.set(i, targetVertex);
            }
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
        for(Map.Entry<Vertex, HashSet<Pair<Vertex, Integer>>> entry : graph.entrySet()) {
            System.out.print(entry.getKey() + " | ");
            for(Pair<Vertex, Integer> pair : entry.getValue()) {
                System.out.print("(" + pair.getKey() + ", " + pair.getValue() +") ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("INVERTED GRAPH");
        for(Map.Entry<Vertex, HashSet<Pair<Vertex, Integer>>> entry : invertedGraph.entrySet()) {
            System.out.print(entry.getKey() + " | ");
            for(Pair<Vertex, Integer> pair : entry.getValue()) {
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
