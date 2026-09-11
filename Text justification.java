class Solution {
public:
    vector<string> fullJustify(vector<string>& words, int maxWidth) {

        vector<string> ans;
        int n = words.size();
        int i = 0;

        while (i < n) {

            int j = i;
            int lineLength = 0;

            // Find maximum words that can fit in this line
            while (j < n &&
                   lineLength + words[j].length() + (j - i) <= maxWidth) {

                lineLength += words[j].length();
                j++;
            }

            int wordCount = j - i;
            int gaps = wordCount - 1;

            string line = "";

            // Last line OR only one word
            if (j == n || wordCount == 1) {

                for (int k = i; k < j; k++) {

                    line += words[k];

                    if (k != j - 1)
                        line += " ";
                }

                // Add remaining spaces at the end
                while (line.length() < maxWidth)
                    line += " ";
            }

            // Normal justified line
            else {

                int totalSpaces = maxWidth - lineLength;

                int spacesEach = totalSpaces / gaps;
                int extraSpaces = totalSpaces % gaps;

                for (int k = i; k < j; k++) {

                    line += words[k];

                    if (k != j - 1) {

                        int spaces = spacesEach;

                        // Left gaps get extra spaces
                        if (extraSpaces > 0) {
                            spaces++;
                            extraSpaces--;
                        }

                        while (spaces--)
                            line += " ";
                    }
                }
            }

            ans.push_back(line);
            i = j;
        }

        return ans;
    }
};
