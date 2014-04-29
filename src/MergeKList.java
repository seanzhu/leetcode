import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKList {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        int k = lists.size();
        if (k == 0)
            return null;

        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(k, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val > o2.val)
                    return 1;
                else if (o1.val == o2.val)
                    return 0;
                else
                    return -1;
            }
        });

        for (ListNode list : lists)
            if (list != null)
                heap.add(list);

        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;

        while (!heap.isEmpty()) {
            ListNode curr = heap.poll();
            prev.next = curr;

            if (curr.next != null)
                heap.add(curr.next);

            prev = prev.next;
        }

        return dummy.next;
    }
}
