// https://school.programmers.co.kr/learn/courses/30/lessons/1836
// title : 리틀 프렌즈 사천성

import java.util.*;

public class 리틀프렌즈사천성 {
    class Solution {
        char[][] Board;
        // 게임판에 존재하는 알파벳 대문자 타일 저장
        ArrayList<Character> list = new ArrayList<Character>();
        // 알파벳 대문자 2개의 각 위치
        HashMap<Character, int[][]> map = new HashMap<>();
        
        public String solution(int m, int n, String[] board) {
            Board = new char[m][n];
            StringBuilder answer = new StringBuilder();
            
            for(int i=0;i<m;i++) {
                for(int j=0;j<n;j++) {
                    char c = board[i].charAt(j);
                    Board[i][j] = c;
                    
                    // 빈칸이거나 막힌 칸이 아닌 경우
                    if(c != '.' && c != '*') {
                        // 이미 list에 존재하는 경우
                        if(!list.contains(c)) {
                            list.add(c);
                            map.put(c, new int[2][2]);
                            map.get(c)[0][0] = i;
                            map.get(c)[0][1] = j;
                        }
                        else {
                            map.get(c)[1][0] = i;
                            map.get(c)[1][1] = j;
                        }
                    }
                }
            }
            
            // 알파벳 순으로 가장 먼저인 문자열을 리턴해야하기 때문에
            Collections.sort(list);
            
            int idx = 0;
            while(list.size() != 0) {
                // 타일을 제거할 수 있는 경우
                if(canRemove(list.get(idx))) {
                    // 타일 제거
                    char c = list.remove(idx);
                    answer.append(c);
                    
                    // 제거된 타일 위치를 빈칸으로 변경
                    Board[map.get(c)[0][0]][map.get(c)[0][1]] = '.';
                    Board[map.get(c)[1][0]][map.get(c)[1][1]] = '.';
                    
                    idx = 0;
                }
                else {
                    idx++;
                    
                    // list에 들어있는 타일 전부 탐색해도 제거할 수 없는 경우
                    if(idx == list.size()) return "IMPOSSIBLE";
                }
            }
            
            return answer.toString();
        }
        
        public boolean canRemove(char ch) {
            // 같은 알파벳 대문자 타일 2개의 위치
            int r1 = map.get(ch)[0][0], c1 = map.get(ch)[0][1];
            int r2 = map.get(ch)[1][0], c2 = map.get(ch)[1][1];
            
            // r 순서대로 map에 저장했기 때문에 r은 당연히 r2보다 r1이 작다.
            // c1이 c2보다 작은 경우 -> c1이 c2보다 앞 열에 위치한 경우
            if(c1 < c2) {
                // 앞에 오는 변수들이 더 작은 수
                // c1 -> c2까지 탐색 후, 막히거나 다른 문자 타일이 존재하지 않으면
                // r1 -> r2를 c2 기준으로 탐색
                if(checkColumn(c1, c2, r1, ch) && checkRow(r1, r2, c2, ch)) return true;
                
                // r1 -> r2까지 탐색 후, 막히거나 다른 문자 타일이 존재하지 않으면
                // c1 -> c2를 r2 기준으로 탐색
                if(checkRow(r1, r2, c1, ch) && checkColumn(c1, c2, r2, ch)) return true;
            }
            // c1이 c2보다 같은 경우 -> c1이 c2과 같은 열에 위치한 경우
            else if(c1 == c2) {
                // 열이 동일하기 때문에 r1 -> r2까지 탐색만 하면 됨
                if(checkRow(r1, r2, c1, ch)) return true;
            }
            // c1이 c2보다 큰 경우 -> c1이 c2보다 뒷 열에 위치한 경우
            else {
                // r1 -> r2까지 탐색 후, 막히거나 다른 문자 타일이 존재하지 않으면
                // c2 -> c1를 r1 기준으로 탐색
                if(checkRow(r1, r2, c2, ch) && checkColumn(c2, c1, r1, ch)) return true;
                
                // c2 -> c1까지 탐색 후, 막히거나 다른 문자 타일이 존재하지 않으면
                // r1 -> r2를 c1 기준으로 탐색
                if(checkColumn(c2, c1, r2, ch) && checkRow(r1, r2, c1, ch)) return true;
            }
            
            return false;
        }
        
        public boolean checkRow(int r1, int r2, int c, char ch) {
            // r1부터 r2까지 반복하면서 같은 문자 타일을 바로 만나는지 확인
            for(int i=r1;i<r2+1;i++) {
                // 해당 게임판 타일이 빈칸이 아니거나 특정 문자가 아닌 경우, false
                if(Board[i][c] != '.' && Board[i][c] != ch) return false;
            }
            
            return true;
        }
        
        public boolean checkColumn(int c1, int c2, int r, char ch) {
            // c1부터 c2까지 반복하면서 같은 문자 타일을 바로 만나는지 확인
            for(int i=c1;i<c2+1;i++) {
                // 해당 게임판 타일이 빈칸이 아니거나 특정 문자가 아닌 경우, false
                if(Board[r][i] != '.' && Board[r][i] != ch) return false;
            }
            
            return true;
        }
    }
}