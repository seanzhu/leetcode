import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal2 {
    public static ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
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
        Collections.reverse(ret);
        return ret;
    }

}
