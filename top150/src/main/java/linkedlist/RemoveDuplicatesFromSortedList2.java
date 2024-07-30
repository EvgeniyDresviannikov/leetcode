package linkedlist;

public class RemoveDuplicatesFromSortedList2 {

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList2 removeDuplicatesFromSortedList2 = new RemoveDuplicatesFromSortedList2();

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

        ListNode head = removeDuplicatesFromSortedList2.deleteDuplicates(node1);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }


    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode current = head;

        while (current != null) {
            if (current.next == null || (current.next != null && current.val != current.next.val)) {
                prev = current;
                current = current.next;
            } else  {
                int duplicate = current.val;
                while (current != null && current.val == duplicate) {
                    current = current.next;
                }
                prev.next = current;
            }
        }

        return dummy.next;
    }
}

 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
