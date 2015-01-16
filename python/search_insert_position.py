class Solution:
    """
    @param A : a list of integers
    @param target : an integer to be inserted
    @return : an integer
    """
    def searchInsert(self, A, target):
        if not A:
            return 0
        lo, hi = 0, len(A)-1
        while lo <= hi:
            mid = lo + (hi-lo)//2
            val = A[mid]
            if val == target:
                return mid
            elif val < target:
                lo = mid + 1
            else:
                hi = mid - 1
        return lo