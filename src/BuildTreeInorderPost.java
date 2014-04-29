public class BuildTreeInorderPost {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildHelper(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    private TreeNode buildHelper(int[] inOrder, int inLeft, int inRight,
                                 int[] postOrder, int postLeft, int postRight) {
        if (inLeft > inRight)
            return null;
        if (inLeft == inRight)
            return new TreeNode(inOrder[inLeft]);

        int rootVal = postOrder[postRight];
        int leftNum = 0;
        int p = inLeft;
        while (p < inRight && inOrder[p] != rootVal) {
            ++p;
            leftNum++;
        }

        TreeNode ret = new TreeNode(rootVal);
        ret.left = buildHelper(inOrder, inLeft, inLeft + leftNum - 1,
                postOrder, postLeft, postLeft + leftNum - 1);
        ret.right = buildHelper(inOrder, inLeft + leftNum + 1, inRight,
                postOrder, postLeft + leftNum, postRight - 1);

        return ret;
    }
}
