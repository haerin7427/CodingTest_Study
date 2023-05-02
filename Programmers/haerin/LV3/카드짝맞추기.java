package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/72415
// title : 카드 짝 맞추기
// type : 순열 + BFS, dfs + bfs
// time : ..., 1h
// Created by haerin on 2023-04-19, 2023-05-02
import java.util.*;
public class 카드짝맞추기 {
    class Solution {
        private boolean[] isUsedCard = new boolean[7];
        private int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        private int[][] map;
        private int cardType = 0;
        private int R;
        private int C;
        private int time = Integer.MAX_VALUE;
        class Point {
            int y;
            int x;
            int moveCnt;
            Point(int y, int x, int m){
                this.y = y;
                this.x = x;
                this.moveCnt = m;
            }
        }
        public int solution(int[][] board, int r, int c) {
            map = board;
            R = r;
            C = c;
            // 존재하는 카드 종류 구하기
            boolean[] cards = new boolean[7];
            for(int i=0; i<board.length; i++){
                for(int j=0; j<board[0].length; j++){
                    if(board[i][j] == 0 || cards[board[i][j]]) continue;
                    cards[board[i][j]] = true;
                    cardType += 1;
                }
            }
            permutation(0, new int[cardType], cards);
            return time;
        }
        // 카드 찾을 순서 정하기
        private void permutation(int cnt, int[] arr, boolean[] cards){        
            if(cardType == cnt){
                bfs(arr);
                return;
            }
            
            for(int i=1; i<cards.length; i++){
                if(!cards[i] || isUsedCard[i]) continue;
                arr[cnt] = i;
                isUsedCard[i] = true;
                permutation(cnt+1, arr, cards);
                isUsedCard[i] = false;
            }
        }
        // 위치가 보드 안 인지 확인
        private boolean isPossible(int x, int y){
            if(x < 0 || y < 0 || x >= map[0].length || y >= map.length) {
                return false;
            }else{
                return true;
            }
        }
        // 카드 순서대로 찾을 수 있는 최단 경로 구하기
        private void bfs(int[] arr){
            // 뒤집은 카드 기록
            boolean[][] isEnteredMap = new boolean[map.length][map[0].length];
            // 방문한 위치 기록 (카드를 뒤집을 때 마다 초기화)
            boolean[][] isVisitedMap = new boolean[map.length][map[0].length];
            int[] checkCard = new int[arr.length];
            Queue<Point> queue = new LinkedList<>();
            queue.add(new Point(R, C, 0));
            isVisitedMap[R][C] = true;
            int idx = 0;
            while(!queue.isEmpty()){
                Point now = queue.poll();
                
                if(map[now.y][now.x] == arr[idx] && !isEnteredMap[now.y][now.x]){
                    // enter를 쳐서 뒤집은 경우
                    now.moveCnt += 1; 
                    isEnteredMap[now.y][now.x] = true;
                    
                    // 지금까지 방문기록 모두 초기화
                    isVisitedMap = new boolean[map.length][map[0].length];
                    queue.clear();
                    
                    // 현재 위치를 시작점으로 다시 시작
                    isVisitedMap[now.y][now.x] = true;
                    queue.add(now);
                    
                    // 이미 똑같은 카드를 뒤집은 경우
                    if(checkCard[idx] == 1){
                        if(idx == arr.length-1){
                            time = Math.min(time, now.moveCnt);
                            break;
                        }else{
                            idx += 1;
                        }
                    }else{
                        checkCard[idx] += 1;
                    }
                }
                
                for(int i=0; i<4; i++) {
                    int nx = now.x + d[i][0];
                    int ny = now.y + d[i][1];
    
                    if(!isPossible(nx, ny)) continue;
                    if(isVisitedMap[ny][nx]) continue;
                    isVisitedMap[ny][nx] = true;
                    queue.add(new Point(ny, nx, now.moveCnt+1));
                }
                
                for(int i=0; i<4; i++) {
                    int nx = now.x;
                    int ny = now.y;
    
                    //범위 끝이면 종료되는 while문
                    while(isPossible(nx + d[i][0], ny + d[i][1])) {
                        nx += d[i][0];
                        ny += d[i][1];
                        //만약 엔터치지않은 말이 존재하면 거기에 멈춰짐
                        if(!isEnteredMap[ny][nx] && map[ny][nx] != 0) break;
                    }
    
                    if(!isPossible(nx, ny) || isVisitedMap[ny][nx]) continue;
                    isVisitedMap[ny][nx] = true;
                    queue.add(new Point(ny, nx, now.moveCnt+1));
                }
                
            }
        }
    }
    // 0502 2차시도
    class Solution2 {
        class Cursor {
            int r;
            int c;
            int cnt;
            Cursor(int r, int c, int cnt){
                this.r = r;
                this.c = c;
                this.cnt = cnt;
            }
        }
        private List<String> orderList = new ArrayList<>();
        private boolean[] isVisited;
        private int N = 0;
        public int solution(int[][] board, int r, int c) {
            for(int y=0; y<board.length; y++){
                for(int x=0; x<board[0].length; x++){
                    if(board[y][x] == 0) continue;
                    N += 1;
                }
            }
            N /= 2;
            isVisited = new boolean[N];
            dfs(new StringBuilder());
            
            return bfs(board, r, c);
        }
        
