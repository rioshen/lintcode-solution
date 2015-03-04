public class SortColors {
    private static final int RED = 0;
    private static final int WHITE = 1;
    private static final int BLUE = 2;

    /**
     * @param nums: A list of integer which is 0, 1 or 2
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int red = 0, white = 0, blue = nums.length - 1;
        while (white <= blue) {
            if (nums[white] == RED) {
                swap(nums, red, white);
                red++;
                white++;
            } else if (nums[white] == BLUE) {
                swap(nums, white, blue);
                blue--;
            } else {
                white++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
