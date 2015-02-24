public class MinimumDepthofBinaryTree {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return getDepth(root);
        }
    }

    public int getDepth(TreeNode node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        return Math.min(getDepth(root.left), getDepth(root.right)) + 1;
    }
}
