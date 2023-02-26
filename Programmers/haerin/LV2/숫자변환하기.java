package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/154538
// title : 숫자 변환하기
// type : DP
// time : ...
// Created by haerin on 2023-02-25
public class 숫자변환하기 {
    class Solution {
        private static final int MAX = Integer.MAX_VALUE;
        public int solution(int x, int y, int n) {
            int[] dp = new int[y+1];
            
            for(int i=x+1; i<dp.length; i++){
                int case1=MAX, case2=MAX, case3=MAX, min;
                
                if(isPossible(i-n, x)) {
                    case1 = dp[i-n];
                }
                if(isNatural(i,2) && isPossible(i/2, x)) {
                    case2 = dp[i/2];
                }
                if(isNatural(i,3) && isPossible(i/3, x)) {
                    case3 = dp[i/3];
                }
                
                min = Math.min(case1, case2);
                min = Math.min(min, case3);
                
                dp[i] = (min < MAX) ? min+1 : MAX;;
            }
            
            return (dp[y] < MAX) ? dp[y] : -1;
        }
        
        private boolean isPossible(int num, int x){
            return (num >= x);
        }
        
        private boolean isNatural(int num, int divide){
            return (num / divide > 0 && num % divide == 0);
        }
    }
}
