import com.sun.org.apache.bcel.internal.generic.LNEG;

public class SwapNodesInPair {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode prev = head, curr = head.next;

        ListNode pprev = null;
        while (curr != null) {
            prev.next = curr.next;
            curr.next = prev;

            if (pprev != null) {
                pprev.next = curr;
            } else {
                head = curr;
            }
            pprev = prev;
            prev = prev.next;
            if (prev != null)
                curr = prev.next;
            else
                curr = null;
        }

        return head;
    }
}
