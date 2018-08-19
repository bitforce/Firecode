package source.lvl5.p00;
import source.temp.graph.Graph;
import source.temp.node.GraphNode;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private boolean depthFirstSearch(GraphNode<Integer> rootNode, String data) {
        if(rootNode == null || data == null) return false;
        Stack<GraphNode<Integer>> stack = new Stack<>();
        stack.add(rootNode);
        rootNode.visited = true;
        while(!stack.isEmpty()) {
            GraphNode<Integer> node = stack.pop();
            if(node.data != null && node.data.equals(data))
                return true;
            for(GraphNode<Integer> n : node.adjacentNodes)
                if(!n.visited) {
                    n.visited = true;
                    stack.add(n);
                }
        }
        return false;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        Graph<String> graph = new Graph<>();
        if(args[0].equals("test")) {
            
        } else {
            for(int i = 0; i < args.length; i++) {
                final int N = Integer.parseInt(args[i]); 
                if(N == 1) {
                    graph.add(args[i+1]);
                    i++;
                } else if(N == 2) {
                    graph.add(args[i+1], args[i+2]);
                    i += 2;
                } else throw new Error("\n\nInvalid integer argument, must be 1 or 2.\n");
            }
            System.out.println();
            graph.print();
        }
    }
}
