
import java.util.*;

class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ArrayList<Integer> positions = new ArrayList<>();

        ListNode prev = head;
        ListNode temp = head.next;

        int index = 1;

        while (temp.next != null) {
            ListNode next = temp.next;

            if ((temp.val > prev.val && temp.val > next.val) ||
                (temp.val < prev.val && temp.val < next.val)) {
                positions.add(index);
            }

            prev = temp;
            temp = next;
            index++;
        }

        if (positions.size() < 2) {
            return new int[]{-1, -1};
        }

        int maxDistance =
            positions.get(positions.size() - 1) - positions.get(0);

        int minDistance = Integer.MAX_VALUE;

        for (int i = 1; i < positions.size(); i++) {
            int distance = positions.get(i) - positions.get(i - 1);
            minDistance = Math.min(minDistance, distance);
        }

        return new int[]{minDistance, maxDistance};
    }
}
