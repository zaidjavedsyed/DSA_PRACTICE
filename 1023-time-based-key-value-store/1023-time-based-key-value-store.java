class TimeMap {
    // For each key, keep a list of (timestamp, value) in increasing timestamp order
    private Map<String, List<Pair>> map;

    // Simple pair class
    private static class Pair {
        int time;
        String val;
        Pair(int t, String v) { time = t; val = v; }
    }

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map
          .computeIfAbsent(key, k -> new ArrayList<>())
          .add(new Pair(timestamp, value));
        // Because timestamps are guaranteed strictly increasing per key,
        // we can just append.
    }
    
    public String get(String key, int timestamp) {
        List<Pair> list = map.get(key);
        if (list == null) return "";
        
        // Binary‐search for the largest time ≤ timestamp
        int lo = 0, hi = list.size() - 1;
        String ans = "";
        
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (list.get(mid).time == timestamp) {
                return list.get(mid).val;
            }
            if (list.get(mid).time < timestamp) {
                ans = list.get(mid).val;  // candidate
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        
        return ans;
    }
}
