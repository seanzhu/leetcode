import java.util.HashMap;

public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;
        HashMap<Integer, UndirectedGraphNode> hashMap = new HashMap<Integer, UndirectedGraphNode>();
        return cloneHelper(node, hashMap);
    }

    public UndirectedGraphNode cloneHelper(UndirectedGraphNode node, HashMap<Integer, UndirectedGraphNode> hashMap) {
        UndirectedGraphNode ret = new UndirectedGraphNode(node.label);
        hashMap.put(node.label, ret);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            if (hashMap.containsKey(neighbor.label)) {
                ret.neighbors.add(hashMap.get(neighbor.label));
            } else {
                ret.neighbors.add(cloneHelper(neighbor, hashMap));
            }
        }
        return ret;
    }

}
