public class ConstructBinaryTreefromPreorderandInorderTraversal {
    /**
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // write your code here
        if (preorder == null || inorder == null
            || preorder.length != inorder.length)
        {
            return null;
        } else {
            return build(preorder, 0, preorder.length - 1,
                         inorder, 0, inorder.length - 1);
        }
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd,
                           int[] inorder, int inStart, int inEnd)
    {
        if (preStart > preEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int current = find(preorder[preStart], inorder, inStart, inEnd);
        int left = current - inStart;

        root.left = build(preorder, preStart + 1, preStart + left,
                          inorder, inStart, current - 1);
        root.right = build(preorder, preStart + left + 1, preEnd,
                           inorder, current + 1, inEnd);

        return root;
    }

    private int find(int value, int[] nums, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (nums[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
