class Solution {
public:

    bool canForm(string word, unordered_set<string>& st) {
        int n = word.length();

        vector<bool> dp(n + 1, false);
        dp[0] = true;

        for (int i = 0; i < n; i++) {

            if (!dp[i])
                continue;

            for (int j = i + 1; j <= n; j++) {

                string part = word.substr(i, j - i);

                if (st.count(part)) {
                    dp[j] = true;
                }
            }
        }

        return dp[n];
    }

    vector<string> findAllConcatenatedWordsInADict(vector<string>& words) {

        unordered_set<string> st;

        for (string word : words) {
            st.insert(word);
        }

        vector<string> ans;

        for (string word : words) {

            // Remove current word so it cannot use itself
            st.erase(word);

            if (canForm(word, st)) {
                ans.push_back(word);
            }

            // Put it back
            st.insert(word);
        }

        return ans;
    }
};
