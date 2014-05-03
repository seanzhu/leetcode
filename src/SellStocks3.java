public class SellStocks3 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        int len = prices.length;
        int[] fromLeft = new int[len];
        int[] fromRight = new int[len];

        int minV = Integer.MAX_VALUE, max = 0;

        for (int i = 0; i < len; i++) {
            if (prices[i] < minV)
                minV = prices[i];
            max = Math.max(max, prices[i] - minV);
            fromLeft[i] = max;
        }

        int maxV = Integer.MIN_VALUE;
        max = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (prices[i] > maxV)
                maxV = prices[i];
            max = Math.max(max, maxV - prices[i]);
            fromRight[i] = max;
        }

        int ret = 0;
        for (int i = 0; i < len; i++) {
            ret = Math.max(ret, fromLeft[i] + fromRight[i]);
        }

        return ret;
    }
}
