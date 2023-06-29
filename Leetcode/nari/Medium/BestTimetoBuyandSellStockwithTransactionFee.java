// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
// title : 714. Best Time to Buy and Sell Stock with Transaction Fee
// time taken : 

public class BestTimetoBuyandSellStockwithTransactionFee {
    class Solution {
        public int maxProfit(int[] prices, int fee) {
            int buy = Integer.MIN_VALUE, sell = 0;

            for(int price : prices) {
                buy = Math.max(buy, sell - price);
                sell = Math.max(sell, buy + price - fee);
            }

            return sell;
        }
    }
}
