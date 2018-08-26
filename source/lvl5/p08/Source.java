package source.lvl5.p08;
import java.util.*;
import javafx.util.Pair;
/**
 * BACKGROUND.
 * The <b>Vertex</b> and <b>Edge</b> classes were provided by Firecode; however, in order to interact 
 * with the problem method, a custom <b>Graph</b> had to be created in order to provide nodal 
 * structure for Dijkstra's traversal.
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
        return null;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        final HashMap<Vertex, Set<Pair<Vertex, Integer>>> graph = new HashMap<>();
        final ArrayList<Vertex> vertices = new ArrayList<>();
        final HashSet<Pair<Vertex, Integer>> pairSet = new HashSet<>();
        Vertex previousVertex = null;
        for(int i = 2; i < args.length; i++) {
            String arg = args[i];
            /*
             * keep track of number of edges each vertex has
             * keep track of re-references vertices
             * if current element is non-int and next element is also non-int, then we have a new vertex;
             * therefore, stop keeping track of 
             * If argument is non-integer, add it to vertex and 
             */
            try {
                final int WEIGHT = Integer.parseInt(arg);
                i++;
                arg = args[i];
                try {
                    Integer.parseInt(arg);
                    System.out.println("illegal input: continous integers " + WEIGHT  + " " + arg);
                    System.exit(1);
                } catch(NumberFormatException e) {
                    pairSet.add(new Pair<Vertex, Integer>(new Source().new Vertex(arg), WEIGHT));
                    graph.put(previousVertex, pairSet);
                }
            } catch(NumberFormatException e) {
                boolean vertexListed = false;
                Vertex currentVertex = null;
                for(Vertex v : vertices)
                    if(v.toString().equals(arg)) {
                        currentVertex = v;
                        vertexListed = true;
                        break;
                    }
                if(!vertexListed) {
                    currentVertex = new Source().new Vertex(arg);
                    vertices.add(currentVertex);
                }
                previousVertex = currentVertex;
            }
        }

        for(Vertex key : graph.keySet())
            for(int i = 0; i < vertices.size(); i++) {
                if(!key.name.equals(vertices.get(i).name)) continue;
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
            System.out.println("source / target vertices not vertexListed");
            System.exit(1);
        }

        // loop to print the graph starting with source

        final List<Vertex> shortestPath = getShortestPath(source, target);
        final int SIZE_MIN_ONE = vertices.size()-1;
        for(int i = 0; i < SIZE_MIN_ONE; i++)
            System.out.print(vertices.get(i) + " -> ");
        System.out.print(vertices.get(SIZE_MIN_ONE) + "\n");
    }
}
