Description
-------------

> Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
> 
> You may assume no duplicates in the array.
> 
> Example
> 
> `[1,3,5,6]`, 5 → 2
> 
> `[1,3,5,6]`, 2 → 1
> 
> `[1,3,5,6]`, 7 → 4
> 
> `[1,3,5,6]`, 0 → 0

Solution
-----------

```python
class Solution:
    """
    @param A : a list of integers
    @param target : an integer to be inserted
    @return : an integer
    """
    def searchInsert(self, A, target):
        if not A:
            return 0
        low, high = 0, len(A) - 1
        while low <= high:
            mid = low + (high - low) / 2
            if A[mid] == target:
                return mid
            elif mid > low and A[mid] > target and target > A[mid-1]:
                return mid
            elif A[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return low
```
