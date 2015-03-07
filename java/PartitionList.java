public class PartitionList {
    /**
     * @param head: The first node of linked list.
     * @param x: an integer
     * @return: a ListNode
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;

        ListNode smallDummy = new ListNode(0), greatDummy = new ListNode(0);
        ListNode small = smallDummy, great = greatDummy;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                great.next = head;
                great = great.next;
            }
            head = head.next;
        }
        small.next = greatDummy.next;
        great.next = null;

        return smallDummy.next;
    }
}
