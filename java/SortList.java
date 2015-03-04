public class SortList {
    /**
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list,
                    using constant space complexity.
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode middle = findMiddle(head);
        ListNode newHead = middle.next;
        middle.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(newHead);

        return merge(left, right);
    }

    public ListNode findMiddle(ListNode head) {
        if (head == null) return head;

        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public ListNode merge(ListNode left, ListNode right) {
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }

            curr = curr.next;
        }

        curr.next = left == null ? right : left;

        return dummy.next;
    }
}
