import com.sun.org.apache.bcel.internal.generic.LNEG;

public class ReverseNodesKGroup {


    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1)
            return head;

        ListNode helper = new ListNode(-1);
        helper.next = head;
        ListNode pre = helper;

        int i = 0;
        while (head != null) {
            ++i;
            if (i % k == 0) {

            } else {
                head = head.next;
            }
        }
        return helper.next;
    }

    public static void reverse(ListNode start, ListNode end) {
        ListNode prev = start.next;
        ListNode cur = prev.next;
        while (cur != end) {
            ListNode next = cur.next;
            next.next = cur;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
    }

    public static void printList(ListNode head) {
        while (head !=null) {
            System.out.print(head.val + ", ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode n0 = new ListNode(-1);
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        reverse(n0, n3);

        System.out.println();
    }

}
