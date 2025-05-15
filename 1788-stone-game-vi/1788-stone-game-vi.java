import java.util.Arrays;

public class Solution {
    /**
     * Both play optimally. A known optimal strategy is to pick stones
     * in descending order of (aliceValues[i] + bobValues[i]), since that
     * maximizes the swing in score advantage on each turn.
     */
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        // Create an array of indices 0..n-1
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        // Sort indices by descending total value
        Arrays.sort(idx, (i, j) -> 
            (bobValues[j] + aliceValues[j]) - (bobValues[i] + aliceValues[i])
        );
        
        int scoreDiff = 0;
        for (int turn = 0; turn < n; turn++) {
            int i = idx[turn];
            if ((turn & 1) == 0) {
                // Alice's turn
                scoreDiff += aliceValues[i];
            } else {
                // Bob's turn
                scoreDiff -= bobValues[i];
            }
        }
        
        if (scoreDiff > 0)   return 1;   // Alice wins
        else if (scoreDiff < 0) return -1; // Bob wins
        else                  return 0;   // Draw
    }
}
