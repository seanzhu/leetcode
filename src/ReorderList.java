public class ReorderList {

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return;

        // Find the length of this list
        // No need to use slow/fast runner way here
        int length = 0;
        ListNode p = head, q;
        while (p != null) {
            ++length;
            p = p.next;
        }


        // divide the list, p is the left part, q is the right part
        p = head;
        for (int i = 0; i < (length - 1) / 2; i++)
            p = p.next;
        q = p.next;
        p.next = null;
        p = head;

        // reverse the right part
        ListNode prev = null, curr = q, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        q = prev;

        // merge p and q;
        ListNode pNext, qNext;
        while (q != null) {
            pNext = p.next;
            qNext = q.next;
            p.next = q;
            q.next = pNext;
            p = pNext;
            q = qNext;
        }

    }


    public static void printList(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }


    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;

        reorderList(n1);
        printList(n1);
    }

}
