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
    @return: nothing
    """
    def findMiddle(self, head):
        if not head:
            return None
            
        slow = head
        fast = head.next
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            
        return slow

    def reverse(self, head):
        prev = None
        curr = head
        while curr:
            next = curr.next
            curr.next = prev
            prev = curr
            curr = next
        return prev

    def merge(self, l1, l2):
        cnt = 0
        curr = ListNode(-1)

        while l1 and l2:
            if cnt % 2 == 0:
                curr.next = l1
                l1 = l1.next
            else:
                curr.next = l2
                l2 = l2.next
            curr = curr.next
            cnt += 1

        curr.next = l1 if l1 else l2

    def reorderList(self, head):
        if not head:
            return
        
        middle = self.findMiddle(head)
        tail = self.reverse(middle.next)
        middle.next = None
        
        self.merge(head, tail)