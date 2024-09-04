package linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(3);
        node3.next = node4;
        ListNode node5 = new ListNode(4);
        node4.next = node5;
        ListNode node6 = new ListNode(4);
        node5.next = node6;
        ListNode node7 = new ListNode(5);
        node6.next = node7;

        node7.next = node3;

        System.out.println(new LinkedListCycle().hasCycle(node1));
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }

        return false;
    }
}
