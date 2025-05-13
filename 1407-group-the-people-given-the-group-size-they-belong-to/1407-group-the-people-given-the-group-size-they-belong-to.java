class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int n = groupSizes.length;
        // Map from group size to the current assembling group
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        
        for (int person = 0; person < n; person++) {
            int size = groupSizes[person];
            // Get or create the list for this size
            List<Integer> group = map.computeIfAbsent(size, k -> new ArrayList<>());
            group.add(person);
            // Once we've reached the required size, emit it
            if (group.size() == size) {
                result.add(new ArrayList<>(group));
                group.clear();  // start a fresh group for this size
            }
        }
        
        return result;
    }
}
