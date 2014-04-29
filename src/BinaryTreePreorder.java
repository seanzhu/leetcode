import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreePreorder {
    public static void main(String[] args) {

    }

    public static ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        if (root == null)
            return res;
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            res.add(top.val);
            if (top.right != null)
                stack.push(top.right);
            if (top.left != null)
                stack.push(top.left);
        }
        return res;
    }

}
