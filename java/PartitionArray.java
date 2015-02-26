import java.util.Collections;
import java.util.ArrayList;

public class PartitionArray {
    /**
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(ArrayList<Integer> nums, int k) {
	    if (nums == null || nums.size() == 0) {
	        return 0;
	    }

	    int lo = 0, hi = nums.size() - 1;
	    while (lo < hi) {
	        while (lo <= hi && nums.get(lo) < k) {
	            lo++;
	        }
	        while (lo <= hi && nums.get(hi) >= k) {
	            hi--;
	        }
	        if (lo < hi) {
	            Collections.swap(nums, lo, hi);
	            lo++;
	            hi--;
	        }
	    }
	    return lo;
    }
}
