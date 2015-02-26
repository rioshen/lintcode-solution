import java.util.*;

public class LongestConsecutive {
    /**
     * @param nums: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<Integer>();
        for (int elem : num) set.add(elem);
        int max = 0;
        for (int elem : num) {
            int count = 1;
            int left = elem - 1, right = elem + 1;

            while (set.contains(left)) {
                set.remove(left);
                left--;
                count++;
            }

            while (set.contains(right)) {
                set.remove(right);
                right++;
                count++;
            }

            max = Math.max(max, count);
        }
        return max;
    }
}
