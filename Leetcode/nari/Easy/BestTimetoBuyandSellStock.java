// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
// title : 121. Best Time to Buy and Sell Stock
// time taken : 6 m 6 s

public class BestTimetoBuyandSellStock {
    // Time Limit Exceeded
    class Solution1 {
        public int maxProfit(int[] prices) {
            int len = prices.length;
            int profit = 0;

            // i = buy, j = sell
            for(int i=0;i<len;i++) {
                for(int j=i+1;j<len;j++) {
                    // 사는 값이 파는 값보다 큰 경우
                    if(prices[i] > prices[j]) continue;

                    profit = Math.max(profit, prices[j] - prices[i]);
                }
            }

            return profit;
        }
    }

    // Memory : 59.1 MB vs 59.3 MB -> 큰 차이 없어 보임
    class Solution2 {
        public int maxProfit(int[] prices) {
            int len = prices.length;
            int profit = 0;
            int min = Integer.MAX_VALUE;
            // int p = 0;
            
            for(int i=0;i<len;i++) {
                min = Math.min(min, prices[i]);
                // if(prices[i] < min) min = prices[i];

                profit = Math.max(profit, prices[i] - min);
                // p = prices[i] - min;
                // if(profit < p) profit = p;
            }

            return profit;
        }
    }
}
