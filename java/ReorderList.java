public class ReorderList {
    /**
     * @param head: The head of linked list.
     * @return: void
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode middle = getMiddle(head);

        ListNode newHead = middle.next;
        middle.next = null;

        newHead = reverse(newHead);

        while (head != null && newHead != null) {
            ListNode temp = head.next;
            head.next = newHead;
            newHead = newHead.next;
            head.next.next = temp;
            head = temp;
        }
    }

    public ListNode getMiddle(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
