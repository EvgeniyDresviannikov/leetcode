package medium.linkedlist;

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

        System.out.println(new RotateList().rotateRight(node1, 9).val);
    }

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null) return head;

        ListNode tmp = head;
        int len = 0;
        while (tmp!= null) {
            len++;
            tmp = tmp.next;
        }
        k = k % len;

        if (k == 0) return head;

        ListNode beforeKth = head;

        for (int i = 0; i < len - k - 1; i++) {
            beforeKth = beforeKth.next;
        }

        ListNode newHead = beforeKth.next;
        beforeKth.next = null;

        tmp = newHead;
        while (tmp.next != null) {
            tmp = tmp.next;
        }

        tmp.next = head;

        return newHead;

    }
}


class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
