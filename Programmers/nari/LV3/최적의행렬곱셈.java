// https://school.programmers.co.kr/learn/courses/30/lessons/12942
// title : 최적의 행렬 곱셈

public class 최적의행렬곱셈 {
    // 연쇄행렬 최소곱셈 알고리즘 -> https://source-sc.tistory.com/24
    class Solution {
        public int solution(int[][] matrix_sizes) {
            int len = matrix_sizes.length;
            int[][] dp = new int[len][len];
            
            // 최대값으로 초기화
            for(int i=0;i<len;i++) {
                for(int j=0;j<len;j++) {
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
            
            for(int i=0;i<len;i++) {
                for(int j=0;j<len-i;j++) {
                    int a = j;
                    int b = j+i;
                    
                    if(a == b) dp[a][b] = 0;
                    else {
                        for(int k=a;k<b;k++) {
                            int first = dp[a][b];
                            int second = dp[a][k] + dp[k+1][b] + matrix_sizes[a][0] * matrix_sizes[k][1] * matrix_sizes[b][1];
                            
                            dp[a][b] = first < second ? first : second;
                        }
                    }
                }
            }
            
            return dp[0][len-1];
        }
    }
}