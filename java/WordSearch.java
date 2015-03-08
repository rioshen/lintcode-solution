public class WordSearch {
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        if (word == null || word.length() == 0) return true;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (find(board, word, 0, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean find(char[][] board, String word, int pos, int i, int j) {
        if (word.length() == pos) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || word.charAt(pos) != board[i][j]) {
            return false;
        }

        // find one
        board[i][j] = '#';
        boolean find = find(board, word, pos + 1, i + 1, j)
                        || find(board, word, pos + 1, i, j + 1)
                        || find(board, word, pos + 1, i - 1, j)
                        || find(board, word, pos + 1, i, j - 1);
        board[i][j] = word.charAt(pos);

        return find;
    }
}
