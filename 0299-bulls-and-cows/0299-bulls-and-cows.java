class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        // counts[d] > 0 means we've seen extra d's in secret
        // counts[d] < 0 means we've seen extra d's in guess
        int[] counts = new int[10];
        
        for (int i = 0; i < secret.length(); i++) {
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i)  - '0';
            if (s == g) {
                // exact match
                bulls++;
            } else {
                // if guess digit g had surplus in secret before, match as cow
                if (counts[g] > 0) {
                    cows++;
                }
                // if secret digit s had surplus in guess before, match as cow
                if (counts[s] < 0) {
                    cows++;
                }
                // record current surplus
                counts[s]++;
                counts[g]--;
            }
        }
        
        return bulls + "A" + cows + "B";
    }
}
