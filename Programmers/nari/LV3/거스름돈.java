// https://school.programmers.co.kr/learn/courses/30/lessons/12907
// title : 거스름돈
// DP 대표적인 문제 -> "1,000,000,007로 나눈 나머지"

public class 거스름돈 {
    class Solution1 {
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

    class Solution2 {
        public int solution(int n, int[] money) {
            // 각 index가 n일 때, 거슬러 줄 방법의 수
            long[] dp = new long[n+1];

            for(int i=1;i<money.length;i++) {
                for(int j=0;j<=n;j++) {
                    // 제일 처음에만 실행되도록
                    // money[0]을 사용했을 때, 나누어 떨어지는 경우 -> 무조건 1가지수
                    if(i == 1 && j % money[0] == 0) dp[j] = 1;
                    
                    // 해당 index j를 money만큼 뺐을 때, 경우의 수 더하기
                    if(j >= money[i]) dp[j] += dp[j-money[i]];
                }
            }

            return (int)(dp[n] % 1000000007);
        }
    }
}