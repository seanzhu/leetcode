public class CopyListRandomPointer {

    public static RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;

        // duplicate nodes
        RandomListNode curr = head;
        while (curr != null) {
            RandomListNode temp = new RandomListNode(curr.label);
            temp.next = curr.next;
            curr.next = temp;
            curr = temp.next;
        }

        // duplicate random pointers
        curr = head;
        while (curr != null) {
            if (curr.random != null)
                curr.next.random = curr.random.next;
            curr = curr.next.next;
        }

        // decouple two lists
        curr = head;
        RandomListNode dup = head.next;
        RandomListNode next;
        while (curr != null) {
            next = curr.next;
            curr.next = next.next;
            if (next.next != null)
                next.next = next.next.next;
            else
                next.next = null;
            curr = curr.next;
        }

        return dup;
    }

}
