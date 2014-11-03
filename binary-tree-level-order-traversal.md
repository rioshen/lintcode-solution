Binary Tree Level Order Traversal
-----------------------------------------

> Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

> Example

> Given binary tree `{3,9,20,#,#,15,7}`,

> `[[3], [9,20], [15,7]]`

Solution
-------------

```python
from collections import deque
from lintcode import TreeNode
"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        this.val = val
        this.left, this.right = None, None
"""


class Solution:
    """
    @param root: The root of binary tree.
    @return: Level order in a list of lists of integers
    """
    def levelOrder(self, root):
        result = []
        if not root:
            return result
        queue = deque([root])
        while queue:
            level, count = [], len(queue)
            while count:
                node = queue.popleft()
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
                level.append(node.val)
                count -= 1
            result.append(level)
        return result
```
