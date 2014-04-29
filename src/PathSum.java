public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {

        return dfs(root, 0, sum);
    }

    private boolean dfs(TreeNode root, int prev, int sum) {
        if (root == null) return false;

        if (root.left ==null & root.right == null)
            return prev + root.val == sum;

        boolean leftRet = false;
        if (root.left != null)
            leftRet = dfs(root.left, prev + root.val, sum);

        boolean rightRet = false;
        if (root.right != null)
            rightRet = dfs(root.right, prev + root.val, sum);

        return leftRet || rightRet;
    }
}
