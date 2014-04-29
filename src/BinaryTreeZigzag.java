import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeZigzag {
    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();

        if (root == null)
            return ret;

        boolean fromRight = true;
        ArrayList<TreeNode> toVisit = new ArrayList<TreeNode>();
        toVisit.add(root);
        while (!toVisit.isEmpty()) {
            ArrayList<TreeNode> next = new ArrayList<TreeNode>();
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for (TreeNode node : toVisit)
                temp.add(node.val);
            ret.add(temp);
            for (int i = toVisit.size() - 1; i >= 0; i--) {
                TreeNode node = toVisit.get(i);
                if (fromRight) {
                    if (node.right != null)
                        next.add(node.right);
                    if (node.left != null)
                        next.add(node.left);
                } else {
                    if (node.left != null)
                        next.add(node.left);
                    if (node.right != null) {
                        next.add(node.right);
                    }
                }
            }
            fromRight = fromRight ? false : true;
            toVisit = next;
        }
        return ret;
    }

}
