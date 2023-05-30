package Leetcode.haerin.Medium;
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
// title : 122. Best Time to Buy and Sell Stock II
// type : DP
// time : 12m
// Created by haerin on 2023-05-30
public class bestTimeToBuyAndSellStock2 {
    class Solution {
        public int maxProfit(int[] prices) {
            int profit = 0;
            int minPrice = Integer.MAX_VALUE;
            for (int i = 0; i < prices.length; i++) {
                minPrice = Math.min(minPrice, prices[i]);
                if (prices[i] - minPrice > 0) {
                    profit += prices[i] - minPrice;
                    minPrice = prices[i];
                }
            }
            return profit;
        }
    }
}
