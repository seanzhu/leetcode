public class BTMaxPathSum {
    int max;

    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;
        max = root.val;
        findFromRoot(root);
        return max;
    }

    public int findFromRoot(TreeNode root) {
        if (root == null)
            return 0;

        int leftMax = Math.max(findFromRoot(root.left), 0);
        int rightMax = Math.max(findFromRoot(root.right), 0);

        max = Math.max(max, root.val + leftMax + rightMax);

        return Math.max(leftMax, rightMax) + root.val;
    }

}
