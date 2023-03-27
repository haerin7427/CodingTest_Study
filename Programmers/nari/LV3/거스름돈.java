// https://school.programmers.co.kr/learn/courses/30/lessons/12907
// title : 거스름돈
// DP 대표적인 문제 -> "1,000,000,007로 나눈 나머지"

public class 거스름돈 {
    class Solution {
        public int solution(int n, int[] money) {
            long[] dp = new long[n+1];
        
            // 초기화 - 돈 한개 지불
            for(int i=0;i<=n;i++) {
                if(i % money[0] == 0) dp[i] = 1;
            }
            
            // 보유하고 있는 돈의 종류별로 for문
            for(int i=1;i<money.length;i++) {
                for(int j=money[i];j<=n;j++) {
                    // 화폐 이전까지의 합 + 새로운 화폐
                    dp[j] += dp[j-money[i]];
                }
            }
            
            return (int)(dp[n] % 1000000007);
        }
    }
}