class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length, ans = 0;
        // For each middle soldier j, count how many i<j are lower/higher
        // and how many k>j are higher/lower to form increasing or decreasing teams.
        for (int j = 0; j < n; j++) {
            int smallerLeft = 0, largerLeft = 0;
            for (int i = 0; i < j; i++) {
                if (rating[i] < rating[j]) smallerLeft++;
                else if (rating[i] > rating[j]) largerLeft++;
            }
            int smallerRight = 0, largerRight = 0;
            for (int k = j + 1; k < n; k++) {
                if (rating[k] < rating[j]) smallerRight++;
                else if (rating[k] > rating[j]) largerRight++;
            }
            // increasing: pick smaller on left and larger on right
            // decreasing: pick larger on left and smaller on right
            ans += smallerLeft * largerRight + largerLeft * smallerRight;
        }
        return ans;
    }
}
