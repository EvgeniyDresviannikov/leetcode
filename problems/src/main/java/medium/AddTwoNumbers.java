package medium;

// input:
// 2 -> 4 -> 3 -> 1
// 5 -> 6 -> 4
// output:
// 7 -> 0 -> 8

public class AddTwoNumbers {
    public static void main(String[] args) {


        ListNode l14 = new ListNode(1);
        ListNode l13 = new ListNode(3, l14);
        ListNode l12 = new ListNode(4, l13);
        ListNode l11 = new ListNode(2, l12);

        ListNode l23 = new ListNode(4);
        ListNode l22 = new ListNode(6, l23);
        ListNode l21 = new ListNode(5, l22);

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode res = addTwoNumbers.addTwoNumbers(l11, l21);

        ListNode res1 = res;
        System.out.println(res1.val);
        while (res1.next != null) {
            res1 = res1.next;
            System.out.println(res1.val);
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode result1 = result;
        int rest = 0;
        while (true) {
            int currSum = l1.val + l2.val + rest;
            rest = 0;
            if (currSum > 9) {
                currSum = currSum % 10;
                rest = 1;
            }
            result1.next = new ListNode(currSum);
            result1 = result1.next;

            if (l1.next == null || l2.next == null) {
                break;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1.next != null) {
            l1 = l1.next;
            int currSum = l1.val + rest;
            if (currSum == 10) {
                result1.next = new ListNode(0);
                rest = 1;
            } else {
                result1.next = new ListNode(currSum);
                rest = 0;
            }
            result1 = result1.next;
        }

        while (l2.next != null) {
            l2 = l2.next;
            int currSum = l2.val + rest;
            if (currSum == 10) {
                result1.next = new ListNode(0);
                rest = 1;
            } else {
                result1.next = new ListNode(currSum);
                rest = 0;
            }
            result1 = result1.next;
        }

        if (rest == 1) {
            result1.next = new ListNode(1);
            result1 = result1.next;
        }

        return result.next;

    }
}




class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}