package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/87377
// title : 교점에 별 만들기
// type : 구현
// time : ...
// Created by haerin on 2023-03-08
import java.util.*;
public class 교점에별만들기 {
    class Solution {
        public String[] solution(int[][] line) {
            Set<String> points = new HashSet<>();
            long maxX = Long.MIN_VALUE, minX = Long.MAX_VALUE;
            long maxY = Long.MIN_VALUE, minY = Long.MAX_VALUE;
            for(int i=0; i<line.length-1; i++){
                long A = line[i][0];
                long B = line[i][1];
                long E = line[i][2];
                
                for(int j=i+1; j<line.length; j++){
                    long C = line[j][0];
                    long D = line[j][1];
                    long F = line[j][2];
                    
                    
                    if(A*D - B*C == 0) continue;
                    
                    double x = (B*F - E*D) / (double)(A*D - B*C) ;
                    double y = (E*C - A*F) / (double)(A*D - B*C) ;
                    
                    if(x % 1 == 0 && y % 1 == 0){
                        minX = Math.min(minX, (long) x);
                        maxX = Math.max(maxX, (long) x);
                        minY = Math.min(minY, (long) y);
                        maxY = Math.max(maxY, (long) y);
                        points.add((long)x+","+(long)y);
                    }
                }
            }
            char[][] board = new char[(int)(maxY-minY+1)][(int)(maxX-minX+1)];
            for(int y=0; y<board.length; y++){
                for(int x=0; x<board[0].length; x++){
                    board[y][x] = '.';
                }
            }
            // 모든 별을 포함하는 최소 크기 격자판의 왼쪽 위 모서리를 기준점 (minX, maxY)으로 설정
            // 기준점으로부터 거리가 인덱스가 됨.
            for(String s : points){
                String[] point = s.split(",");
                int px = (int)Math.abs(minX - Long.parseLong(point[0]));
                int py = (int)Math.abs(maxY - Long.parseLong(point[1]));
                board[py][px] = '*';
            }
            
            String[] answer = new String[board.length];
            for(int i=0; i<answer.length; i++){
                answer[i] = String.valueOf(board[i]);
            }
            return answer;
        }
    }
}
