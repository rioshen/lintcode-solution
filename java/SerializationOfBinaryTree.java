import java.util.*;

public class SerializationOfBinaryTree {
    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        StringBuilder data = new StringBuilder();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    queue.offer(node.left);
                    queue.offer(node.right);
                    data.append(node.val).append(",");
                } else {
                    data.append("#").append(",");
                }
            }
        }

        int pos = data.length() - 1;
        while (data.charAt(pos) == '#' || data.charAt(pos) == ',') {
            pos--;
        }

        return data.substring(0, pos + 1);
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }

        String[] content = data.split(",");
        int index = 0;
        TreeNode root = new TreeNode(Integer.parseInt(content[index++]));

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (index < content.length) {
            TreeNode node = queue.poll();

            String left = content[index++];
            if (!left.equals("#")) {
                node.left = new TreeNode(Integer.parseInt(left));
                queue.offer(node.left);
            }
            if (index >= content.length) {
                break;
            }

            String right = content[index++];
            if (!right.equals("#")) {
                node.right = new TreeNode(Integer.parseInt(right));
                queue.offer(node.right);
            }
        }

        return root;
    }
}
