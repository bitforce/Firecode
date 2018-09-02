package source.lvl5.p10;
import source.temp.graph.Graph;
import source.temp.node.GraphNode;
import java.util.*;
/**
 * Implement the Breadth First Search Algorithm for a Graph.
 *
 * Turns out DFS is traditionally not a recusrive algorithm.
 */
class Source {
    /* ********************************************************************* */
    private boolean breadthFirstSearch(GraphNode rootNode, String data) {
        if(rootNode == null || data == null) return false;
        final Queue<GraphNode> queue = new LinkedList<>();
        queue.add(rootNode);
        rootNode.visited = true;
        while(!queue.isEmpty()) {
            final GraphNode node = queue.remove();
            if(node.data != null && node.data.equals(data)) return true;
            for(GraphNode n : node.adjacentNodes)
                if(!n.visited) {
                    n.visited = true;
                    queue.add(n);
                }
        }
        return false;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        // if args=test; run test input
        final Graph<String> graph = new Graph<>();
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
        print(node); // prove that graph is connected
        System.out.println(new Source().breadthFirstSearch(node, args[0]));
    }

    static void print(final GraphNode node) {
        Queue<GraphNode> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()) {
            GraphNode n = q.remove();
            System.out.println(n.data);
            System.out.println(n.adjacentNodes);
            q.addAll(n.adjacentNodes);
        }
    }
}
