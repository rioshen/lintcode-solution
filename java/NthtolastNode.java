public class NthtoLastNode {
    /**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: Nth to last node of a singly linked list.
     */
    ListNode nthToLast(ListNode head, int n) {
        if (head == null) return null;

        ListNode fast = head;
        while (n > 1 && fast.next != null) {
            fast = fast.next;
            n--;
        }
        if (n == 1 && fast.next == null) {
            return head;
        }

        ListNode slow = head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
