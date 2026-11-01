class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.val, b.val)
        );

        // Step 1: Add heads of all lists
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }

        // Step 2: Create dummy node
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        // Step 3: Process heap
        while (!pq.isEmpty()) {

            ListNode smallest = pq.poll();

            // Attach smallest node
            tail.next = smallest;
            tail = tail.next;

            // Add next node of extracted node
            if (smallest.next != null) {
                pq.add(smallest.next);
            }
        }

        return dummy.next;
    }
}
