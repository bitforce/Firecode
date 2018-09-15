package source.temp.graph;
import source.temp.node.GraphNode;
import java.util.*;
/**
 * Unweighted, connected, directed, acyclic graph (connected UDAG).
 * This is a simple graph which utilizes a adjacency map (as opposed to list or matrix) structure.
 *
 * EXAMPLE
 * -------------
 * A | {J K X B}
 * B | {K Q A}
 * C | {Q}
 * Q | {B C}
 * K | {A B}
 * X | {A}
 * -------------
 *
 * While the printout will show that vertices share each other's nodes in their corresponding 
 * sets, said nodes are not actually connected via reference and thus are not undirected.
 * Think about that time when I had the graph and then attempted to re-traverse the map 
 * to create the back-map to reconnect all the nodes with each other--[L=5 | P=08]
 */
public class Graph<T> implements Iterable<T> {
    private final HashMap<T, HashSet<T>> map;
    private int edges;
    public Graph() {map = new HashMap<>();}
    public void add(T v) {
        if(!map.containsKey(v)) 
            map.put(v, new HashSet<>());
    }
    public void add(T v, T w) {
        if(!map.containsKey(v)) add(v);
        if(!map.containsKey(w)) add(w);
        if(!hasEdge(v, w)) edges++;
        map.get(v).add(w);
        map.get(w).add(v);
    }
    public int getVertices() {return map.size();}
    public int getEdges() {return edges;}
    public int getDegree(T v) {
        validate(v);
        return map.get(v).size();
    }
    private void validate(T v) {
        if(!map.containsKey(v)) 
            throw new IllegalArgumentException("Invalid vertex: " + v.toString());
    }
    private boolean hasEdge(T v, T w) {
        validate(v);
        validate(w);
        return map.get(v).contains(w);
    }
    @Override
    public Iterator<T> iterator() {return map.keySet().iterator();}
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(T v : map.keySet()) {
            builder.append(v.toString() + ": ");
            for(T w : map.get(v))
                builder.append(w.toString() + " ");
            builder.append("\n");
        }
        return builder.toString();
    }
    // UPDATE THIS TO PRINT OUT ACTUAL GRAPH FROM GRAPHPRINTER.JAVA
    public void print() {System.out.println(toString());}
}
