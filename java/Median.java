import java.util.*;

public class Median {
    /**
     * @param nums: A list of integers.
     * @return: An integer denotes the middle number of the array.
     */
    public int medianSorting(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        Arrays.sort(nums);

        int len = nums.length;
        if (len % 2 != 0) {
            return nums[len / 2];
        } else {
            return nums[len / 2 - 1];
        }
    }

    public int median(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else {
            int len = nums.length;
            if (len % 2 != 0) {
                return selectMiddle(nums, len / 2);
            } else {
                return selectMiddle(nums, len / 2 - 1);
            }
        }
    }

    private int selectMiddle(int[] arr, int k) {
        int lo = 0, hi = arr.length - 1;
        while (lo < hi) {
            int l = lo, r = hi;
            int middle = arr[l + (r - l) / 2];
            while (l < r) {
                if (arr[l] >= middle) {
                    int temp = arr[r];
                    arr[r] = arr[l];
                    arr[l] = temp;
                    r--;
                } else {
                    l++;
                }
            }

            if (arr[l] > middle) {
                l--;
            }
            if (k <= l) {
                hi = l;
            } else {
                lo = l + 1;
            }
        }

        return arr[k];
    }
}
