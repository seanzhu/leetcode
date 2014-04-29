import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreePostorder {

//    public static ArrayList<Integer> postorderTraversal(TreeNode root) {
//        ArrayList<Integer> ret = new ArrayList<Integer>();
//        return traversalHelper(root, ret);
//    }
//
//    public static ArrayList<Integer> traversalHelper(TreeNode root, ArrayList<Integer> ret) {
//        if (root == null)
//            return ret;
//        traversalHelper(root.left, ret);
//        traversalHelper(root.right, ret);
//        ret.add(root.val);
//        return ret;
//    }

    public static ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();

        if (root == null)
            return res;

        Stack<TreeNode> first = new Stack<TreeNode>();
        Stack<TreeNode> second = new Stack<TreeNode>();

        first.push(root);
        while (!first.isEmpty()) {
            TreeNode curr = first.pop();
            second.push(curr);
            if (curr.left != null)
                first.push(curr.left);
            if (curr.right != null)
                first.push(curr.right);
        }

        while (!second.isEmpty()) {
            res.add(second.pop().val);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
