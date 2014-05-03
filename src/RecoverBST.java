public class RecoverBST {


    public void recoverTree(TreeNode root) {
        TreeNode first = null;
        TreeNode second = null;

        TreeNode curr = null;
        TreeNode prev = null;
        TreeNode leftRight = null;

        if (root == null)
            return;
        curr = root;

        while (curr != null) {
            if (curr.left == null) {
                if (prev != null && prev.val > curr.val) {
                    if (first == null)
                        first = prev;
                    second = curr;
                }
                prev = curr;
                curr = curr.right;
            } else {
                leftRight = curr.left;
                while (leftRight.right != null && leftRight.right != curr)
                    leftRight = leftRight.right;
                if (leftRight.right == null) {
                    leftRight.right = curr;
                    curr = curr.left;
                } else {
                    leftRight.right = null;
                    if (prev.val > curr.val) {
                        if (first == null)
                            first = prev;
                        second = curr;
                    }
                    prev = curr;
                    curr = curr.right;
                }
            }
        }

        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }

    }

    public static void main(String[] args) {
        RecoverBST test = new RecoverBST();
        TreeNode n0 = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        n0.left = n1;

        test.recoverTree(n0);
    }
}
