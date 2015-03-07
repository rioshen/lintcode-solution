public class RemoveNthNodeFromEnd {
    /**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: The head of linked list.
     */
    ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        for (int i = 0; i < n; i++) {
            if (head == null) return null;
            head = head.next;
        }

        ListNode prev = dummy;
        while (head != null) {
            head = head.next;
            prev = prev.next;
        }
        prev.next = prev.next.next;

        return dummy.next;
    }
}
