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


    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode node = new ListNode(0);
        node.next = head;

        ListNode first = head;
        int len = 0;
        while(first != null){
            len ++;
            first = first.next;
        }
        int pos = len - n;
        first = node;
        while(pos > 0){
            pos --;
            first = first.next;
        }
        first.next = first.next.next;

        return node.next;
    }

}
