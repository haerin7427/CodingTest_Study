// https://school.programmers.co.kr/learn/courses/30/lessons/1837
// title : GPS

public class GPS {
    class Solution {
        public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
            // 0번째와 1번째가 연결되어 있다면 1 아니면 0
            int[][] road = new int[n+1][n+1];
            
            for(int i=0;i<m;i++) {
                int s = edge_list[i][0], e = edge_list[i][1];
                
                road[s][e] = 1;
                road[e][s] = 1;
            }
            
            // 머물렀던 거점 정보 gps_log, 거점 개수 n
            // 현재 머무르고 있는 거점 -> 이동할 다음 거점
            int[][] dp = new int[k][n+1];
            
            // 최솟값을 구해야 하므로 최댓값으로 초기화
            for(int i=0;i<k;i++) {
                for(int j=0;j<n+1;j++) {
                    dp[i][j] = 99999999; // Integer.MAX_VALUE;
                }
            } 
            
            // 맨 첫번째 값은 정해진 값이기 때문에 0번째 인덱스에는 gps_log[0]의 값
            dp[0][gps_log[0]] = 0;
            
            for(int i=1;i<k;i++) {
                // 1번째부터 n번째 노드까지 하나씩 확인 
                for(int j=1;j<n+1;j++) {
                    // 이동을 하지 않았다고 판단하고, 이전 값과 비교해서 값 갱신
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j]);
                    
                    // 이동할 경우
                    for(int node=1;node<n+1;node++) {
                        // j노드와 연결된 노드일 경우, 그 노드들로부터 j로 가는 모든 경우 확인
                        // 이전에서 j로 이동 값과 이전에서 node로 이동 값 비교 
                        if(road[j][node] == 1)
                            dp[i][j] = Math.min(dp[i][j], dp[i-1][node]);
                    }
                    
                    // 이동할 다음 거점이 j가 아닌 경우 -> 수정해야 한다고 판단 -> 값 증가
                    if(j != gps_log[i]) dp[i][j]++;
                }
            }
            
            // 값이 변경된 경우 -> 오류 수정 가능할 경우로 판단 
            if(dp[k-1][gps_log[k-1]] != 99999999)
                return dp[k-1][gps_log[k-1]];
            else return -1;
        }
    }
}