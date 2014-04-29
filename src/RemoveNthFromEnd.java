public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n == 0)
            return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;


        ListNode curr = head;
        int length = 0;
        while (curr != null) {
            ++length;
            curr = curr.next;
        }

        curr = dummy;
        for (int i = 0; i < length - n; i++, curr = curr.next) ;
        curr.next = curr.next.next;

        return dummy.next;
    }
}
