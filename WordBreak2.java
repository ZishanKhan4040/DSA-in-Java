import java.util.*;

class Solution {

    Map<Integer, List<String>> memo = new HashMap<>();
    Set<String> dict = new HashSet<>();

    public List<String> wordBreak(String s, List<String> wordDict) {

        dict.addAll(wordDict);

        return solve(s, 0);
    }

    private List<String> solve(String s, int start) {

        if (start == s.length()) {
            List<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        if (memo.containsKey(start)) {
            return memo.get(start);
        }

        List<String> result = new ArrayList<>();

        for (int end = start + 1; end <= s.length(); end++) {

            String word = s.substring(start, end);

            if (!dict.contains(word)) {
                continue;
            }

            List<String> remaining = solve(s, end);

            for (String sentence : remaining) {

                if (sentence.isEmpty()) {
                    result.add(word);
                } else {
                    result.add(word + " " + sentence);
                }
            }
        }

        memo.put(start, result);

        return result;
    }
}
