class Solution:
    """
    @param matrix, a list of lists of integers
    @param target, an integer
    @return a boolean, indicate whether matrix contains target
    """
    def searchMatrix(self, matrix, target):
        if not matrix:
            return False
        rows = len(matrix)
        cols = len(matrix[0])
        lo, hi = 0, rows*cols-1
        while lo <= hi:
            mid = lo + (hi-lo)//2
            val = matrix[mid/cols][mid%cols]
            if val == target:
                return True
            elif val < target:
                lo = mid + 1
            else:
                hi = mid - 1
        return False