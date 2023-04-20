package Programmers.haerin.LV3;

public class 코딩테스트공부 {
    class Solution {
        public int solution(int alp, int cop, int[][] problems) {
            // 모든 문제를 풀수있는 알고력과 코딩력 값 구하기
            int max_alp=0;
            int max_cop=0;
            for(int[] problem : problems){
                if(problem[0] > max_alp){
                    max_alp = problem[0];
                }
                if(problem[1] > max_cop){
                    max_cop = problem[1];
                }
            }
            if(max_alp <= alp && max_cop <= cop){
                return 0;
            }
            // 이미 조건을 만족하는 경우 필요한 최대값으로 업데이트
            if(alp>=max_alp){
                alp=max_alp;
            }
            if(cop>=max_cop){
                cop=max_cop;
            }

            // dp[i][j] = 알고력 i, 코딩력 j를 갖추기 위해 필요한 최단 시간
            // 알고력 max_alp와, 코딩력 max_cop를 갖추었을 때 연산을 하기 위해 아래와 같이 크기 설정
            int[][] dp = new int[max_alp+2][max_cop+2];
            for(int i=alp;i<=max_alp;i++){
                for(int j=cop;j<=max_cop;j++){
                    dp[i][j]=Integer.MAX_VALUE;
              }
            }
            
            dp[alp][cop] = 0;
            for(int y=alp; y<=max_alp; y++){
                for(int x=cop; x<=max_cop; x++){
                    // 알고력을 키우는 경우
                    dp[y+1][x] = Math.min(dp[y+1][x], dp[y][x]+1);
                    // 코딩력을 키우는 경우
                    dp[y][x+1] = Math.min(dp[y][x+1], dp[y][x]+1);
                    // 문제를 통해 알고력과 코딩력을 키우는 경우
                    for(int[] p : problems){
                        if(p[0] > y || p[1] > x) continue;
                        
                        if(y+p[2]>max_alp&&x+p[3]>max_cop){
                          dp[max_alp][max_cop]=Math.min(dp[max_alp][max_cop],dp[y][x]+p[4]);
                        }
                        else if(y+p[2]>max_alp){
                            dp[max_alp][x+p[3]]=Math.min(dp[max_alp][x+p[3]],dp[y][x]+p[4]);
                        }
                        else if(x+p[3]>max_cop){
                            dp[y+p[2]][max_cop]=Math.min(dp[y+p[2]][max_cop],dp[y][x]+p[4]);
                        }
                        else if(y+p[2]<=max_alp && x+p[3]<=max_cop){
                           dp[y+p[2]][x+p[3]]=Math.min(dp[y+p[2]][x+p[3]],dp[y][x]+p[4]); 
                        }
                    }
                }
            }
            
            return dp[max_alp][max_cop];
        }
    }
}
