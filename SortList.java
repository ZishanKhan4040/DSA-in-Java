class Solution {
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        // Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Divide the list into two halves
        prev.next = null;

        // Recursively sort both halves
        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        // Merge both sorted halves
        return merge(left, right);
    }

    private ListNode merge(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {

            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }

            current = current.next;
        }

        if (l1 != null) {
            current.next = l1;
        }

        if (l2 != null) {
            current.next = l2;
        }

        return dummy.next;
    }
}
