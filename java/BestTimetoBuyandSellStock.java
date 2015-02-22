public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int minPrices = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            minPrices = Math.min(prices[i], minPrices);
            profit = Math.max(profit, prices[i] - minPrices);
        }
        return profit;
    }
}
