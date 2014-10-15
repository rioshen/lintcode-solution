Description
-------------
> Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. 
> 
> Note
> 
> You may assume that each input would have exactly one solution.
> 
> Example
> 
> For example, given array S = `{-1 2 1 -4}`, and target = `1`. The sum that is closest to the target is 2. `(-1 + 2 + 1 = 2)`.

Solution
---------

```python
class Solution:
    """
    @param numbers: Give an array numbers of n integer
    @param target : An integer
    @return : return the sum of the three integers, the sum closest target.
    """
    def threeSumClosest(self, numbers, target):
        import sys
        # write your code here
        if not numbers or len(numbers) == 0: return []
        numbers, result, closet = sorted(numbers), [], sys.maxint / 2
        for i, num in enumerate(numbers):
            low, high = i + 1, len(numbers) - 1
            while low < high:
                sum = num + numbers[low] + numbers[high]
                if sum == target:
                    return sum
                elif sum > target:
                    high -= 1
                else:
                    low += 1
                if abs(sum - target) < abs(closet - target):
                    closet = sum
        return closet
```
