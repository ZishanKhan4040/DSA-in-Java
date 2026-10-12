class Solution {
    public ListNode partition(ListNode head, int x) {

        ListNode LHS = new ListNode(-1);
        ListNode RHS = new ListNode(-1);

        ListNode lhsHead = LHS;
        ListNode rhsHead = RHS;

        ListNode temp = head;

        while (temp != null) {
            ListNode nextNode = temp.next;

            if (temp.val < x) {
                LHS.next = temp;
                LHS = LHS.next;
            } else {
                RHS.next = temp;
                RHS = RHS.next;
            }

            temp.next = null;
            temp = nextNode;
        }

        LHS.next = rhsHead.next;
        RHS.next = null;

        return lhsHead.next;
    }
}
