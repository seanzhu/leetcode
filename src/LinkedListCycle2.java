public class LinkedListCycle2 {

    public static ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }

        if (fast == null || fast.next == null)
            return null;

        slow = head;
        while (true) {
            if (slow == fast)
                return slow;
            slow = slow.next;
            fast = fast.next;
        }
    }

    public static void main(String[] args) {

    }
}
