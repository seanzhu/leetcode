public class MinDepthBT {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        int leftMin = minDepth(root.left);
        int rightMin = minDepth(root.right);
        if (leftMin == 0 && rightMin == 0)
            return 1;
        leftMin = (leftMin == 0) ? Integer.MAX_VALUE : leftMin;
        rightMin = (rightMin == 0) ? Integer.MAX_VALUE : rightMin;
        return Math.min(leftMin, rightMin) + 1;
    }
}
