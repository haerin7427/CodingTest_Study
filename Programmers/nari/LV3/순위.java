// https://school.programmers.co.kr/learn/courses/30/lessons/49191
// title : 순위

public class 순위 {
    // 플로이드 와샬 알고리즘
    class Solution {
        public int solution(int n, int[][] results) {
            int answer = 0;
            // 이긴 경우, 1을 저장. 진 경우, -1을 저장
            int[][] floyd = new int[n+1][n+1];
            
            for(int[] result : results) {
                int A = result[0], B = result[1];
                
                // A 선수가 B 선수를 이겼다는 의미
                floyd[A][B] = 1; 
                floyd[B][A] = -1; 
            }
            
            for(int i=1;i<= n;i++) {
                for(int j=1;j<= n;j++) {
                    for(int k=1;k<= n;k++) {
                        // A 선수가 B 선수를 이기고, B 선수가 C 선수를 이길 경우, A 선수는 C 선수를 이겼다고 판단
                        if(floyd[i][k] == 1 && floyd[k][j] == 1) {
                            floyd[i][j] = 1;
                            floyd[j][i] = -1;
                        }
                        
                        // A 선수가 B 선수를 지고, B 선수가 C 선수를 질 경우, A 선수는 C 선수에게 졌다고 판단
                        if(floyd[i][k] == -1 && floyd[k][j] == -1){
                            floyd[i][j] = -1;
                            floyd[j][i] = 1;
                        }
                    }
                }
            }
            
            // 선수의 순위를 매기기 위해서, n명의 선수가 있을 때 각 선수 별로 n-1개의 승패 결과 필요
            for(int i=1;i<=n;i++) {
                int cnt = 0; 
                
                for(int j=1;j<=n;j++) {
                    if(floyd[i][j] != 0) cnt++;
                }
                
                if(cnt == n-1) answer++;
            }
            
            return answer;
        }
    }
}