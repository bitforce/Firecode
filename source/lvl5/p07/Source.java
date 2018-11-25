package source.lvl5.p07;

import source.support.datastructure.node.GraphNode;

import java.util.Stack;

class Source {
    boolean depthFirstSearch(final GraphNode rootNode, final String data) {
        if(rootNode == null || data == null) return false;
        final Stack<GraphNode> stack = new Stack<>();
        stack.add(rootNode);
        rootNode.visited = true;
        while(!stack.isEmpty()) {
            final GraphNode node = stack.pop();
            if(node.data != null && node.data.equals(data)) return true;
            for(GraphNode n : node.adjacentNodes)
                if(!n.visited) {
                    n.visited = true;
                    stack.add(n);
                }
        }
        return false;
    }
    /* ********************************************************************* */
    boolean depthFirstSearch2(final GraphNode rootNode, final String data){
        if (rootNode == null || rootNode.visited) return false;
        if (rootNode.data.equals(data)) return true;
        rootNode.visited = true;
        for (GraphNode n : rootNode.adjacentNodes)
            if (depthFirstSearch2(n, data)) return true;
        return false;
    }
}
