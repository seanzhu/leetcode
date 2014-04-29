public class SumRootLeafNums {
    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;

        return sumHelper(root, 0, 0);

    }

    public int sumHelper(TreeNode root, int path, int sum) {
        if (root == null)
            return sum;
        path = path * 10 + root.val;
        if (root.left == null && root.right == null)
            return sum + path;
        sum = sumHelper(root.left, path, sum);
        return sumHelper(root.right, path, sum);
    }


}
