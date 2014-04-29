public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null)
            return null;

        ListNode dummy01 = new ListNode(-1);
        ListNode dummy02 = new ListNode(-1);
        dummy01.next = head;

        ListNode p1 = head;
        ListNode prev = dummy01;
        ListNode p2 = dummy02;

        while (p1 != null) {
            if (p1.val < x) {
                p1 = p1.next;
                prev = prev.next;
            } else {
                p2.next = p1;
                prev.next = p1.next;
                p1 = p1.next;
                p2 = p2.next;
            }
        }

        p2.next = null;
        prev.next = dummy02.next;

        return dummy01.next;
    }
}
