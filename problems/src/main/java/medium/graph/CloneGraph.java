package medium.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors = List.of(node2, node4);
        node2.neighbors = List.of(node1, node3);
        node3.neighbors = List.of(node2, node4);
        node4.neighbors = List.of(node1, node3);

        Node res = new CloneGraph().cloneGraph(node1);
        System.out.println(res.val);
        res.neighbors.forEach(nd -> System.out.println(nd.val));
    }

    public Node cloneGraph(Node node) {
        Map<Node, Node> oldToCopy = new HashMap<>();
        Map<Integer, Node> valToCopyNode = new HashMap<>();

        dfs(node, oldToCopy, valToCopyNode);

        oldToCopy.keySet().forEach(oldNode -> {
            Node copy = oldToCopy.get(oldNode);
            oldNode.neighbors.forEach(neighbor -> {
                int val = neighbor.val;
                copy.neighbors.add(valToCopyNode.get(val));
            });
        });

        return oldToCopy.get(node);
    }

    private void dfs(Node node, Map<Node, Node> oldToCopy, Map<Integer, Node> valToCopyNode) {
        if (oldToCopy.containsKey(node)) return;


        Node copy = new Node(node.val);
        copy.neighbors = new ArrayList<>();
        oldToCopy.put(node, copy);
        valToCopyNode.put(node.val, copy);

        node.neighbors.forEach(neighbor -> dfs(neighbor, oldToCopy, valToCopyNode));

    }
}

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}