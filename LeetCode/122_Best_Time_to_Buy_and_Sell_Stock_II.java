// Greedy
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int n = prices.length, profit = 0;
        for (int i = 0; i < n - 1; i++) {
            if (prices[i + 1] - prices[i] > 0) {
                profit += prices[i + 1] - prices[i];
            }
        }

        return profit;
    }
}
