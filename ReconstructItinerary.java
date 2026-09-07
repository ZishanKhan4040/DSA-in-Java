import java.util.*;

class Solution {

    Map<String, PriorityQueue<String>> map = new HashMap<>();
    LinkedList<String> ans = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {

        // Build graph
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            map.putIfAbsent(from, new PriorityQueue<>());
            map.get(from).offer(to);
        }

        dfs("JFK");

        return ans;
    }

    private void dfs(String airport) {

        PriorityQueue<String> pq = map.get(airport);

        while (pq != null && !pq.isEmpty()) {

            String next = pq.poll();

            dfs(next);
        }

        ans.addFirst(airport);
    }
}
