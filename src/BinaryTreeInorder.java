import java.util.ArrayList;
import java.util.Stack;



public class BinaryTreeInorder {

//    public static ArrayList<Integer> inorderTraversal(TreeNode root) {
//        ArrayList<Integer> result = new ArrayList<Integer>();
//        return inorderTraversalHelper(root, result);
//    }
//
//    public static ArrayList<Integer> inorderTraversalHelper(TreeNode root, ArrayList<Integer> res) {
//        if (root == null)
//            return res;
//        inorderTraversalHelper(root.left, res);
//        res.add(root.val);
//        inorderTraversalHelper(root.right, res);
//        return res;
//    }


    public static ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if (root == null)
            return ret;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                ret.add(cur.val);
                cur = cur.right;
            }
        }
        return ret;
    }

    public static void main(String[] args) {

    }
}
