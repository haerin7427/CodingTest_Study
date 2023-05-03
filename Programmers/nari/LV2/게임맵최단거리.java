// https://school.programmers.co.kr/learn/courses/30/lessons/1844
// title : 게임 맵 최단거리

import java.util.*;

public class 게임맵최단거리 {
    class Solution1 {
        // 동, 서, 남, 북 탐색위한 배열
        int[] dx = {0, 0, 1, -1};
        int[] dy = {-1, 1, 0, 0};
        
        public int solution(int[][] maps) {
            int answer = 0;
            // 방문했는지 체크하는 배열 -> 방문 = 1, 미방문 = 0
            int[][] visited = new int[maps.length][maps[0].length];
            
            bfs(maps, visited);
            answer = visited[maps.length - 1][maps[0].length - 1];
            
            return answer == 0 ? -1 : answer;
        }
        
        void bfs(int[][] maps, int[][] visited) {
            // 캐릭터 처음 위치
            visited[0][0] = 1;
            
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0, 0});      
            
            while(!queue.isEmpty()) {
                // 현재 위치
                int[] cur = queue.poll();
                
                // 동, 서, 남, 북 탐색
                for(int i=0;i<4;i++) {
                    // 현재 위치에서 이동 후, 위치
                    int[] next = {cur[0] + dx[i], cur[1] + dy[i]};
                    
                    // 범위를 벗어났을 경우, continue
                    if(next[0] < 0 || next[0] > maps.length-1 || next[1] < 0 || next[1] > maps[0].length-1)
                        continue;
                    
                    // 방문한 적 없고(visited), 갈 수 있는(maps) 경우
                    if(visited[next[0]][next[1]] == 0 && maps[next[0]][next[1]] == 1) {
                        // 방문 체크
                        visited[next[0]][next[1]] = visited[cur[0]][cur[1]] + 1;
                        // 현재 위치 변경
                        queue.add(new int[]{next[0], next[1]});
                    }
                }
                
            }
            
            
        }
    }

    class Solution2 {
        public int solution(int[][] maps) {
            int answer = Integer.MAX_VALUE;
            int n = maps.length, m = maps[0].length;
            int[] dx = {1, -1, 0, 0};
            int[] dy = {0, 0, 1, -1};
            Queue<int[]> queue = new LinkedList<>();
            boolean[][] visited = new boolean[n][m];
            
            // 시작점 좌표 (x, y), 지나온 칸의 개수 (count)
            queue.add(new int[]{0, 0, 0});
            visited[0][0] = true;
            
            while(!queue.isEmpty()) {
                int[] cur = queue.poll();
                
                // 상대 팀 진영에 도착한 경우
                if(cur[0] == n-1 && cur[1] == m-1) {
                    answer = Math.min(answer, cur[2] + 1);
                }
                
                for(int i=0;i<4;i++) {
                    int nx = cur[0] + dx[i];
                    int ny = cur[1] + dy[i];
                    
                    // 게임 맵에서 벗어나거나 벽이거나 이미 방문한 경우
                    if(0 > nx || nx > n-1 || 0 > ny || ny > m-1 || maps[nx][ny] == 0 || visited[nx][ny]) continue;
                    
                    queue.add(new int[]{nx, ny, cur[2]+1});
                    visited[nx][ny] = true;
                }
            }
            
            return answer == Integer.MAX_VALUE ? -1 : answer;
        }
    }
}