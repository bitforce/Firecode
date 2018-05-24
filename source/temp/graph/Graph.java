package source.temp.graph;
import java.util.*;
/**
 * This is a simple graph which utilizes a adjacency map (as opposed to list or matrix) structure.
 */
public class Graph<T> implements Iterable<T> {
    private Map<T, Set<T>> map;
    private int edges;
    public Graph() {map = new HashMap<>();}
    public void add(T v) {if(!map.containsKey(v)) map.put(v, new HashSet<>());}
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
        if(!map.containsKey(v)) throw new IllegalArgumentException("Invalid vertex: " + v.toString());
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
    public void print() {System.out.println(toString());} // UPDATE THIS TO PRINT OUT ACTUAL GRAPH FROM GRAPHPRINTER.JAVA
}
