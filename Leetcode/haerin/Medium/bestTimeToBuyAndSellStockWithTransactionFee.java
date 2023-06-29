package Leetcode.haerin.Medium;
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/
// title : 714. Best Time to Buy and Sell Stock with Transaction Fee
// type : DP
// time : 16m
// created by haerin on 2023-06-29
public class bestTimeToBuyAndSellStockWithTransactionFee {
    class Solution {
        public int maxProfit(int[] prices, int fee) {
            int buy = Integer.MIN_VALUE;   // maximum profit after buying the stock
            int sell = 0;                  // maximum profit after selling the stock
    
            for(int price : prices) {
                buy = Math.max(buy, sell - price); 
                sell = Math.max(sell, buy + price - fee); 
            }
            return sell;
        }
    }
}
