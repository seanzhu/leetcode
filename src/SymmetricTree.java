public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null)
            return right == null;
        if (right == null)
            return false;

        if (left.val != right.val)
            return false;

        if (!helper(left.left, right.right))
            return false;
        if (!helper(left.right, right.left))
            return false;

        return true;
    }
}
