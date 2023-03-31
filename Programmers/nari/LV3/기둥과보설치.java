// https://school.programmers.co.kr/learn/courses/30/lessons/60061
// title : 기둥과 보 설치

public class 기둥과보설치 {
    class Solution {
        boolean[][] pillars;
        boolean[][] covers;
        
        public int[][] solution(int n, int[][] build_frame) {
            pillars = new boolean[n+3][n+3];
            covers = new boolean[n+3][n+3];
            // 설치된 갯수
            int cnt = 0;
            
            for(int[] frame : build_frame){
                // 좌표
                int x = frame[0] + 1, y = frame[1] + 1;
                // 0 = 기둥, 1 = 보
                int a = frame[2];
                // 0 = 삭제, 1 = 설치
                int b = frame[3];
                
                // 삭제일 경우
                if(b == 0) {
                    if(a == 0) pillars[x][y] = false;    
                    else covers[x][y] = false;
                    
                    // 삭제할 수 없는 경우
                    if(!canDelete(n)) {
                        if(a == 0) pillars[x][y] = true;
                        else covers[x][y] = true;
                    }
                    else cnt--;
                }
                else {
                    // 설치가 가능한지 확인 후, 설치
                    if(a == 0 && checkPillar(x,y)) {
                        pillars[x][y] = true;    
                        cnt++;
                    }
                    if(a == 1 && checkCover(x,y)) {
                        covers[x][y] = true;
                        cnt++;
                    }
                }
            }
            
            int[][] answer = new int[cnt][3];
            int idx = 0;
            
            for(int i=1;i<=n+1;i++) {
                for(int j=1;j<=n+1;j++) {
                    if(pillars[i][j]) {
                        answer[idx][0] = i-1;
                        answer[idx][1] = j-1;
                        answer[idx++][2] = 0;
                    }
                    if(covers[i][j]) {
                        answer[idx][0] = i-1;
                        answer[idx][1] = j-1;
                        answer[idx++][2] = 1;
                    }
                }
            }
            
            return answer;
        }
        
        boolean canDelete(int n) {    
            for(int i=0;i<=n;i++) { 
                for(int j=0;j<= n;j++) { 
                    // 기둥이 해당 위치에 있을 수 없는 경우, false 
                    if(pillars[i][j] && checkPillar(i, j) == false) return false; 
                    // 바닥이 해당 위치에 있을 수 없는 경우, false 
                    else if(covers[i][j] && checkCover(i, j) == false) return false;
                }
            }
            
            return true;
        }
        
        boolean checkPillar(int x, int y) {
            // 바닥에 설치하거나 아래 기둥이 있거나 이미 보가 설치된 경우
            return y==1 || pillars[x][y-1] || covers[x][y] || covers[x-1][y];
        }
        
        boolean checkCover(int x, int y) {
            // 한쪽 끝에 기둥이 있거나 양쪽 끝이 보와 동시에 연결되어 있는 경우
            return pillars[x][y-1] || pillars[x+1][y-1] || (covers[x+1][y] && covers[x-1][y]);
        }
    }
}