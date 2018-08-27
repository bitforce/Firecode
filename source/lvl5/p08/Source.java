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
        final HashMap<Vertex, HashSet<Pair<Vertex, Integer>>> graph = new HashMap<>();
        final ArrayList<Vertex> vertices = new ArrayList<>();
        Vertex previousVertex = null;
        int vertexArgumentLimit = 0;
        for(int i = 2; i < args.length; i++) {
            if(vertexArgumentLimit > 2) {
                System.out.println("illegal input: too many continous vertices");
                System.exit(1);
            }
            String arg = args[i];
            try {
                final int WEIGHT = Integer.parseInt(arg);
                // check to see prevVert is not null (A 1 B 2 C), then use that to insert it into 
                // hashmap and make next vertex be the edge. If prevVert is null (A 1 B C 3 D) 
                // || (A 1 B A 2 C), just insert new node into hashmap with following node
                vertexArgumentLimit = 0;
                i++;
                arg = args[i];
                try {
                    Integer.parseInt(arg);
                    System.out.println("illegal input: continous integers " + WEIGHT  + " " + arg);
                    System.exit(1);
                } catch(NumberFormatException e) {
                    final Vertex targetVertex = new Source().new Vertex(arg);
                    if(targetVertex.equals(previousVertex)) {
                        System.out.println("illegal input: vertex [" + targetVertex + "] re-referenced");
                        System.exit(1);
                    }
                    final Pair<Vertex, Integer> vertexWeightPair = new Pair<>(targetVertex, WEIGHT);
                    if(graph.keySet().contains(targetVertex)) graph.get(targetVertex).add(vertexWeightPair);
                    else {
                        final HashSet<Pair<Vertex, Integer>> vertexWeightPairSet = new HashSet<>();
                        vertexWeightPairSet.add(vertexWeightPair);
                        graph.put(targetVertex, vertexWeightPairSet);
                    }
                    previousVertex = targetVertex;
                   vertexArgumentLimit++;
                }
            } catch(NumberFormatException e) {
                boolean vertexListed = false;
                Vertex currentVertex = null;
                for(Vertex v : vertices)
                    if(v.equals(arg)) {
                        currentVertex = v;
                        vertexListed = true;
                        break;
                    }
                if(!vertexListed) {
                    currentVertex = new Source().new Vertex(arg);
                    vertices.add(currentVertex);
                }
                previousVertex = currentVertex;
                vertexArgumentLimit++;
            }
        }

        for(Vertex key : graph.keySet())
            for(int i = 0; i < vertices.size(); i++) {
                if(!key.equals(vertices.get(i))) continue;
                final Vertex currentVertex = vertices.get(i);
                final Set<Pair<Vertex, Integer>> vertexWeightPairSet = graph.get(currentVertex);
                currentVertex.adjacencies = new Source.Edge[vertexWeightPairSet.size()];
                final Iterator<Pair<Vertex, Integer>> iterator = vertexWeightPairSet.iterator();
                for(int j = 0; iterator.hasNext(); j++) {
                    final Pair<Vertex, Integer> vertexWeightPair = iterator.next();
                    currentVertex.adjacencies[j] = new Source().new Edge(vertexWeightPair.getKey(), vertexWeightPair.getValue());
                }
                vertices.set(i, currentVertex);
            }

        Vertex source = null;
        Vertex target = null;
        boolean sourceAssigned = false;
        boolean targetAssigned = false;
        for(Vertex v : vertices) {
            if(sourceAssigned && targetAssigned) break;
            if(v.equals(args[0])) {
                source = v;
                sourceAssigned = true;
            }
            if(v.equals(args[1])) {
                target = v;
                targetAssigned = true;
            }
        }
        if(source == null || target == null) {
            System.out.println("source / target vertices not assigned");
            System.exit(1);
        }
        for(Map.Entry<Vertex, HashSet<Pair<Vertex, Integer>>> entry : graph.entrySet()) {
            System.out.print(entry.getKey() + " | ");
            for(Pair<Vertex, Integer> pair : entry.getValue()) {
                System.out.print("(" + pair.getKey() + ", " + pair.getValue() +") ");
            }
            System.out.println();
        }
        System.out.println();
        final List<Vertex> shortestPath = getShortestPath(source, target);
        final int SIZE_MIN_ONE = vertices.size()-1;
        for(int i = 0; i < SIZE_MIN_ONE; i++)
            System.out.print(vertices.get(i) + " -> ");
        System.out.print(vertices.get(SIZE_MIN_ONE) + "\n");
    }
}
