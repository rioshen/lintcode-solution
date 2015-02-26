public class RotateList {
    private int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    /**
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        k = k  % getLength(head);
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        while (k != 0) {
            curr = curr.next;
            k--;
        }

        ListNode tail = dummy;
        while (curr.next != null) {
            tail = tail.next;
            curr = curr.next;
        }
        curr.next = dummy.next;
        dummy.next = tail.next;
        tail.next = null;

        return dummy.next;
    }
}
