import java.util.*;

public class MergeKSortedLists {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue(lists.size(), new Comparator<ListNode>(){
            @Override
            public int compare(ListNode l1, ListNode l2) {
                if (l1 == null) {
                    return 1;
                } else if (l2 == null) {
                    return -1;
                }
                return l1.val - l2.val;
            }
        });
        for (ListNode head : lists) {
            if (head != null) {
                queue.add(head);
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (!queue.isEmpty()) {
            ListNode head = queue.poll();
            curr.next = head;
            curr = curr.next;
            if (head.next != null) {
                queue.offer(head.next);
            }
        }

        return dummy.next;
    }
}
