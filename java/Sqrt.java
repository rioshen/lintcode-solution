public class Sqrt {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        if (x < 2) {
            return x;
        }

        long lo = 1;
        long hi = x / 2;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            if (x / mid < mid) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return (int)hi;
    }
}
