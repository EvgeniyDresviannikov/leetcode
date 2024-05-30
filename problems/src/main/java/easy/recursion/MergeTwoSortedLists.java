package easy.recursion;

public class MergeTwoSortedLists {

    public static void main(String[] args) {
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();

        ListNode node13 = new ListNode(4);
        ListNode node12 = new ListNode(2, node13);
        ListNode node11 = new ListNode(1, node12);


        ListNode node23 = new ListNode(4);
        ListNode node22 = new ListNode(3, node23);
        ListNode node21 = new ListNode(1, node22);

        ListNode result = mergeTwoSortedLists.mergeTwoLists(node11, node21);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return null;

        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode lst1 = list1;
        ListNode lst2 = list2;

        ListNode resultHead = new ListNode();
        ListNode result = resultHead;

        while (lst1 != null && lst2 != null) {
            if (lst1.val <= lst2.val) {
                result.next = new ListNode(lst1.val);
                lst1 = lst1.next;
            } else {
                result.next = new ListNode(lst2.val);
                lst2 = lst2.next;
            }
            result = result.next;
        }

        while (lst1 != null) {
            result.next = new ListNode(lst1.val);
            lst1 = lst1.next;
            result = result.next;
        }

        while (lst2 != null) {
            result.next = new ListNode(lst2.val);
            lst2 = lst2.next;
            result = result.next;
        }

        return resultHead.next;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
