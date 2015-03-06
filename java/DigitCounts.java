public class DigitCounts {
    /*
     * Solution:
     * The time complexity is O(N ^ 2)
     *
     * param k : As description.
     * param n : As description.
     * return: An integer denote the count of digit k in 1..n
     */
    public int digitCountsNSqrt(int k, int n) {
        if (n < 0) return 0;

        int cnt = 0;
        for (int i = 0; i <= n; i++) {
            cnt += getDigit(k, i);
        }
        return cnt;
    }

    private int getDigit(int k, int n) {
        int count = 0;

        while (n > 0) {
            if (n % 10 == k) count++;
            n /= 10;
        }
        return count;
    }

    public int DigitCounts(int k, int n) {

    }
}
