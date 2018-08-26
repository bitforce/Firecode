package source.temp.node;
import java.util.LinkedList;
import java.util.List;
public class GraphNode {
     public String data;
     public boolean visited=false;
     public List<GraphNode> adjacentNodes = new LinkedList<>();
     public GraphNode(String data){
         this.data = data;
     }
     public void addAdjacentNode(final GraphNode node){
         adjacentNodes.add(node);
         node.adjacentNodes.add(this);
     }
}
