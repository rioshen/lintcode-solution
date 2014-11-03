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
        numbers.sort()
        result = []
        seen = set()
        for index, elem in enumerate(numbers):
            lo, hi = index+1, len(numbers)-1
            while lo < hi:
                res = elem + numbers[lo] + numbers[hi]
                if res == 0:
                    sol = [elem, numbers[lo], numbers[hi]]
                    if tuple(sol) not in seen:
                        result.append(sol)
                        seen.add(tuple(sol))
                    lo, hi = lo+1, hi-1
                elif res > 0:
                    hi -= 1
                else:
                    lo += 1
        return result
```
