public class RemoveDuplicatesFromSortedListII {
    /**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of the linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (head != null) {
            boolean foundDups = false;
            while (head.next != null && head.next.val == head.val) {
                foundDups = true;
                head = head.next;
            }
            if (foundDups) {
                head = head.next;
                continue;
            }

            curr.next = head;
            curr = curr.next;
            head = head.next;
        }
        curr.next = head;

        return dummy.next;
    }
}
