public class JumpGameII {
    public int jump(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int prev = 0, curr = 0, cnt = 0;
        for (int i = 0; i < A.length; i++) {
            if (i > prev) {
                prev = curr;
                cnt++;
            }
            curr = Math.max(curr, A[i] + i);
        }

        return cnt;
    }
}
