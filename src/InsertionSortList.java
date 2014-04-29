public class InsertionSortList {

    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode newHead = new ListNode(head.val);
        ListNode curr = head.next;
        newHead.next = null;

        while (curr != null) {
            ListNode currNext = curr.next;
            if (curr.val <= newHead.val) {
                curr.next = newHead;
                newHead = curr;
            } else {
                ListNode insertNode = newHead;
                while (insertNode != null && insertNode.next != null && insertNode.next.val < curr.val) {
                    insertNode = insertNode.next;
                }

                if (insertNode.next == null) {
                    insertNode.next = curr;
                    curr.next = null;
                } else {
                    curr.next = insertNode.next;
                    insertNode.next = curr;
                }

            }
            curr = currNext;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(6);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(1);
        ListNode n6 = new ListNode(9);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        n1 = insertionSortList(n1);

        printList(n1);
    }

    public static void printList(ListNode x) {
        if(x != null){
            System.out.print(x.val + " ");
            while (x.next != null) {
                System.out.print(x.next.val + " ");
                x = x.next;
            }
            System.out.println();
        }

    }
}
