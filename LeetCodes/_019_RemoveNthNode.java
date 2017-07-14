public class _019_RemoveNthNode {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode index = head;
        ListNode post = head;

        for (int i = 0; i < n; i++) {
            post = index.next;
            index = index.next;
        }

        if (post == null) {
            head = head.next;
        } else {
            head.next = removeNthFromEnd(head.next, n);
        }

        return head;
    }
}
