package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/169198
// title : 당구 연습
// type : 구현
// time : 32m
// Created by haerin on 2023-03-21
public class 당구연습 {
    class Solution {
        public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
            int[] answer = new int[balls.length];
            int idx = 0;
            for(int[] ball : balls){
                
                if(startX == ball[0]){ // x좌표가 같을 때
                    int c1 = (ball[1] - startY) * (ball[1] - startY) + 4 * startX * startX;
                    int c2 = (ball[1] - startY) * (ball[1] - startY) + 4 * (m - startX) * (m - startX);
                    int c3 = startY < ball[1] ? (startY + ball[1]) * (startY + ball[1]) : (2 * n - startY - ball[1]) * (2 * n - startY - ball[1]);
                    answer[idx] = Math.min(Math.min(c1,c2),c3);
                }else if(startY == ball[1]){ // y좌표가 같을 때
                    int c1 = (ball[0] - startX) * (ball[0] - startX) + 4 * startY * startY;
                    int c2 = (ball[0] - startX) * (ball[0] - startX) + 4 * (n - startY) * (n - startY);
                    int c3 = startX < ball[0] ? (startX + ball[0]) * (startX + ball[0]) : (2 * m - startX - ball[0]) * (2 * m - startX - ball[0]);
                    answer[idx] = Math.min(Math.min(c1,c2),c3);
                }else{ // x,y좌표가 다를 때
                    int c1 = (ball[0] - startX) * (ball[0] - startX) + (startY + ball[1]) * (startY + ball[1]);
                    int c2 = (ball[0] + startX) * (ball[0] + startX) + (startY - ball[1]) * (startY - ball[1]);
                    int c3 = (ball[1] - startY) * (ball[1] - startY) + (2 * m - startX - ball[0]) * (2 * m - startX - ball[0]);
                    int c4 = (ball[0] - startX) * (ball[0] - startX) + (2 * n - startY - ball[1]) * (2 * n - startY - ball[1]);
                    answer[idx] = Math.min(Math.min(c1,c2),Math.min(c3,c4));
                }
                idx+=1;
            }
            return answer;
        }
    }
}
