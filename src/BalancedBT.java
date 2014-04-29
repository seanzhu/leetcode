public class BalancedBT {
    private class Result{
        int depth;
        boolean balanced;
        Result(int d, boolean b){
            depth = d;
            balanced = b;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return balancedHelper(root).balanced;
    }

    private Result balancedHelper(TreeNode root) {
        if (root == null)
            return new Result(0, true);
        Result leftRet = balancedHelper(root.left);
        Result rightRet = balancedHelper(root.right);

        if (!leftRet.balanced || !rightRet.balanced)
            return new Result(0, false);

        if (Math.abs(leftRet.depth - rightRet.depth) > 1)
            return new Result(0, false);

        return new Result(Math.max(leftRet.depth, rightRet.depth) + 1, true);
    }


}
