public class EditDistance {
    /**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        int distance = 1;

        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for  (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    distance = 0;
                } else {
                    distance = 1;
                }
                dp[i][j] = Math.min(Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1),
                            dp[i - 1][j - 1] + distance);
            }
        }

        return dp[m][n];
    }
}
