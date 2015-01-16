class Solution:
    """
    @param A : a list of integers
    @param target : an integer to be searched
    @return : a list of length 2, [index1, index2]
    """
    def searchRange(self, A, target):
        if not A:
            return [-1, -1]
        start = end = -1
        
        # search for the left bound, once find the target, expand towards left side
        lo, hi = 0, len(A)-1
        while lo <= hi:
            mid = lo + (hi-lo)//2
            val = A[mid]
            if val >= target: # search from the left
                hi = mid + 1
            else:
                lo = mid - 1
        if A[lo] != target:
            return [-1, -1]
        start = lo + 1
            
        # search for the right bound, once find the target, expand towards right side
        lo, hi = 0, len(A)-1
        while lo <= hi:
            mid = lo + (hi-lo)//2
            val = A[mid]
            if val <= target:
                lo = mid + 1
            else:
                hi = mid - 1
        if A[hi] != target:
            return [-1, -1]
        end = hi + 1
        return [start, end]