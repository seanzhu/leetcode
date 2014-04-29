import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class BinaryTreeLevelOrderTraversal {

    public static ArrayList<ArrayList<Integer>> levelOrder01(TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if (root == null)
            return ret;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int leftNum = queue.size();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            temp.add(cur.val);
            --leftNum;
            if (cur.left != null)
                queue.offer(cur.left);
            if (cur.right != null)
                queue.offer(cur.right);
            if (leftNum ==0) {
                ret.add(temp);
                temp = new ArrayList<Integer>();
                leftNum = queue.size();
            }
        }
        return ret;
    }

    public static ArrayList<ArrayList<Integer>> levelOrder02(TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        levelOrderHelper(root, ret, 0);
        return ret;
    }

    public static void levelOrderHelper(TreeNode root, ArrayList<ArrayList<Integer>> ret, int depth) {
        if (root == null)
            return;

        ArrayList<Integer> temp = null;
        if (depth< ret.size()) {
            temp = ret.get(depth);
        } else {
            temp = new ArrayList<Integer>();
            ret.add(temp);
        }
        temp.add(root.val);
        levelOrderHelper(root.left, ret, depth + 1);
        levelOrderHelper(root.right, ret, depth + 1);
    }


    public static void main(String[] args) {

    }
}
