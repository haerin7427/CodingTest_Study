// https://school.programmers.co.kr/learn/courses/30/lessons/159993
// title : 미로 탈출

import java.util.*;

public class 미로탈출 {
    class Solution {
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};
        
        public int solution(String[] maps) {
            // 시작~레버, 레버~출구
            int len1 = bfs('S', 'L', maps);
            int len2 = bfs('L', 'E', maps);
            
            return len1 == -1 || len2 == -1 ? -1 : len1+len2;
        }
        
        int bfs(char start, char end, String[] maps) {
            Queue<int[]> queue = new LinkedList<>();
            boolean[][] visited = new boolean[maps.length][maps[0].length()];
            
            for(int i=0;i<maps.length;i++) {
                for(int j=0;j<maps[0].length();j++) {
                    if(maps[i].charAt(j) == start) {
                        queue.add(new int[]{i, j, 0});
                        visited[i][j] = true;
                        break;
                    }
                }
                if(!queue.isEmpty()) break;
            }
            
            while(!queue.isEmpty()) {
                int[] point = queue.poll();
                
                // end point인 경우 (레버 or 출구)
                if(maps[point[0]].charAt(point[1]) == end) return point[2];
                
                for(int i=0;i<4;i++) {
                    int ny = point[0] + dy[i];
                    int nx = point[1] + dx[i];
                    
                    // 미로 크기를 넘지 않고, 방문한 적 없으며, 벽이 아닌 경우
                    if(0 <= ny && ny < maps.length && 0 <= nx && nx < maps[0].length() && !visited[ny][nx] && maps[ny].charAt(nx) != 'X') {
                        queue.add(new int[]{ny, nx, point[2]+1});
                        visited[ny][nx] = true;
                    }
                }
            }
            
            return -1;
        }
    }
}