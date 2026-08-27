
class Solution {
public:
    vector<int> findSubstring(string s, vector<string>& words) {
        
        vector<int> ans;

        if (s.empty() || words.empty())
            return ans;

        int wordLen = words[0].size();
        int wordCount = words.size();
        int totalLen = wordLen * wordCount;

        if (s.size() < totalLen)
            return ans;

        unordered_map<string, int> required;

        for (string word : words) {
            required[word]++;
        }

        // Try every possible starting offset
        for (int offset = 0; offset < wordLen; offset++) {

            int left = offset;
            int count = 0;

            unordered_map<string, int> current;

            for (int right = offset;
                 right + wordLen <= s.size();
                 right += wordLen) {

                string word = s.substr(right, wordLen);

                // Word is not present in words
                if (required.find(word) == required.end()) {
                    current.clear();
                    count = 0;
                    left = right + wordLen;
                    continue;
                }

                current[word]++;
                count++;

                // Too many occurrences of this word
                while (current[word] > required[word]) {
                    string leftWord = s.substr(left, wordLen);

                    current[leftWord]--;
                    left += wordLen;
                    count--;
                }

                // Found all words
                if (count == wordCount) {
                    ans.push_back(left);

                    // Move window forward to search for next answer
                    string leftWord = s.substr(left, wordLen);
                    current[leftWord]--;
                    left += wordLen;
                    count--;
                }
            }
        }

        return ans;
    }
};
