import java.util.*;

class Solution {

    public List<String> addOperators(String num, int target) {

        List<String> ans = new ArrayList<>();

        backtrack(num, target, 0, 0, 0, "", ans);

        return ans;
    }

    private void backtrack(String num, int target,
                           int index,
                           long value,
                           long last,
                           String expression,
                           List<String> ans) {

        // We have used all digits
        if (index == num.length()) {

            if (value == target) {
                ans.add(expression);
            }

            return;
        }

        for (int i = index; i < num.length(); i++) {

            // Do not allow leading zero
            if (i > index && num.charAt(index) == '0') {
                break;
            }

            String part = num.substring(index, i + 1);

            long current = Long.parseLong(part);

            // First number
            if (index == 0) {

                backtrack(
                    num,
                    target,
                    i + 1,
                    current,
                    current,
                    part,
                    ans
                );

            } else {

                // +
                backtrack(
                    num,
                    target,
                    i + 1,
                    value + current,
                    current,
                    expression + "+" + part,
                    ans
                );

                // -
                backtrack(
                    num,
                    target,
                    i + 1,
                    value - current,
                    -current,
                    expression + "-" + part,
                    ans
                );

                // *
                backtrack(
                    num,
                    target,
                    i + 1,
                    value - last + last * current,
                    last * current,
                    expression + "*" + part,
                    ans
                );
            }
        }
    }
}
