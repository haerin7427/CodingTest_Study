// https://school.programmers.co.kr/learn/courses/30/lessons/42898
// title : 등굣길

public class 등굣길 {
    class Solution1 {
        public int solution(int m, int n, int[][] puddles) {
            int[][] dp = new int[n][m];
            
            for(int[] puddle : puddles) {
                dp[puddle[1]-1][puddle[0]-1] = -1;
            }
            
            dp[0][0] = 1;
            
            for(int i=0;i<n;i++) {
                for(int j=0;j<m;j++) {
                    // 물에 잠긴 지역이 아닐 경우
                    if(dp[i][j] != -1) {
                        // 아래쪽으로 이동
                        if(i != 0 && dp[i-1][j] != -1) dp[i][j] += dp[i-1][j];
                        // 오른쪽으로 이동
                        if(j != 0 && dp[i][j-1] != -1) dp[i][j] += dp[i][j-1];
                        
                        dp[i][j] %= 1000000007;
                    }
                }
            }
            
            return dp[n-1][m-1];
        }
    }

    class Solution2 {
        public int solution(int m, int n, int[][] puddles) {
            int[][] dp = new int[n+1][m+1];
            
            // 물에 잠긴 지역
            for(int[] puddle : puddles) {
                dp[puddle[1]][puddle[0]] = -1;
            }
            
            // 처음 위치
            dp[1][1] = 1;
            
            for(int i=1;i<=n;i++) {
                for(int j=1;j<=m;j++) {
                    // 물에 잠긴 지역이 아닐 경우
                    if(dp[i][j] != -1) {
                        // 아래쪽으로 이동
                        if(i != 1 && dp[i-1][j] != -1) dp[i][j] += dp[i-1][j];
                        // 오른쪽으로 이동
                        if(j != 1 && dp[i][j-1] != -1) dp[i][j] += dp[i][j-1];
                        
                        dp[i][j] %= 1000000007;
                    }
                }
            }

            return dp[n][m];
        }
    }
}