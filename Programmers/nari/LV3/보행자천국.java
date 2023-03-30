// https://school.programmers.co.kr/learn/courses/30/lessons/1832
// title : 보행자 천국

public class 보행자천국 {
    class Solution {
        int MOD = 20170805;
        
        public int solution(int m, int n, int[][] cityMap) {
            // 0 - 하, 1 - 우 방향 저장
            // [i][j]에서 오른쪽과 아래쪽으로 이동할 수 있는 경우의 수
            int[][][] dp = new int[m + 1][n + 1][2];
            
            dp[1][1][0] = dp[1][1][1] = 1;
            
            // row
            for(int i=1;i<=m;i++) {
                // column
                for(int j=1;j<= n;j++) {
                    // 자동차가 자유롭게 지나갈 수 있는 경우
                    if(cityMap[i-1][j-1] == 0) {
                        dp[i][j][0] += (dp[i-1][j][0] + dp[i][j-1][1]) % MOD;
                        dp[i][j][1] += (dp[i-1][j][0] + dp[i][j-1][1]) % MOD;
                    } 
                    // 자동차 통행이 금지되어 지나갈 수 없는 경우
                    else if(cityMap[i-1][j-1] == 1) {
                        dp[i][j][0] = 0;
                        dp[i][j][1] = 0;
                    } 
                    // 보행자 안전을 위해 좌회전이나 우회전이 금지되는 경우
                    else {
                        dp[i][j][0] = dp[i-1][j][0];
                        dp[i][j][1] = dp[i][j-1][1];
                    }
                }
            }
            
            // 도착점은 무조건 0이기 때문에 dp[m][n][0] == dp[m][n][1]
            return dp[m][n][0];
        }
    }
}