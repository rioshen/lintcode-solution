public class ConstructBinaryTreefromInorderandPostorderTraversal {
    /**
     *@param inorder : A list of integers that inorder traversal of a tree
     *@param postorder : A list of integers that postorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // write your code here
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        } else {
            return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
        }
    }

    private TreeNode build(int[] inorder, int inStart, int inEnd,
                           int[] postorder, int postStart, int postEnd)
    {
        if (postStart > postEnd) {
            return null;
        }

        int value = postorder[postEnd];
        TreeNode root = new TreeNode(value);
        int current = find(value, inorder, inStart, inEnd);
        int left = current - inStart;

        root.left = build(inorder, inStart, current - 1,
                          postorder, postStart, postStart + left - 1);
        root.right = build(inorder, current + 1, inEnd,
                           postorder, postStart + left, postEnd - 1);
        return root;
    }

    private int find(int value, int[] nums, int start, int end) {
        for (int i = start; i <= end; i++) if (nums[i] == value) return i;
        return -1;
    }

}
