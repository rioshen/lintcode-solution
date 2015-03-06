import java.util.*;

public class CloneGraph {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        return dfs(node, map);
    }

    private UndirectedGraphNode dfs(UndirectedGraphNode node,
        Map<UndirectedGraphNode, UndirectedGraphNode> map)
    {
        if (map.containsKey(node)) {
            return map.get(node);
        }

        UndirectedGraphNode graph = new UndirectedGraphNode(node.label);
        map.put(node, graph);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            graph.neighbors.add(dfs(neighbor, map));
        }

        return graph;
    }
}
