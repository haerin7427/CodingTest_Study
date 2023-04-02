package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/92344
// title : 파괴되지 않은 건물
// type : 누적합
// time : 40m
// Created by haerin on 2023-04-02
public class 파괴되지않은건물 {
    // 효율성 테스트 실패 => O(n*m*k) [board 크기 : n*m, skill 횟수: k]
    class Solution {
        public int solution(int[][] board, int[][] skill) {
            int answer = 0;
            for(int y=0; y < board.length; y++){
                for(int x=0; x < board[0].length; x++){
                    int status = board[y][x];
                    for(int[] info : skill){
                        if(info[1] > y || info[3] < y || info[2] > x || info[4] < x) continue;
                        if(info[0] == 1){
                            status -= info[5];
                        }else {
                            status += info[5];
                        }
                    }
                    if(status > 0){
                        answer += 1;
                    }
                }
            }
            return answer;
        }
    }
    // 누적합으로 효율성 테스트 통과 => O(n*m)
    // 카카오 풀이 : https://tech.kakao.com/2022/01/14/2022-kakao-recruitment-round-1/
    class Solution2 {
        public int solution(int[][] board, int[][] skill) {
            int[][] sumDegree = new int[board.length+1][board[0].length+1];
            for(int info[] : skill){
                int type = info[0];
                int r1 = info[1];
                int c1 = info[2];
                int r2 = info[3];
                int c2 = info[4];
                int degree = info[5] * (type == 1 ? -1 : 1);
                
                sumDegree[r1][c1] += degree;
                sumDegree[r1][c2+1] += degree*-1;
                sumDegree[r2+1][c1] += degree*-1;
                sumDegree[r2+1][c2+1] += degree;
            }
            calculate(sumDegree);
            
            int answer = 0;
            for(int y=0; y<board.length; y++){
                for(int x=0; x<board[0].length; x++){
                    if(sumDegree[y][x] + board[y][x] > 0){
                        answer += 1;
                    }
                }
            }
            return answer;
        }
        
        public void calculate(int[][] a){
            for(int y=1; y<a.length; y++){
                for(int x=0; x<a[0].length; x++){
                    a[y][x] += a[y-1][x];
                }
            }
            
            for(int x=1; x<a[0].length; x++){
                for(int y=0; y<a.length; y++){
                    a[y][x] += a[y][x-1];
                }
            }
        }
    }
}
