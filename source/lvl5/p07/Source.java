package source.lvl5.p07;
import source.temp.graph.Graph;
import source.temp.node.GraphNode;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private boolean depthFirstSearch(GraphNode rootNode, String data) {
        if(rootNode == null || data == null) return false;
        final Stack<GraphNode> stack = new Stack<>();
        stack.add(rootNode);
        rootNode.visited = true;
        while(!stack.isEmpty()) {
            GraphNode node = stack.pop();
            if(node.data != null && node.data.equals(data))
                return true;
            for(GraphNode n : node.adjacentNodes)
                if(!n.visited) {
                    n.visited = true;
                    stack.add(n);
                }
        }
        return false;
    }
    /* ********************************************************************* */
    private boolean depthFirstSearch2(final GraphNode rootNode, final String data){
        if (rootNode == null || rootNode.visited) return false;
        if (rootNode.data == data) return true;
        rootNode.visited = true;
        for (GraphNode n : rootNode.adjacentNodes)
            if (depthFirstSearch2(n, data)) return true;
        return false;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        Graph<String> graph = new Graph<>();
        for(int i = 1; i < args.length; i++) {
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
        final GraphNode node = new GraphNode(graph.iterator().next());
        System.out.println(new Source().depthFirstSearch(node, args[0]));
        System.out.println(new Source().depthFirstSearch2(node, args[0]));
    }
}
