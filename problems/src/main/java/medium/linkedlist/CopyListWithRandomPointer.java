package medium.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

    public static void main(String[] args) {
        Node node0 = new Node(7);
        Node node1 = new Node(13);
        Node node2 = new Node(11);
        Node node3 = new Node(10);
        Node node4 = new Node(1);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        node1.random = node0;
        node2.random = node4;
        node3.random = node2;
        node4.random = node0;

        Node res = new CopyListWithRandomPointer().copyRandomList(node0);
        System.out.println(res);
    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> oldToCopy =  new HashMap<>();

        Node cur = head;
        while (cur != null) {
            Node node = new Node(cur.val);
            oldToCopy.put(cur, node);
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            Node copy = oldToCopy.get(cur);
            if (cur.next != null) {
                copy.next = oldToCopy.get(cur.next);
            }

            if (cur.random != null) {
                copy.random = oldToCopy.get(cur.random);
            }

            cur = cur.next;

        }

        return oldToCopy.get(head);
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
