class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord))
            return 0;

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        int count = 1;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                String word = q.remove();
                char[] arr = word.toCharArray();

                for (int i = 0; i < arr.length; i++) {

                    char original = arr[i];

                    for (char ch = 'a'; ch <= 'z'; ch++) {

                        arr[i] = ch;

                        String newWord = new String(arr);

                        if (newWord.equals(endWord))
                            return count + 1;

                        if (set.contains(newWord)) {
                            q.add(newWord);
                            set.remove(newWord);
                        }
                    }

                    arr[i] = original;
                }
            }

            count++;
        }

        return 0;
    }
}
