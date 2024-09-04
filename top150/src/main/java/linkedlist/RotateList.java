package linkedlist;

public class RotateList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;
        ListNode node6 = new ListNode(6);
        node5.next = node6;
        ListNode node7 = new ListNode(7);
        node6.next = node7;

        ListNode rotated = new RotateList().rotateRight(node1, 8);

        while (rotated != null) {
            System.out.println(rotated.val);
            rotated = rotated.next;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null) return head;

        ListNode tmp = head;
        ListNode beforeKth = null;
        ListNode kth = head;

        int len = 0;

        while (tmp != null) {
            len++;
            tmp = tmp.next;
        }

        tmp = head;

        if (k%len == 0) return head;

        for (int i = 0; i < k%len; i++) {
            tmp = tmp.next;
        }

        while (tmp != null) {
            tmp = tmp.next;
            beforeKth = kth;
            kth = kth.next;
        }

        beforeKth.next = null;

        tmp = kth;

        while (tmp.next != null) {
            tmp = tmp.next;
        }

        tmp.next = head;

        return kth;

    }
}
