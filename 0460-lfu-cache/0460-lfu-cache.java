import java.util.*;

class LFUCache {
    private final int capacity;
    private int minFreq;
    
    // key → value
    private final Map<Integer, Integer> keyToVal;
    // key → freq
    private final Map<Integer, Integer> keyToFreq;
    // freq → keys in insertion order (to evict LRU on tie)
    private final Map<Integer, LinkedHashSet<Integer>> freqToKeys;

    public LFUCache(int capacity) {
        this.capacity   = capacity;
        this.minFreq    = 0;
        this.keyToVal   = new HashMap<>(capacity);
        this.keyToFreq  = new HashMap<>(capacity);
        this.freqToKeys = new HashMap<>();
    }
    
    public int get(int key) {
        if (!keyToVal.containsKey(key)) return -1;
        // increase its frequency
        bumpFreq(key);
        return keyToVal.get(key);
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;
        
        if (keyToVal.containsKey(key)) {
            // update value, then bump freq
            keyToVal.put(key, value);
            bumpFreq(key);
            return;
        }
        
        // if at capacity, evict one LFU key
        if (keyToVal.size() >= capacity) {
            // from the minFreq bucket, remove the oldest key
            LinkedHashSet<Integer> minFreqKeys = freqToKeys.get(minFreq);
            int evictKey = minFreqKeys.iterator().next();
            minFreqKeys.remove(evictKey);
            if (minFreqKeys.isEmpty()) {
                freqToKeys.remove(minFreq);
            }
            keyToVal.remove(evictKey);
            keyToFreq.remove(evictKey);
        }
        
        // insert new key with freq = 1
        keyToVal.put(key, value);
        keyToFreq.put(key, 1);
        freqToKeys
            .computeIfAbsent(1, ignore -> new LinkedHashSet<>())
            .add(key);
        minFreq = 1;  // new key is the new LFU
    }
    
    // helper to move key from freq → freq+1
    private void bumpFreq(int key) {
        int freq = keyToFreq.get(key);
        // remove from old freq bucket
        LinkedHashSet<Integer> keys = freqToKeys.get(freq);
        keys.remove(key);
        if (keys.isEmpty()) {
            freqToKeys.remove(freq);
            // if this was the minFreq, we’ve raised it
            if (freq == minFreq) {
                minFreq++;
            }
        }
        
        // add to new freq bucket
        int newFreq = freq + 1;
        keyToFreq.put(key, newFreq);
        freqToKeys
            .computeIfAbsent(newFreq, ignore -> new LinkedHashSet<>())
            .add(key);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */