Binary Tree Inorder Traversal
------------------------------

> Given a binary tree, return the inorder traversal of its nodes' values.

> Example

> Given binary tree `{1,#,2,3}`,

> ```
>   1
>    \
>     2
>    /
>   3
> ```
 
> return `[1,3,2]`.

Solution
------------

```python
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
    @return: Inorder in ArrayList which contains node values.
    """
    def inorderTraversal(self, root):
        # write your code here
        result = []
        if not root:
            return result
        stack, current = [], root
        while stack or current:
            if current: # traverse the left sub-tree
                stack.append(current)
                current = current.left
            else: # backtrack to the parent
                node = stack.pop()
                result.append(node.val)
                current = node.right
        return result

```
