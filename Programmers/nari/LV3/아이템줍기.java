// https://school.programmers.co.kr/learn/courses/30/lessons/87694
// title : 아이템 줍기

import java.util.*;

public class 아이템줍기 {
    // 1. 맵 크기를 2배로 확장한 다음 맵 바운더리 BFS탐색하기
    // 2. 맵에 상,하,좌,우를 기록한 다음 모든 조건분기별로 나눠서 방향 탐색하기
    
    class Solution {
        int answer = Integer.MAX_VALUE;
        // 맵 크기 2배 확장 
        //   -> 꺾이는 코너 부분에서 쉽게 계산하기 위해, 입력되는 좌표는 1~50이지만 2배로 확장해서 그려줄 것
        int[][] map = new int[101][101];
        
        public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
            // 좌표에 따라 map에 값을 넣을건데, 테두리에만 1을 넣을것이다.(*좌표는 두배로)
            // map에 값 넣기 -> 테두리일 경우 1, 도현 내부일 경우 2
            for(int[] rec : rectangle) {
                int x1 = rec[0] * 2, y1 = rec[1] * 2;
                int x2 = rec[2] * 2, y2 = rec[3] * 2;

                for(int i=x1;i<=x2;i++) {
                    for(int j=y1;j<=y2;j++) {
                        // 도형에 겹쳐진 선일 경우
                        if(map[i][j] == 2) continue;
                        
                        // 해당 좌표가 테두리에 걸쳐져 있는 경우
                        if(i == x1 || i == x2 || j == y1 || j == y2) map[i][j] = 1;
                        // 도형 내부일 경우
                        else map[i][j] = 2;
                    }
                }
            }
            
            // bfs로 테두리 따라 양쪽으로 가보고 min값 채택
            bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
            
            // 좌표에 *2 해주었기 때문에 /2 필요
            return answer / 2;
        }
        
        public void bfs(int characterX, int characterY, int itemX, int itemY) {
            boolean[][] visited= new boolean[101][101];
            int[] dx= {-1, 0, 0, 1};
            int[] dy= {0, -1, 1, 0};
            Queue<int[]> queue= new LinkedList<>();
            queue.add(new int[]{characterX, characterY});
            
            while(!queue.isEmpty()) {
                int[] val = queue.poll();
                int x = val[0];
                int y = val[1];
                
                for(int i=0;i<4;i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    
                    // 지도 범위를 벗어난 경우
                    if(nx < 0 || ny < 0 || nx > 100 || ny > 100) continue;
                    // 테두리가 아니거나 이미 방문한 경우
                    if(map[nx][ny] != 1 || visited[nx][ny]) continue;
                    
                    map[nx][ny] = map[x][y] + 1;
                    
                    // 아이템 위치에 도착한 경우
                    if(nx == itemX && ny == itemY) {
                        answer = Math.min(answer, map[nx][ny]);
                        continue;
                    }
                    
                    visited[nx][ny]= true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}