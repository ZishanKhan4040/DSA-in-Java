import java.util.*;

class Solution {

    public List<List<String>> findLadders(
            String beginWord,
            String endWord,
            List<String> wordList) {

        List<List<String>> result = new ArrayList<>();

        Set<String> dictionary = new HashSet<>(wordList);

        // If endWord is not present, transformation is impossible
        if (!dictionary.contains(endWord)) {
            return result;
        }

        // parent[word] = all words from which 'word'
        // can be reached in the shortest path
        Map<String, List<String>> parent = new HashMap<>();

        // distance[word] = shortest distance from beginWord
        Map<String, Integer> distance = new HashMap<>();

        Queue<String> queue = new LinkedList<>();

        queue.offer(beginWord);
        distance.put(beginWord, 0);

        boolean found = false;

        while (!queue.isEmpty() && !found) {

            int size = queue.size();

            // Words discovered at this level
            Set<String> wordsUsedThisLevel = new HashSet<>();

            for (int i = 0; i < size; i++) {

                String current = queue.poll();
                int currentDistance = distance.get(current);

                char[] chars = current.toCharArray();

                for (int j = 0; j < chars.length; j++) {

                    char original = chars[j];

                    for (char c = 'a'; c <= 'z'; c++) {

                        if (c == original) {
                            continue;
                        }

                        chars[j] = c;
                        String next = new String(chars);

                        if (!dictionary.contains(next)) {
                            continue;
                        }

                        // First time discovering this word
                        if (!distance.containsKey(next)) {

                            distance.put(next, currentDistance + 1);

                            parent.put(next, new ArrayList<>());
                            parent.get(next).add(current);

                            queue.offer(next);
                            wordsUsedThisLevel.add(next);

                        }

                        // Another shortest path to the same word
                        else if (distance.get(next) == currentDistance + 1) {

                            parent.get(next).add(current);
                        }

                        if (next.equals(endWord)) {
                            found = true;
                        }
                    }

                    chars[j] = original;
                }
            }

            // Remove only after completing the whole level.
            // This is important because another word at the
            // same BFS level may also reach these words.
            for (String word : wordsUsedThisLevel) {
                dictionary.remove(word);
            }
        }

        // No path exists
        if (!distance.containsKey(endWord)) {
            return result;
        }

        // Build all paths from endWord -> beginWord
        List<String> path = new ArrayList<>();
        path.add(endWord);

        dfs(endWord, beginWord, parent, path, result);

        return result;
    }

    private void dfs(
            String current,
            String beginWord,
            Map<String, List<String>> parent,
            List<String> path,
            List<List<String>> result) {

        // Reached beginWord
        if (current.equals(beginWord)) {

            List<String> completePath = new ArrayList<>(path);

            // Currently path is end -> begin
            // Reverse it to get begin -> end
            Collections.reverse(completePath);

            result.add(completePath);
            return;
        }

        if (!parent.containsKey(current)) {
            return;
        }

        for (String previous : parent.get(current)) {

            path.add(previous);

            dfs(previous, beginWord, parent, path, result);

            path.remove(path.size() - 1);
        }
    }
}
