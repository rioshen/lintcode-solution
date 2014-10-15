Description
-------------

> Binary search is a famous question in algorithm.
> 
> For a given sorted array (ascending order) and a target number, find the first index of this number in O(log n) time complexity.
> 
> If the target number does not exist in the array, return -1.
> 
> Example
> 
> If the array is `[1, 2, 3, 3, 4, 5, 10]`, for given target `3`, return `2`.

Solution
-----------

```python
class Solution:
    # @param nums: The integer array
    # @param target: Target number to find
    # @return the first position of target in nums, position start from 0 
    def binarySearch(self, nums, target):
        if not nums:
            return -1
        low, high, result = 0, len(nums) - 1, -1
        while low <= high:
            mid = low + (high - low) / 2 # avoid overflow, similar like (high+low)/2
            if nums[mid] == target:
                high = mid - 1
                result = mid
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return result
```
