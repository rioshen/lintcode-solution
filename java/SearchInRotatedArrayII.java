public class SearchInRotatedArrayII {
    /**
     * param A : an integer ratated sorted array and duplicates are allowed
     * param target :  an integer to be search
     * return : a boolean
     */
    public boolean search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return false;
        }

        int lo = 0, hi = A.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (A[mid] == target) {
                return true;
            }
            if (A[lo] < A[mid]) {
                if (A[lo] <= target && target < A[mid]) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            } else if (A[lo] > A[mid]) {
                if (A[mid] < target && target <= A[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            } else {
                lo++;
            }
        }

        return false;
    }
}
