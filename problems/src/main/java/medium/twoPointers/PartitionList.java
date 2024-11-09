package medium.twoPointers;

public class PartitionList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node2_2 = new ListNode(2);

        node1.next = node4;
        node4.next = node3;
        node3.next = node2;
        node2.next = node5;
        node5.next = node2_2;

        ListNode res = new PartitionList().partition(node1, 3);

        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }

    }

    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode();
        ListNode right = new ListNode();

        ListNode lTail = left;
        ListNode rTail = right;

        while (head != null) {
            if (head.val < x) {
                lTail.next = head;
                lTail = lTail.next;
            } else {
                rTail.next = head;
                rTail = rTail.next;
            }
            head = head.next;
        }

        lTail.next = right.next;
        rTail.next = null;

        return left.next;

    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
