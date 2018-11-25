package source.lvl5.p10;

import source.support.datastructure.graph.Graph;
import source.support.datastructure.node.GraphNode;

import java.util.LinkedList;

public class SourceMain {
    public static void main(String[] args) {
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

    private static void print(final GraphNode node) {
        final LinkedList<GraphNode> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()) {
            GraphNode n = q.remove();
            System.out.println(n.data);
            System.out.println(n.adjacentNodes);
            q.addAll(n.adjacentNodes);
        }
    }
}
