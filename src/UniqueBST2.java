import java.util.ArrayList;

public class UniqueBST2 {
    public ArrayList<TreeNode> generateTrees(int n) {
        return dfs(1, n);
    }

    ArrayList<TreeNode> dfs(int start, int end) {
        ArrayList<TreeNode> ret = new ArrayList<TreeNode>();
        if (start > end)
            ret.add(null);
        for (int i = start; i <= end; i++) {
            ArrayList<TreeNode> leftRet = dfs(start, i - 1);
            ArrayList<TreeNode> rightRet = dfs(i + 1, end);
            for (int left = 0; left < leftRet.size(); left++) {
                for (int right = 0; right < rightRet.size(); right++) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftRet.get(left);
                    root.right = rightRet.get(right);
                    ret.add(root);
                }
            }
        }
        return ret;
    }
}
