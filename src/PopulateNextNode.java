public class PopulateNextNode {
    public void connect(TreeLinkNode root) {
        TreeLinkNode mostLeft = root;
        while (mostLeft != null) {
            TreeLinkNode across = mostLeft;
            while (across != null) {
                if (across.left != null)
                    across.left.next = across.right;
                if (across.right != null && across.next != null)
                    across.right.next = across.next.left;
                across = across.next;
            }
            mostLeft = mostLeft.left;
        }
    }
}
