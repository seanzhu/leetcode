public class ReverseList2 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy, curr = null, next = null;

        for (int i = 0; i < m - 1; i++, prev = prev.next) ;
        ListNode start = prev;

        int step = n - m;
        if (step == 0)
            return head;

        curr = prev.next;
        next = curr.next;

        for (int i = 0; i < step; i++) {
            ListNode temp = next.next;
            next.next = curr;
            curr = next;
            next = temp;
        }

        start.next.next = next;
        start.next = curr;

        return dummy.next;
    }
}
