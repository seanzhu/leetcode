import java.util.Stack;

public class FlattenBTtoList {
    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root == null)
            return;
        stack.push(root);
        TreeNode prev = null;
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (curr.right != null)
                stack.push(curr.right);
            if (curr.left != null)
                stack.push(curr.left);
            if (prev != null) {
                prev.left = null;
                prev.right = curr;
            }
            prev = curr;
        }
    }
}
