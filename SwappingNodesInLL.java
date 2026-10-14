class Solution {
    public ListNode swapNodes(ListNode head, int k) {

        ListNode fast = head;
        ListNode slow = head;

        for (int i = 1; i < k; i++) {
            fast = fast.next;
        }

        ListNode firstNode = fast;

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        int temp = firstNode.val;
        firstNode.val = slow.val;
        slow.val = temp;

        return head;
    }
}
