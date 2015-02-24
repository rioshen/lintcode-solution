public class ConvertIntegerAtoIntegerB {
    /**
     *@param a, b: Two integer
     *return: An integer
     */
    public static int bitSwapRequired(int a, int b) {
        int res = 0;
        while (a != 0 || b != 0) {
            res += (a & 1) ^ (b & 1);
            a = a >> 1;
            b = b >> 1;
        }
        return res;
    }
}