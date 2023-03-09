// https://school.programmers.co.kr/learn/courses/30/lessons/86052
// title : 빛의 경로 사이클

import java.util.*;

public class 빛의경로사이클 {
    class Solution {
        // 가로, 세로 크기
        int w, h;  
        // 상 우 하 좌
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};
        boolean[][][] visited;
        
        public int[] solution(String[] grid) {
            w = grid[0].length();
            h = grid.length;
            visited = new boolean[h][w][4];
            ArrayList<Integer> list = new ArrayList<>();
            
            for(int i=0;i<h;i++) {
                for(int j=0;j<w;j++) {
                    for(int k=0;k<4;k++) {
                        if(!visited[i][j][k]) list.add(light(grid, i, j, k));
                    }
                }
            }
            
            int[] answer = new int[list.size()];
            
            for(int i=0;i<list.size();i++) {
                answer[i] = list.get(i);
            }
            
            Arrays.sort(answer);
            
            return answer;
        }
        
        // 행, 열, 방향
        int light(String[] grid, int y, int x, int d) {
            // 이동 거리
            int cnt = 0;
    
            while(!visited[y][x][d]) {
                cnt++;
                visited[y][x][d] = true;
                
                // 방향이 음수가 되거나 3을 넘어가면 보정
                // 우회전 -> 시계 방향 회전
                if(grid[y].charAt(x) == 'R')
                    d = (d+1) < 0 ? 3 : (d+1) % 4;
                // 좌회전 -> 반시계 방향 회전
                else if(grid[y].charAt(x) == 'L') 
                    d = (d-1) < 0 ? 3 : (d-1) % 4;  

                // 다음 방문할 위치 계산 -> d의 방향으로 또 한 칸 이동
                // 각 행과 열의 길이를 더한 다음에, 그 길이로 다시 나눈 나머지로 바꾸면,
                // 배열을 벗어나는 좌표에 대해 처리 가능
                x = (x + dx[d] + w) % w;    
                y = (y + dy[d] + h) % h; 
            }
    
            return cnt;
        }
    }
}