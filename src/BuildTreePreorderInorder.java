public class BuildTreePreorderInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;
        if (preorder.length == 1)
            return new TreeNode(preorder[0]);

        int headVal = preorder[0];

        int[] preLeft, preRight, inLeft, inRight;
        int headInInord = 0;
        for (; headInInord < inorder.length && inorder[headInInord] != headVal; headInInord++);

        inLeft = new int[headInInord];
        System.arraycopy(inorder, 0, inLeft, 0, headInInord);

        inRight = new int[inorder.length - 1 - headInInord];
        System.arraycopy(inorder, headInInord + 1, inRight,0, inorder.length - 1 - headInInord);

        preLeft = new int[headInInord];
        System.arraycopy(preorder, 1, preLeft, 0, headInInord);

        preRight = new int[inorder.length - 1 - headInInord];
        System.arraycopy(preorder, headInInord + 1, preRight, 0, inorder.length - 1 - headInInord);

        TreeNode head = new TreeNode(headVal);
        head.left = buildTree(preLeft, inLeft);
        head.right = buildTree(preRight, inRight);

        return head;

    }
    public static void main(String[] args) {

    }
}
