package source.lvl5.p10;

import source.support.datastructure.node.GraphNode;

import java.util.LinkedList;

class Source {
    boolean breadthFirstSearch(final GraphNode rootNode, final String data) {
        if(rootNode == null || data == null) return false;
        final LinkedList<GraphNode> queue = new LinkedList<>();
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
}
