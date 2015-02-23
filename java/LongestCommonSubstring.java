public class LongestCommonSubstring {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        if (A == null || B == null) {
            return 0;
        }

        int m = A.length(), n = B.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++ ) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        int maxLen = 0;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                maxLen = Math.max(maxLen, dp[i][j]);
            }
        }

        return maxLen;
    }
}
