class Solution:
    # @param nums: The integer array
    # @param target: Target number to find
    # @return the first position of target in nums, position start from 0 
    def binarySearch(self, nums, target):
        if not nums:
            return -1
        result = -1
        lo, hi = 0, len(nums)-1
        while lo <= hi:
            mid = lo + (hi-lo)/2
            if nums[mid] == target:
                result = mid
                hi = mid - 1
            elif nums[mid] < target:
                lo = mid + 1
            else:
                hi = mid - 1
        return result
        
    def binarySearchRecur(self, nums, target):
        return self.bsearch(nums, target, 0, len(nums)-1)
        
    def bsearch(nums, target, lo, hi):
        if hi < lo:
            return -1
        mid = lo+hi // 2
        if nums[mid] < target:
            return self.bsearch(nums, target, mid+1, hi)
        elif nums[mid] > target:
            return self.bsearch(nums, target, lo, mid-1)
        else:
            return mid