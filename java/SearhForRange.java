import java.util.*;

public class SearhForRange {
   /**
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public ArrayList<Integer> searchRange(ArrayList<Integer> A, int target) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(-1);
        res.add(-1);

        if(A == null || A.size() == 0) {
            return res;
        }

        int start = -1, end = -1;
        int lo = 0, hi = A.size() - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (A.get(mid) == target) {
                start = mid;
                hi = mid - 1;
            } else if (A.get(mid) > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        if (start == -1) {
            return res;
        } else{
            res.set(0, start);
        }

        lo = start;
        hi = A.size() - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (A.get(mid) == target) {
                end = mid;
                lo = mid + 1;
            } else if (A.get(mid) < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        res.set(1, end);

        return res;
    }
}
