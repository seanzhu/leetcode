public class RotateList {
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null || n == 0)
            return head;

        ListNode curr = head;
        int length = 1;
        while (curr.next != null) {
            ++length;
            curr = curr.next;
        }

        curr.next = head;

        for (int i = 0; i < length - n % length; i++, curr = curr.next);
        ListNode ret = curr.next;
        curr.next = null;

        return ret;
    }
}
