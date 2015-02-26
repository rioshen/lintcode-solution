import java.util.*;

public class RecoverRotatedArray {
    /**
     * @param nums: The rotated sorted array
     * @return: The recovered sorted array
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        if (nums == null || nums.size() == 0) return;

        int size = nums.size();
        for (int i = 0; i < size; i++) {
            if (i < size - 1 && nums.get(i) > nums.get(i + 1)) {
                reverse(nums, 0, i);
                reverse(nums, i + 1, size - 1);
                reverse(nums, 0, size - 1);
                return;
            }
        }
    }

    private void reverse(ArrayList<Integer> nums, int i, int j) {
        while (i < j) {
            int temp = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, temp);
            i++;
            j--;
        }
    }
}
