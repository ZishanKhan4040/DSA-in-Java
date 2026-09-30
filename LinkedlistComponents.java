class Solution {
    public int numComponents(ListNode head, int[] nums) {

        boolean[] present = new boolean[10001];

        // Mark all nums
        for (int x : nums) {
            present[x] = true;
        }

        int count = 0;
        ListNode curr = head;

        while (curr != null) {

            // Current node belongs to nums
            if (present[curr.val]) {

                // Either current is the last node
                // or next node does not belong to nums
                if (curr.next == null || !present[curr.next.val]) {
                    count++;
                }
            }

            curr = curr.next;
        }

        return count;
    }
}
