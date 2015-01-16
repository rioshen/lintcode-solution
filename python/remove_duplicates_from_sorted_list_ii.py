"""
Definition of ListNode
class ListNode(object):

    def __init__(self, val, next=None):
        self.val = val
        self.next = next
"""
class Solution:
    """
    @param head: A ListNode
    @return: A ListNode
    """
    def deleteDuplicates(self, head):
        if not head:
            return None
        dummy = ListNode(-1)
        curr = dummy
        while head and head.next:
            while head.val == head.next.val:
                head = head.next
            curr.next = head
            curr = curr.next
        return dummy.next