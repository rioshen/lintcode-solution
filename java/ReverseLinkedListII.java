public class ReverseLinkedListII {
    /**
     * @param ListNode head is the head of the linked list
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        if (head == null || head.next == null || m >= n) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        dummy.next = head;

        for (int i = 1; i < m; i++) {
            prev = prev.next;
        }
        ListNode start = prev.next;

        ListNode end = head;
        for (int i = 1; i < n; i++) {
            end = end.next;
        }

        prev.next = reverse(start, end, n - m + 1);

        return dummy.next;
    }

    public ListNode reverse(ListNode start, ListNode end, int len) {
        ListNode prev = end.next;
        ListNode curr = start;
        while (len != 0) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            len--;
        }
        return prev;
    }
}
