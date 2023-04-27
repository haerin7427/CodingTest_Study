package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/84021
// title : 퍼즐 조각 채우기
// type : 구현 (+BFS)
// time : ...
// Created by haerin on 2023-04-26
import java.util.*;
public class 퍼즐조각채우기 {
    class Solution {
        private int[][] d = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        private int N;
        class Point implements Comparable<Point>{
            int y;
            int x;
            Point(int y, int x){
                this.y = y;
                this.x = x;
            }
            
            @Override
            public int compareTo(Point p){
                if(this.x != p.x){
                    return this.x - p.x;
                }else{
                    return this.y - p.y;
                }
            }
        }
        public int solution(int[][] game_board, int[][] table) {
            N = game_board.length;
            // table과 형식을 맞추기 위해 빈칸을 1로 채워진 칸을 0으로 변경
            for(int y=0; y<N; y++){
                for(int x=0; x<N; x++){
                    game_board[y][x] = (game_board[y][x] == 1) ? 0 : 1;
                }
            }

            // BFS를 통해 조각 좌표 리스트로 저장하기
            List<List<Point>> gameboardList = new ArrayList<>();
            List<List<Point>> tableList = new ArrayList<>();
            boolean[][] gameIsVisited = new boolean[N][N];
            boolean[][] tableIsVisited = new boolean[N][N];
            for(int y=0; y<N; y++){
                for(int x=0; x<N; x++){
                    if(game_board[y][x] == 1 && !gameIsVisited[y][x]){
                        gameIsVisited[y][x] = true;
                        gameboardList.add(bfs(y, x, game_board, gameIsVisited));
                    }
                    if(table[y][x] == 1 && !tableIsVisited[y][x]){
                        tableIsVisited[y][x] = true;
                        tableList.add(bfs(y, x, table, tableIsVisited));
                    }
                }
            }
    
            int answer = 0;
            for(List<Point> g : gameboardList) {
                // flag가 true면 빈칸에 맞는 조각을 찾았다는 의미
                boolean flag = false;
                int removeIdx = -1;
                for(int j=0; j<tableList.size(); j++) {
                    List<Point> t = tableList.get(j);
                    if(g.size() == t.size()){
                        for(int i=0; i<4; i++){
                            if(isCorrect(g, t)){
                                // 빈칸에 맞는 조각을 찾았을 경우
                                removeIdx = j; // 삭제할 조각 인덱스
                                answer += g.size(); // 채우는 칸 수
                                flag = true;
                                break;
                            }else{
                                rotatePiece(t); // 90도 회전 : (y, x) -> (x, N-y)
                            }
                        }
                    }
                    if(flag) break;
                }
                if(flag){
                    tableList.remove(removeIdx);
                }
            }
            return answer;
        }
        // 조각 좌표 90도 회전 (y, x) -> (x, N-y)
        private void rotatePiece(List<Point> t){
            for(Point o : t){
                int ty = o.x;
                int tx = N - o.y;
                o.y = ty;
                o.x = tx;
            }
            Collections.sort(t);
        }
        // 퍼즐이 놓일 빈칸과 조각사이의 x,y값 차가 동일할 경우 들어갈 수 있음
        private boolean isCorrect(List<Point> g, List<Point> t){
            int difY = g.get(0).y - t.get(0).y;
            int difX = g.get(0).x - t.get(0).x;
            
            for(int i=1; i<g.size(); i++){
                if(difY != g.get(i).y - t.get(i).y || difX != g.get(i).x - t.get(i).x){
                    return false;
                }
            }
            return true;
        }
        // bfs로 이어진 빈칸 또는 조각들의 좌표 구하기
        public List<Point> bfs(int y, int x, int[][] board, boolean[][] isVisited){
            List<Point> pointList = new ArrayList<>();  // 이어진 빈칸 또는 조각들의 좌표 리스트
            pointList.add(new Point(y,x));
            
            Queue<Point> queue = new LinkedList<>();
            queue.add(new Point(y,x));
            
            while(!queue.isEmpty()){
                Point now = queue.poll();
                
                for(int i=0; i<d.length; i++){
                    int ny = now.y + d[i][0];
                    int nx = now.x + d[i][1];
                    
                    if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                    if(board[ny][nx] == 0 || isVisited[ny][nx]) continue;
                    
                    isVisited[ny][nx] = true;
                    queue.add(new Point(ny,nx));
                    pointList.add(new Point(ny,nx));
                }
            }

            Collections.sort(pointList);
            return pointList;
        }
    }
}
