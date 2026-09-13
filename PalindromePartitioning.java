import java.util.*;

class Solution {

    public List<List<String>> partition(String s) {

        List<List<String>> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();

        backtrack(s, 0, temp, ans);

        return ans;
    }

    void backtrack(String s, int start,
                   List<String> temp,
                   List<List<String>> ans) {

        // Entire string is processed
        if (start == s.length()) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        // Try every possible substring
        for (int end = start; end < s.length(); end++) {

            if (isPalindrome(s, start, end)) {

                // Choose
                temp.add(s.substring(start, end + 1));

                // Explore
                backtrack(s, end + 1, temp, ans);

                // Backtrack
                temp.remove(temp.size() - 1);
            }
        }
    }

    boolean isPalindrome(String s, int left, int right) {

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
