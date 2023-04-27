package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/131702#
// title : 고고학 최고의 발견
// type : 구현
// time : ...
// Created by haerin on 2023-04-27
public class 고고학최고의발견 {
    class Solution {
        private int[][] d = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        private int N;
        public int solution(int[][] clockHands) {
            N = clockHands.length; // 배열의 길이
            int answer = Integer.MAX_VALUE; // 돌리는 횟수
            
            int[][] temp = new int[N][N];
            String form = "%0"+2*N+"d";
            // 첫 번째 행의 시계를 몇번 돌릴 지 결정하는 반복문
            // 1. 숫자 i를 n*2의 비트로 표현
            // 2. 해당 문자열을 문자 2개씩 잘라 10진수로 변환한 숫자가 시계를 회전하는 횟수를 의미
            // 3. 그 이후 나머지 행의 시계들은 바로 윗칸의 시계를 0으로 만드는 횟수만큼 회전 시킴
            for(int i=0; i<Math.pow(4, N); i++){
                // 첫번째 행의 시계를 돌리는 횟수의 경우의 수가 4^n이므로 테스트를 위해 clockHands 배열 복사
                for(int y=0; y<N; y++){
                    temp[y] = clockHands[y].clone();
                }
                // 첫 번째 행의 시계들을 돌리는 횟수를 의미하는 문자열
                String binaryString = String.format(form, Long.parseLong(Integer.toString(i,2))); 
                // 이 경우 모든 시계를 돌리는 횟수
                int totalCnt = 0;
                for(int x=0; x<N; x++){
                    int rotateCnt = Integer.parseInt(binaryString.substring(2*x,2*(x+1)), 2);
                    rotate(0, x, temp, rotateCnt);
                    totalCnt += rotateCnt;
                }

                // 바로 윗칸을 0으로 만들기 위해 필요한 회전 수 체크
                for(int y=1; y<N; y++){
                    for(int x=0; x<N; x++){
                        if(temp[y-1][x] == 0) continue;
                        totalCnt += (4 - temp[y-1][x]);
                        rotate(y, x, temp, 4 - temp[y-1][x]);
                    }
                }
                
                // 맨 마지막 행의 시계가 모두 0이면 올바르게 돌린 것
                boolean flag = true;
                for(int j=0; j<N; j++){
                    if(temp[N-1][j] != 0){
                        flag = false;
                        break;
                    }
                }
                // 최소한의 돌리는 횟수 구하기
                if(flag && answer > totalCnt){
                    answer = totalCnt;
                }
            }
            return answer;
        }
        // 돌리고자 하는 시계와 함께 돌아가는 인접한 시계 같이 돌리기
        public void rotate(int y, int x, int[][] board, int cnt){
            board[y][x] = (board[y][x] + cnt) % 4;
            
            for(int[] move : d){
                int ny = y + move[0];
                int nx = x+ move[1];
                
                if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                board[ny][nx] = (board[ny][nx] + cnt) % 4;
            }
        }
    }
}
