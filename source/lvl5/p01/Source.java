package source.lvl5.p01;
import source.temp.graph.Graph;
import source.temp.node.GraphNode;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private boolean depthFirstSearch(GraphNode rootNode, String data) {
        Stack<GraphNode> stack = new Stack<>();
        stack.push(rootNode);
        return false;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        Graph<String> graph = new Graph<>();
        for(int i = 0; i < args.length; i++) { // subtract by the amount 
            // vim command; assign ctrl-J/K for going down list of available method suggestions
            int n = Integer.parseInt(args[i]); 
            if(n == 1) {
                graph.add(args[i+1]);
                i++;
            } else if(n == 2) {
                graph.add(args[i+1], args[i+2]);
                i += 2;
            } else throw new Error("\n\nInvalid integer argument, must be 1 or 2.\n");
        }
        System.out.println();
        graph.print();
    }
}
