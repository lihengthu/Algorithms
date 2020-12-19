// Greedy
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int minprice = Integer.MAX_VALUE, profit = 0;
        for (int price : prices) {
            minprice = price < minprice ? price : minprice;
            profit = (price - minprice) > profit ? price - minprice : profit;
        }

        return profit;
    }
}
