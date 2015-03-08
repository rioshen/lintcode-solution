import java.util.*;

public class ImplementBinarySearchTreeIterator {
    private Stack<TreeNode> stack = new Stack<TreeNode>();
    private TreeNode curr = null;

    //@param root: The root of binary tree.
    public ImplementBinarySearchTreeIterator(TreeNode root) {
        curr = root;
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        return curr != null || !stack.isEmpty();
    }

    //@return: return next node
    public TreeNode next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        } else {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode node = stack.pop();
            curr = node.right;
            return node;
        }
    }
}
