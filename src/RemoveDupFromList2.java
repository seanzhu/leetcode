public class RemoveDupFromList2 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy, curr = head, next = null;
        while (curr != null) {
            next = curr.next;
            while (next != null && curr.val == next.val)
                next = next.next;

            // not duplicate
            if (curr.next == next) {
                prev = curr;
                curr =curr.next;
            } else {
                prev.next = next;
                curr = next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        RemoveDupFromList2 test = new RemoveDupFromList2();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;n2.next = n3;
        test.deleteDuplicates(n1);
    }
}
