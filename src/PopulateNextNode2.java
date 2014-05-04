public class PopulateNextNode2 {
    public void connect(TreeLinkNode root) {
        TreeLinkNode curr = root;

        while (curr != null) {
            TreeLinkNode next = null;
            TreeLinkNode prev = null;
            for (; curr != null; curr = curr.next) {

                if (curr.left != null) {
                    if (prev == null)
                        next = curr.left;
                    if (prev != null)
                        prev.next = curr.left;
                    prev = curr.left;
                }
                if (curr.right != null) {
                    if (prev == null)
                        next = curr.right;
                    if (prev != null)
                        prev.next = curr.right;
                    prev = curr.right;
                }
            }
            curr = next;
        }
    }
}
