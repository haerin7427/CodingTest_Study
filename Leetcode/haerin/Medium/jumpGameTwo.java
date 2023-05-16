package Leetcode.haerin.Medium;
// https://leetcode.com/problems/jump-game-ii/description/
// title : 45. Jump Game II
// type : DP
// time : 20m
// Created by haerin on 2023-05-16
public class jumpGameTwo {
    class Solution {
        public int jump(int[] nums) {
           if(nums.length==1)
               return 0;
           int[] dp = new int[nums.length]; // dp[i] nums 배열의 인덱스 i-1까지 도달하는 최소 점프 수
           dp[0]=0; dp[1]=1;
           for(int i=1;i<nums.length;i++){
               dp[i]=min(i,nums,dp)+1;
           }
           return dp[nums.length-1];
       }
       
       
       private int min(int j,int[] nums,int[] dp)
       {
           int min=Integer.MAX_VALUE;
           for(int i=0;i<j;i++)
           {
               if(nums[i]+i>=j&&dp[i]<min) // j전 인덱스 위치에서 점프하여 j에 도달할 수 있는 것들 중 최소 값 구하기
                   min=dp[i];
           }
           return min;
       }
   }
}
