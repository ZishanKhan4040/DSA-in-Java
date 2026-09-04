class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {

        int len1 = s1.length();
        int len2 = s2.length();

        // seen[index] = {number of s1 blocks, number of s2 blocks}
        int[][] seen = new int[len2][2];

        for (int i = 0; i < len2; i++) {
            seen[i][0] = -1;
            seen[i][1] = -1;
        }

        int s1Count = 0;
        int s2Count = 0;
        int index = 0;

        while (s1Count < n1) {

            // Process one copy of s1
            for (int i = 0; i < len1; i++) {

                if (s1.charAt(i) == s2.charAt(index)) {
                    index++;

                    // One complete s2 found
                    if (index == len2) {
                        index = 0;
                        s2Count++;
                    }
                }
            }

            s1Count++;

            // We have seen this state before
            if (seen[index][0] != -1) {

                int previousS1 = seen[index][0];
                int previousS2 = seen[index][1];

                int cycleS1 = s1Count - previousS1;
                int cycleS2 = s2Count - previousS2;

                int remaining = n1 - s1Count;

                int cycles = remaining / cycleS1;

                s1Count += cycles * cycleS1;
                s2Count += cycles * cycleS2;

            } else {
                seen[index][0] = s1Count;
                seen[index][1] = s2Count;
            }
        }

        return s2Count / n2;
    }
}
