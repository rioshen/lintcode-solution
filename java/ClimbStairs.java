public class ClimbStairs {
    private int[] cache = new int[10000];
    public ClimbStairs() {
        cache[0] = 0;
        cache[1] = 1;
        cache[2] = 2;
    }
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairsCache(int n) {
        if (cache[n] != 0) {
            return cache[n];
        } else {
            cache[n] = climbStairs(n - 1) + climbStairs(n - 2);
            return cache[n];
        }
    }

    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        int a = 1, b = 2;
        while (n > 1) {
            int c = a + b;
            a = b;
            b = c;
            n--;
        }
        return a;
    }
    
}