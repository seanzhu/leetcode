public class ValidBST1 {
    public boolean isValidBST(TreeNode root) {
        return checkHelper(root, null, null);
    }

    private boolean checkHelper(TreeNode root, Integer min, Integer max) {
        if (root == null)
            return true;

        if (min != null && root.val <= min ||
                max != null && root.val >= max)
            return false;

        if (!checkHelper(root.left, min, root.val) ||
                !checkHelper(root.right, root.val, max))
            return false;

        return true;
    }
}
