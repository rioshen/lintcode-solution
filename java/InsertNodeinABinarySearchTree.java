public class InsertNodeinABinarySearchTree {
    /**
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNodeRecursion(TreeNode root, TreeNode node) {
        if (root == null) {
            return node;
        }
        if (node.val > root.val) {
            root.right = insertNode(root.right, node);
        } else {
            root.left = insertNode(root.left, node);
        }

        return root;
    }

     /**
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        if (root == null) {
            return node;
        }

        TreeNode temp = root, last = root;
        while (temp != null) {
            last = temp;
            if (temp.val > node.val) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        if (last != null) {
            if (last.val > node.val) {
                last.left = node;
            } else {
                last.right = node;
            }
        }

        return root;
    }
}
