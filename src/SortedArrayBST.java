public class SortedArrayBST {
    public TreeNode sortedArrayToBST(int[] num) {
        return convertHelper(num, 0, num.length - 1);
    }

    private TreeNode convertHelper(int[] num, int start, int end) {
        if (start > end)
            return null;
        if (start == end)
            return new TreeNode(num[start]);

        int mid = start + (end - start) / 2;
        TreeNode ret = new TreeNode(num[mid]);
        ret.left = convertHelper(num, start, mid - 1);
        ret.right = convertHelper(num, mid + 1, end);

        return ret;
    }
}
