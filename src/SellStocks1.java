public class SellStocks1 {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min)
                min = prices[i];
            int diff = prices[i] - min;
            if (diff > max)
                max = diff;
        }
        return max;
    }


}
