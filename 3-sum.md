Description
------------

> Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
> 
> Note
> 
> Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
> 
> The solution set must not contain duplicate triplets.
> 
> Example
> 
> For example, given array S = `{-1 0 1 2 -1 -4}`, A solution set is:
> 
> `(-1, 0, 1)`
> 
> `(-1, -1, 2)`

Solution
----------

```python
class Solution:
    """
    @param numbersbers : Give an array numbersbers of n integer
    @return : Find all unique triplets in the array which gives the sum of zero.
    """
    def threeSum(self, numbers):
        numbers, result = sorted(numbers), []
        for idx, num in enumerate(numbers):
            low, high = idx + 1, len(numbers) - 1
            while low < high:
                sum = num + numbers[low] + numbers[high]
                if sum == 0:
                    sol = [num, numbers[low], numbers[high]]
                    if sol not in result:
                        result.append(sol)
                    low, high = low + 1, high - 1
                elif sum > 0:
                    high -= 1
                else: 
                    low += 1
        return result
```
