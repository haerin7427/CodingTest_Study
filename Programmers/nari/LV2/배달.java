// https://school.programmers.co.kr/learn/courses/30/lessons/12978
// title : 배달

public class 배달 {
    class Solution {
        public int solution(int N, int[][] road, int K) {
            int answer = 0;
            
            // 전형적인 다익스트라 문제
            // <다익스트라 알고리즘 구현>
            // 1. 1번 마을에서 다른 마을까지의 거리에 대한 정보가 담긴 dist[] 선언 후, 초기화 
            //   - 경로가 존재하면 해당 weight를, 존재하지 않으면 무한대(500001) 값으로 초기화
            //   - 500001 = 최대 노드 개수 = 최대 N (50) * 최대 경로 (10,000) + 1
            // 2. 다른 마을을 방문했는지 여부 체크 위한 visited[] 선언
            // 3. dist[]에서 시작점을 제외한 값이 가장 작은 마을의 index 구하기 (EXTRACT-MIN)
            // 4. 해당 index를 visited 처리 한 뒤, 그 index의 마을을 거쳐가는 경로가 원래 dist[]에 들어있는 값보다 작으면 값 변경
            // 5. 3~4번을 n-1번 반복한다.

            int[][] map = new int[N+1][N+1];
            
            // 무한대로 초기화
            for(int i=1;i<=N;i++) {
                for(int j=1;j<=N;j++) {
                    if(i==j) continue;
                    map[i][j] = 500001;
                }
            }
            
            // 경로 저장
            for(int i=0;i<road.length;i++) {
                // 마을 번호 1
                int a = road[i][0];
                // 마을 번호 2
                int b = road[i][1];
                // 두 마을의 연결 도로를 지나는데 걸리는 시간
                int w = road[i][2];

                if (map[a][b] > w) {
                    map[a][b] = w;
                    map[b][a] = w;
                }
            }
            
            // 1번 마을에서 각 마을 이동 거리
            int[] dist = new int[N+1];
            
            for(int i=2;i<=N;i++) {
                // 1번 마을에서 배달이 가능한 마을 개수이기 때문에
                dist[i] = dist[i]==0 ? 500001 : map[1][i];
            }
            
            boolean[] visited = new boolean[N+1];
            visited[1] = true;
            
            // EXTRACT-MIN
            // Priority Queue를 사용하고, 경로 정보를 인접리스트로 구현하면 좀 더 효율적
            for(int i=1;i<N;i++) {
                int min_idx = 1;
                int min_value = 500001;
                
                // dist 중에 방문하지 않았고 가장 작은 값을 가지는 인덱스를 찾기
                for(int j=2;j<=N;j++) {
                    if(!visited[j] && dist[j] < min_value) {
                        min_value = dist[j];
                        min_idx = j;
                    }
                }

                // 방문 체크
                visited[min_idx] = true;

                // 1번 마을에서 바로 가기 vs 다른 마을 거쳐가기 -> 더 빠른지 비교
                for(int j=2;j<=N;j++) {
                    if(dist[j] > dist[min_idx] + map[min_idx][j])
                        dist[j] = dist[min_idx] + map[min_idx][j];
                }
            }
            
            for(int i=1;i<=N;i++) {
                if(dist[i] <= K) answer++;
            }

            return answer;
        }
    }
}