
import java.util.Arrays;

class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int[][] result = new int[intervals.length][2];
        int index = 0;

        result[0] = intervals[0];

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] <= result[index][1]) {
                result[index][1] = Math.max(
                    result[index][1],
                    intervals[i][1]
                );
            } else {
                index++;
                result[index] = intervals[i];
            }
        }

        return Arrays.copyOf(result, index + 1);
    }
}
