"""
Definition of ListNode
class ListNode(object):

    def __init__(self, val, next=None):
        self.val = val
        self.next = next
"""
class Solution:
    """
    @param head: The first node of the linked list.
    @return: You should return the head of the sorted linked list,
                  using constant space complexity.
    """
    def sortList(self, head):
        if not head or not head.next:
            return head
        
        # split the list into two halves until each of them contains only one
        middle = sortList(head)
        right = self.findMiddle(middle.next)
        middle.next = None
        left = self.sortList(head)
        
        return self.merge(left, right)
        
    def findMiddle(self, head):
        if not head:
            return None

        slow = head
        fast = head.next
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            
        return slow
        
    def merge(self, l1, l2):
        if not l1:
            return l2
            
        result = ListNode(-1)
        curr = result
        while l1 and l2:
            if l1.val < l2.val:
                curr.next = l1
                l1 = l1.next
            else:
                curr.next = l2
                l2 = l2.next
            curr = curr.next
            
        curr.next = l1 if l1 else l2
        
        return result.next