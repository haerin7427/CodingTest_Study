package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/72415
// title : 카드 짝 맞추기
// type : 순열 + BFS
// time : ...
// Created by haerin on 2023-04-19
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
}
