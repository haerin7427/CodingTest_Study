// https://school.programmers.co.kr/learn/courses/30/lessons/43105
// title : 정수 삼각형

public class 정수삼각형 {
    class Solution1 {
        public int solution(int[][] triangle) {
            int answer = 0;
            int[][] dp = new int[triangle.length][triangle.length];
            
            dp[0][0] = triangle[0][0];
            
            for(int i=1;i<triangle.length;i++) {
                // 제일 왼쪽
                dp[i][0] = dp[i-1][0] + triangle[i][0];
                
                // 가운데 값들
                for(int j=1;j<=i;j++) {
                    // 위에 왼쪽, 오른쪽 값들 중에서 더 큰 값으로
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + triangle[i][j];
                }
                
                // 제일 오른쪽
                dp[i][i] = dp[i-1][i-1] + triangle[i][i];
            }
            
            for(int i=0;i<triangle.length;i++) {
                // 모든 값을 더한 배열에서 마지막 라인 중, 가장 큰 값
                answer = Math.max(answer, dp[triangle.length-1][i]);
            }
            
            return answer;
        }
    }

    class Solution2 {
        public int solution(int[][] triangle) {
            int answer = 0;
            int len = triangle.length;
            int[][] dp = new int[len][len];
            
            dp[0][0] = triangle[0][0];
            
            for(int i=1;i<len;i++) {
                dp[i][0] = dp[i-1][0] + triangle[i][0];
                
                for(int j=1;j<=i;j++) {
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
                }
                
                dp[i][i] = dp[i-1][i-1] + triangle[i][i];
            }
            
            for(int i=0;i<len;i++) {
                answer = Math.max(answer, dp[len-1][i]);
            }
            
            return answer;
        }
    }
}