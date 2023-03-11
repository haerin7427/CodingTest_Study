// https://school.programmers.co.kr/learn/courses/30/lessons/72413
// title : 합승 택시 요금

public class 합승택시요금 {
    // 플로이드-워셜 알고리즘
    class Solution {
        public int solution(int n, int s, int a, int b, int[][] fares) {
            // 단순 시작점 s 에서 a지점과 b지점까지 각각의 최단거리 계산 == 다익스트라 알고리즘
            // 모든 정점에서 모든 정점까지 최단거리 계산 == 플로이드-워셜 알고리즘
            // (같은 택시로 이동하다가 특정 경유지에서 다른 택시를 나누어서 타 이동하는 경우의 수 존재)
            
            // 최저 요금을 return 해야하기 때문에 -> 요금은 100,000 이하인 자연수 * 지점 갯수 200 +1
            int answer = 20000001;
            int[][] map = new int[n][n];
            
            // 최소 금액을 찾아야 하기 때문에 요금 최대값으로 초기화
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    if(i == j) continue;
                    
                    map[i][j] = 20000001;
                }
            }
            
            for(int i=0;i<fares.length;i++) {
                int c = fares[i][0], d = fares[i][1], f = fares[i][2];
                
                // c지점과 d지점 사이 택시요금
                map[c-1][d-1] = f;
                map[d-1][c-1] = f;
            }
            
            // 플로이드-워셜 알고리즘
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    for(int k=0;k<n;k++) {
                        // 직행과 경유했을 때, 택시 요금 비교해서 더 작은 값
                        map[j][k] = Math.min(map[j][k], map[j][i] + map[i][k]);
                    }
                }
            }
            
            // 최소 금액이 나오는 경유지 찾기
            for(int i=0;i<n;i++) {
                answer = Math.min(answer, map[s-1][i] + map[i][a-1] + map[i][b-1]);
            }
            
            return answer;
        }
    }
}