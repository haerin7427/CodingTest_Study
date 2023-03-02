// https://school.programmers.co.kr/learn/courses/30/lessons/81302
// title : 거리두기 확인하기

import java.util.*;

public class 거리두기확인하기 {
    class Solution {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};
        
        public int[] solution(String[][] places) {
            int[] answer = new int[places.length];
            
            for(int i=0;i<places.length;i++) {
                answer[i] = isCorrect(places[i]) ? 1 : 0;
            }
            
            return answer;
        }
        
        boolean isCorrect(String[] place) {
            for(int i=0;i<place.length;i++) {
                for(int j=0;j<place[i].length();j++){
                    // 현재 위치에 응시자가 앉아있는 경우
                    if(place[i].charAt(j) == 'P') { 
                        if(!bfs(place, i, j)) return false; 
                    }
                }
            }
            
            return true;
        }
        
        boolean bfs(String[] place, int x, int y) {
            Queue<int[]> q = new LinkedList<>();
            boolean[][] visited = new boolean[place.length][place.length];
            
            q.offer(new int[]{x, y});
            visited[x][y] = true;
            
            while(!q.isEmpty()) {
                // 현재 위치
                int[] cur = q.poll();
                
                // 사방으로 탐색 (상, 하, 좌, 우)
                for(int i=0;i<4;i++) {
                    int newX = cur[0] + dx[i];
                    int newY = cur[1] + dy[i];
                    // 맨해튼 거리 - 현재 위치에서 이동한 위치 뺀 절댓값
                    int mht = Math.abs(x - newX) + Math.abs(y - newY);
                    
                    // 대기실의 크기를 벗어난 경우
                    if(newX < 0 || newY < 0 || newX >= place.length || newY >= place.length) continue;
                    
                    // 이미 방문한 위치거나 맨해튼 거리가 2 이하인 경우
                    if(visited[newX][newY] || mht > 2) continue;
                    
                    visited[newX][newY] = true;
                    
                    // 이동할 위치가 파티션일 경우
                    if(place[newX].charAt(newY) == 'X') continue;
                    // 이동할 위치에 응시자가 앉아있는 경우
                    else if(place[newX].charAt(newY) == 'P') return false;
                    
                    else q.offer(new int[]{newX, newY});
                }
            }
            return true;
        }
    }
}