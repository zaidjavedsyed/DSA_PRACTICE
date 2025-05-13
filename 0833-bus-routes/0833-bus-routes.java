class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;
        
        int n = routes.length;
        // Map each stop -> list of bus indices that serve it
        Map<Integer, List<Integer>> stopToBuses = new HashMap<>();
        for (int bus = 0; bus < n; bus++) {
            for (int stop : routes[bus]) {
                stopToBuses
                    .computeIfAbsent(stop, k -> new ArrayList<>())
                    .add(bus);
            }
        }
        
        // BFS over buses: start from all buses at source
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] busVisited = new boolean[n];
        Set<Integer> stopVisited = new HashSet<>();
        
        // enqueue all buses you can take from source
        for (int bus : stopToBuses.getOrDefault(source, Collections.emptyList())) {
            q.offer(bus);
            busVisited[bus] = true;
        }
        stopVisited.add(source);
        
        int busesTaken = 1;  // level in BFS = number of buses taken so far
        while (!q.isEmpty()) {
            int sz = q.size();
            while (sz-- > 0) {
                int bus = q.poll();
                // explore all stops on this bus
                for (int stop : routes[bus]) {
                    if (stop == target) {
                        return busesTaken;
                    }
                    if (stopVisited.add(stop)) {
                        // from this new stop, try all connecting buses
                        for (int nextBus : stopToBuses.getOrDefault(stop, Collections.emptyList())) {
                            if (!busVisited[nextBus]) {
                                busVisited[nextBus] = true;
                                q.offer(nextBus);
                            }
                        }
                    }
                }
            }
            busesTaken++;
        }
        
        return -1;
    }
}
