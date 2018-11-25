package source.lvl5.p07;

import source.support.datastructure.graph.Graph;
import source.support.datastructure.node.GraphNode;

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
        System.out.println(new Source().depthFirstSearch(node, args[0]));
        System.out.println(new Source().depthFirstSearch2(node, args[0]));
    }
} // you can find a way to deal with your dynamic input by looking @ Princeton edu Input classes