        public int bfs(int[][] board, int r, int c) {
            int[][] move = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
            int answer = Integer.MAX_VALUE;
            
            for(String order : orderList){
                
                int[][] b = new int[board.length][board[0].length];
                for(int i=0; i<b.length; i++){
                    b[i] = board[i].clone();
                }
                
                int idx = 0;
                int target = order.charAt(idx) - '0';
                Queue<Cursor> queue = new LinkedList<>();
                queue.add(new Cursor(r, c, 0));
                boolean[][] visited = new boolean[b.length][b[0].length];
                visited[r][c] = true;
                boolean isSecond = false;
                    
                while(!queue.isEmpty()){
                    Cursor now = queue.poll();
                    if(b[now.r][now.c] == target){
                        // Enter 처리
                        now.cnt += 1;
                        b[now.r][now.c] = 0;
                        
                        // 초기화
                        visited = new boolean[b.length][b[0].length];
                        queue.clear();
                        
                        // 시작점 세팅
                        visited[now.r][now.c] = true;
                        
                        if(isSecond){ // 두 번째 찾은 타겟 카드 일 경우
                            if(idx + 1 == N) { // 마지막 순서의 카드일 경우
                                answer = Math.min(answer, now.cnt);
                                break;
                            }else{ // 마지막 순서가 아닐 경우
                                idx += 1;
                                isSecond = false;
                                target = order.charAt(idx) - '0';
                            }
                        }else{ // 아닐 경우
                            isSecond = true;
                        }
                    }
                    // 한 칸씩 이동
                    for(int[] m : move) {
                        int nr = now.r + m[0];
                        int nc = now.c + m[1];

                        if(nr < 0 || nc < 0 || nr >= b.length || nc >= b[0].length) continue;
                        if(visited[nr][nc]) continue;

                        visited[nr][nc] = true;
                        queue.add(new Cursor(nr, nc, now.cnt + 1));
                    }
                        
                    // ctrl 이동
                    for(int[] m : move){
                        int nr = now.r;
                        int nc = now.c;

                        while(isOnBoard(board, nr + m[0], nc + m[1])){
                            nr += m[0];
                            nc += m[1];

                            if(b[nr][nc] != 0){
                                break;
                            }
                        }
                        if(visited[nr][nc] || now.r == nr && now.c == nc) continue;

                        visited[nr][nc] = true;
                        queue.add(new Cursor(nr, nc, now.cnt + 1));
                    }
                }
            }
            return answer;
        }
        
        private boolean isOnBoard(int[][] board, int r, int c){
            if(r < 0 || c < 0 || r >= board.length || c >= board[0].length)
                return false;
            else
                return true;
        }
        
        public void dfs(StringBuilder sb){
            if(sb.length() == N){
                orderList.add(new String(sb.toString()));
                return;
            }
            for(int i=1; i<=N; i++){
                if(isVisited[i-1]) continue;
                isVisited[i-1] = true;
                dfs(sb.append(i));
                sb.deleteCharAt(sb.length()-1);
                isVisited[i-1] = false;
            }
        }
    }
}
