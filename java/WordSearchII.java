import java.util.*;

public class WordSearchII {
    private TrieNode root = new TrieNode('0');

    static class TrieNode {
        char letter;
        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        boolean isEnd;

        public TrieNode(char letter) { this.letter = letter; }
    }

    public void buildTrie(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children.containsKey(c)) {
                curr = curr.children.get(c);
            } else {
                TrieNode node = new TrieNode(c);
                curr.children.put(c, node);
                curr = node;
            }
        }
        curr.isEnd = true;
    }

    public List<String> wordSearchII(char[][] board, List<String> words) {
        if (board == null || board.length == 0 || board[0].length == 0) return null;
        for (String word : words) buildTrie(word);
        LinkedHashSet<String> ret = new LinkedHashSet<String>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                helper(board, i, j, root, visited, "", ret);
            }
        }

        List<String> result = new ArrayList<String>();
        for (String word : ret) result.add(word);
        return result;
    }

    public void helper(char[][] board, int i, int j, TrieNode node, boolean[][] visited, String temp, LinkedHashSet<String> res) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        if (root == null || !root.children.containsKey(board[i][j]) || visited[i][j]) return;

        temp += board[i][j];
        if (root.children.get(board[i][j]).isEnd) res.add(temp);

        visited[i][j] = true;
        int[] x = {0, 0, -1, 1};
        int[] y = {1, -1, 0, 0};
        for (int k = 0; k < 4; k++) {
            helper(board, i + x[k], j + y[k], node.children.get(board[i][j]), visited, temp, res);
        }
        visited[i][j] = false;
    }
}
