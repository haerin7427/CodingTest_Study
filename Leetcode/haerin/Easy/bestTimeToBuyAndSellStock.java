package Leetcode.haerin.Easy;
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
// title : 121. Best Time to Buy and Sell Stock
// type : Greedy(?)
// time : 5m
// Created by haerin on 2023-05-18
public class bestTimeToBuyAndSellStock {
    class Solution {
        public int maxProfit(int[] prices) {
            int min_price = 10000;
            int max_profit = 0;
    
            for(int price : prices) {
                if(price < min_price) {
                    min_price = price;
                }
                if(max_profit < price - min_price) {
                    max_profit = price - min_price;
                }
            }
            return max_profit;
        }
    }
}
