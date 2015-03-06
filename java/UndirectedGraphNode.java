import java.util.ArrayList;

public class UndirectedGraphNode {
    int label;
    ArrayList<UndirectedGraphNode> neighbors;
    public UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<>();
    }
}
