class ReverseKGroup{
    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || k == 1) {
            return head;
        }

        ListNode curr = head;
        ListNode newHead = null;
        ListNode tail = null;

        while (curr != null) {

            ListNode groupHead = curr;

            // Check whether k nodes are available
            ListNode temp = curr;
            int count = 0;

            while (temp != null && count < k) {
                temp = temp.next;
                count++;
            }

            // Less than k nodes -> don't reverse
            if (count < k) {
                if (tail != null) {
                    tail.next = curr;
                }
                break;
            }

            // Reverse k nodes
            ListNode prev = null;
            ListNode nextNode = null;
            count = 0;

            while (curr != null && count < k) {
                nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
                count++;
            }

            // First reversed group
            if (newHead == null) {
                newHead = prev;
            }

            // Connect previous group
            if (tail != null) {
                tail.next = prev;
            }

            // groupHead is now the tail
            tail = groupHead;
        }

        return newHead;
    }
}
