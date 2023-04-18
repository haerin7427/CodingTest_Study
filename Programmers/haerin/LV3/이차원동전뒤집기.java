package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/131703
// title : 2차원 동전 뒤집기
// type : Brute Force
// time : ...
// Created by haerin on 2023-04-18
public class 이차원동전뒤집기 {
    class Solution {
        public int R, C;
        public int[][] M, T, tmp;
    
        public void flipCol(int c) {
            for (int i = 0; i < R; i++)
                tmp[i][c] = tmp[i][c] == 0 ? 1 : 0;
        }
    
        public void copyArr() {
            for (int i = 0; i < R; i++)
                for (int j = 0; j < C; j++)
                    tmp[i][j] = M[i][j];
        }
    
    
        public int solution(int[][] beginning, int[][] target) {
            R = beginning.length;
            C = beginning[0].length;
            M = beginning;
            T = target;
            tmp = new int[R][C];
            int result = Integer.MAX_VALUE;
            //모든 열에 대해서 반복
            for (int mask = 0; mask < 2 << C; mask++) {
                int tmpResult = 0;
                copyArr();
                //1. 칼럼 뒤집기
                for (int col = 0; col < C; col++) {
                    //뒤집지 않는 열의 경우 냅둠
                    if ((mask & 2 << col) == 0) continue;
                    tmpResult++;
                    flipCol(col);
                }
                
                //2. 모든 로우 판별
                boolean flag = false;
                for (int i = 0; i < R; i++) {
                    // 해당 행 중에 일부만 결과값과 일치할 시 바꿀수 없다고 판별하고 무시
                    if (flag) break;
                    // 해당 행의 모든 수가 같으면 맞다고 판별
                    if (tmp[i][0] == T[i][0]) {
                        for (int j = 1; j < C; j++) {
                            if (tmp[i][j] != T[i][j]){
                                flag = true;
                                break;
                            }
                        }
                    }
                    // 해당 행의 모든 수가 다르면 맞다고 판별하고 뒤집은 횟수 + 1
                    else {
                        for (int j = 1; j < C; j++) {
                            if (tmp[i][j] == T[i][j]){
                                flag = true;
                                break;
                            }
                        }
                        if (!flag) tmpResult++;
                    }
                }
                //일치하는 경우
                if (!flag) result = Math.min(result, tmpResult);
            }
            if (result == Integer.MAX_VALUE) return -1;
            else return result;
        }
    }
}
