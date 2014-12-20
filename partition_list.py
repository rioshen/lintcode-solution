"""
Definition of ListNode
class ListNode(object):

    def __init__(self, val, next=None):
        self.val = val
        self.next = next
"""
class Solution:
    """
    @param head: The first node of linked list.
    @param x: an integer
    @return: a ListNode 
    """
    def partition(self, head, x):
        if not head:
            return None
            
        # to keep tracking smaller and greater sublists, declare two dummy node
        small_dummy = ListNode(-1)
        small = small_dummy
        great_dummy = ListNode(-1)
        great = great_dummy
        
        while head:
            if head.val < x:
                small.next = head
                small = small.next
            else:
                great.next = head
                great = great.next
            head = head.next
            
        # partition two sublists and point the last node to null
        small.next = great_dummy.next
        great.next = None
        
        return small_dummy.next