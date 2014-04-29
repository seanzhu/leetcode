import java.util.ArrayList;
import java.util.HashMap;

public class PathSum2 {
    private HashMap<TreeNode, TreeNode> nextNode = new HashMap<TreeNode, TreeNode>();

    private ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();

    private TreeNode start = null;

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null)
            return ret;
        this.start = root;
        dfs(root, 0, sum);
        return ret;
    }

    private void dfs(TreeNode root, int prev, int sum) {
        if (root == null)
            return;
        if (root.left == null&& root.right == null){
            if (root.val + prev == sum){
                ArrayList<Integer> temp = new ArrayList<Integer>();
                TreeNode p = start;
                while (p != null){
                    temp.add(p.val);
                    p = nextNode.get(p);
                }
                ret.add(temp);
            } else
                return;
        }

        if (root.left != null) {
            if (nextNode.containsKey(root))
                nextNode.remove(root);
            nextNode.put(root, root.left);
            dfs(root.left, prev + root.val, sum);
        }

        if (root.right != null) {
            if (nextNode.containsKey(root))
                nextNode.remove(root);
            nextNode.put(root, root.right);
            dfs(root.right, prev + root.val, sum);
        }

    }
}
