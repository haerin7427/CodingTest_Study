// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
// title : 122. Best Time to Buy and Sell Stock II
// time taken : 

public class BestTimetoBuyandSellStockII {
    class Solution {
        public int maxProfit(int[] prices) {
            int profit = 0, min = Integer.MAX_VALUE;
            int len = prices.length;

            for(int i=0;i<len;i++) {
                min = Math.min(min, prices[i]);

                // min 값이 현재 prices가 아닌 경우
                if(prices[i] - min > 0) {
                    profit += prices[i] - min;
                    min = prices[i];
                }
            }

            return profit;
        }
    }
}
