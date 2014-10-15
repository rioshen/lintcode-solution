Description
-------------

> Write an efficient algorithm that searches for a value in an m x n matrix.
> 
> This matrix has the following properties:
> 
>  + Integers in each row are sorted from left to right.
>  + The first integer of each row is greater than the last integer of the previous row.
> 
> Example
> 
> Consider the following matrix:
> `[[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 50]]`
> 
> Given target = `3`, return `true`.

Solution
-----------

```python
class Solution:
    """
    @param matrix, a list of lists of integers
    @param target, an integer
    @return a boolean, indicate whether matrix contains target
    """
    def searchMatrix(self, matrix, target):
        if not matrix:
            return False
        low, high = 0, len(matrix) * len(matrix[0]) - 1
        while low <= high:
            mid = low + (high - low) / 2
            value = matrix[mid / len(matrix[0])][mid % len(matrix[0])]
            if value == target:
                return True
            elif value > target:
                high = mid - 1
            else:
                low = mid + 1
        return False
```
