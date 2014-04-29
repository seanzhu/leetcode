public class SortList {

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // count the node number of this list
        int count = 0;
        ListNode p = head;
        while (p != null) {
            count++;
            p = p.next;
        }

        p = head;
        for (int i = 0; i < count / 2 - 1; i++) {
            p = p.next;
        }

        // p is the left sub-list and q is the right sub-list
        ListNode q = p.next;
        p.next = null;
        p = head;

        // sort the two sub-lists;

        ListNode left = sortList(p);
        ListNode right = sortList(q);
        
        // start to merge two sub-lists
        ListNode result = new ListNode(0);
        ListNode tail = result;
        while (left != null && right != null) {
            if (left.val < right.val) {
                tail.next = left;
                tail = left;
                left = left.next;
            } else {
                tail.next = right;
                tail = right;
                right = right.next;
            }
        }

        if (right != null)
            tail.next = right;
        else
            tail.next = left;

        return result.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(5);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(2);

        ListNode n4 = new ListNode(7);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(9);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        printList(sortList(n1));

    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
