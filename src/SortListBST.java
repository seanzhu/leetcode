public class SortListBST {
    private ListNode curr;

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        int length = getLength(head);
        curr = head;
        return generateTree(0, length - 1);
    }

    private int getLength(ListNode head) {
        int ret = 0;
        ListNode temp = head;
        while (temp != null) {
            ++ret;
            temp = temp.next;
        }
        return ret;
    }

    private TreeNode generateTree(int start, int end) {
        if (start > end)
            return null;

        int mid = start + (end - start) / 2;
        TreeNode left = generateTree(start, mid - 1);
        TreeNode root = new TreeNode(curr.val);
        curr = curr.next;
        TreeNode right = generateTree(mid + 1, end);
        root.left = left;
        root.right = right;

        return root;
    }
}
