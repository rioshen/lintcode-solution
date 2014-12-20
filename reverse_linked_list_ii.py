"""
Definition of ListNode

class ListNode(object):

    def __init__(self, val, next=None):
        self.val = val
        self.next = next
"""
class Solution:
    """
    @param head: The head of linked list
    @param m: start position
    @param n: end position
    """
    def reverseBetween(self, head, m, n):
        if not head:
            return None
        # as the head might be reversed, use a dummy node to keep tracking
        dummy = ListNode(-1)
        dummy.next = head
        
        # before reversing, iterate over until the previous of the target
        prev = dummy
        for i in xrange(1, m):
            if not prev:
                return None
            prev = prev.next
        
        # now we can start reversing
        curr = prev.next
        next = curr.next
        for i in xrange(m, n):
            curr.next = next.next
            next.next = prev.next
            prev.next = next
            next = curr.next
            
        return dummy.next