// https://school.programmers.co.kr/learn/courses/30/lessons/60063
// title : 블록 이동하기
// DFS는 구현이 간단하지만, 최소 시간을 구할 때는 적합하지 않다. 
// 따라서, Depth(Time)을 확인할 수 있는 BFS 선택

import java.util.*;

public class 블록이동하기 {
    class Solution {
        class Robot{
            int x1, y1;
            int x2, y2;
            // 0 = 세로, 1 = 가로
            int dir;
            // 걸린 시간
            int time;
            
            Robot(int x1, int y1, int x2, int y2, int dir, int time) {
                this.x1 = x1;
                this.y1 = y1;
                this.x2 = x2;
                this.y2 = y2;
                this.dir = dir;
                this.time = time;
            }
        }
        
        public int solution(int[][] board) {
            int n = board.length;
            int answer = Integer.MAX_VALUE;
            int[][] op = {{1,0}, {-1,0}, {0,1}, {0,-1}};
            Queue<Robot> queue = new LinkedList<>();
            boolean visited[][][] = new boolean[n][n][2];
            
            queue.add(new Robot(0, 0, 0, 1, 0, 0));
            
            while(!queue.isEmpty()) {
                // 현재 로봇
                Robot cur = queue.poll();
                
                // 지도를 벗어난 경우
                if(cur.x1 < 0 || cur.x1 >= n || cur.y1 < 0 || cur.y1 >= n || cur.x2 < 0 || cur.x2 >= n || cur.y2 < 0 || cur.y2 >= n) continue;
                
                // 벽인 경우
                if(board[cur.x1][cur.y1] == 1 || board[cur.x2][cur.y2] == 1) continue;
                
                // 이미 방문한 경우
                if(visited[cur.x1][cur.y1][cur.dir] && visited[cur.x2][cur.y2][cur.dir]) continue;
                
                // 로봇이 목적지에 도착한 경우
                if((cur.x1 == n-1 && cur.y1 == n-1) || (cur.x2 == n-1 && cur.y2 == n-1)) {
                    answer = cur.time;
                    break;
                }
                
                visited[cur.x1][cur.y1][cur.dir] = true;
                visited[cur.x2][cur.y2][cur.dir] = true;
                
                // 이동
                for(int i=0;i<4;i++) {
                    int nx1 = cur.x1 + op[i][0];
                    int ny1 = cur.y1 + op[i][1];
                    int nx2 = cur.x2 + op[i][0];
                    int ny2 = cur.y2 + op[i][1];
    
                    queue.add(new Robot(nx1, ny1, nx2, ny2, cur.dir, cur.time+1));
                }
                
                // 가로 방향에서 회전
                if(cur.dir == 1) {
                    // 아래로 회전할 때, y가 지도를 넘어가지 않고, 회전할 위치가 빈칸인 경우
                    if(cur.y1-1 >= 0 && board[cur.x1][cur.y1-1] == 0 && board[cur.x2][cur.y2-1] == 0) {
                        queue.add(new Robot(cur.x1, cur.y1, cur.x1, cur.y1-1, 0, cur.time+1));
                        queue.add(new Robot(cur.x2, cur.y2, cur.x2, cur.y2-1, 0, cur.time+1));
                    }
                    
                    // 위로 회전할 때, y가 지도를 넘어가지 않고, 회전할 위치가 빈칸인 경우
                    if(cur.y1+1 <= (n-1) && board[cur.x1][cur.y1+1] == 0 && board[cur.x2][cur.y2+1] == 0) {
                        queue.add(new Robot(cur.x1, cur.y1, cur.x1, cur.y1+1, 0, cur.time+1));
                        queue.add(new Robot(cur.x2, cur.y2, cur.x2, cur.y2+1, 0, cur.time+1));                    
                    }
                }
                // 세로 방향에서 회전
                else {
                    // 아래로 회전할 때, x가 지도를 넘어가지 않고, 회전할 위치가 빈칸인 경우
                    if(cur.x1-1 >= 0 && board[cur.x1-1][cur.y1] == 0 && board[cur.x2-1][cur.y2] == 0) {            
                        queue.add(new Robot(cur.x1, cur.y1, cur.x1-1, cur.y1, 1, cur.time+1));
                        queue.add(new Robot(cur.x2, cur.y2, cur.x2-1, cur.y2, 1, cur.time+1));
                    }
                    
                    // 위로 회전할 때, x가 지도를 넘어가지 않고, 회전할 위치가 빈칸인 경우
                    if(cur.x1+1 <= (n-1) && board[cur.x1+1][cur.y1] == 0 && board[cur.x2+1][cur.y2] == 0) {
                        queue.add(new Robot(cur.x1, cur.y1, cur.x1+1, cur.y1, 1, cur.time + 1));
                        queue.add(new Robot(cur.x2, cur.y2, cur.x2+1, cur.y2, 1, cur.time + 1));    
                    }
                }
            }
            
            return answer;
        }
    }
}