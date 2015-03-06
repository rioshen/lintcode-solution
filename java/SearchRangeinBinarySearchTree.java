import java.util.*;

public class SearchRangeinBinarySearchTree {
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        } else {
            search(root, k1, k2, res);
            return res;
        }
    }

    public void search(TreeNode root, int k1, int k2, ArrayList<Integer> res) {
        if (root == null) return;
        if (root.val > k1) search(root.left, k1, k2, res);
        if (root.val >= k1 && root.val <= k2) search(root.right, k1, k2, res);
        if (root.val < k2) search(root.right, k1, k2, res);
    }
}
