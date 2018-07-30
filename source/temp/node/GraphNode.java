package source.temp.node;
import java.util.ArrayList;
public class GraphNode<T> {
    public ArrayList<GraphNode<T>> adjacentNodes;
    public boolean visited;
    public T data;
    public GraphNode(T data) {
        adjacentNodes = new ArrayList<>();
        visited = false;
        this.data = data;
    }
    public void connect(GraphNode<T> node) {adjacentNodes.add(node);}
}
