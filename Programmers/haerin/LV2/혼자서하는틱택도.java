package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/160585
// title : 혼자서 하는 틱택도
// type : 구현
// time : 20m
// Created by haerin on 2023-03-05
public class 혼자서하는틱택도 {
    // O와 X의 수가 올바르지 않는 경우.
        // X가 O보다 큰 경우. 
        // O가 X보다 2이상 큰 경우. 
    // O와 X가 둘 다 승리하는 경우.
        // O가 승리했는데 X가 수를 더 놓는 경우.
        // X가 승리했는데 O와 X의 수가 같지 않은 경우.
    class Solution {
        public int solution(String[] board) {
            StringBuilder sb = new StringBuilder();
            for(String s : board){
                sb.append(s);
            }
            int lenO = sb.toString().replaceAll("[^O]","").length();
            int lenX = sb.toString().replaceAll("[^X]","").length();
            
            if(lenO < lenX || lenO-lenX > 1){
                return 0;
            }
            
            char[][] charB = new char[3][3];
            for(int y=0; y<3; y++){
                for(int x=0; x<3; x++){
                    charB[y][x] = board[y].charAt(x);
                }
            }
            
            if(isWin(charB, 'O') && isWin(charB, 'X')) return 0;
            if(isWin(charB, 'O') && lenO == lenX) return 0;
            if(isWin(charB, 'X') && lenO != lenX) return 0;
            return 1;
        }
        
        private boolean isWin(char[][] b, char tag){
            for(int y=0; y<b.length; y++){
                if(b[y][0] == tag && b[y][1] == tag && b[y][2] == tag){
                    return true;
                }
            }
            for(int x=0; x<b.length; x++){
                if(b[0][x] == tag && b[1][x] == tag && b[2][x] == tag){
                    return true;
                }
            }
            if(b[0][0] == tag && b[1][1] == tag && b[2][2] == tag){
                return true;
            }
            if(b[0][2] == tag && b[1][1] == tag && b[2][0] == tag){
                return true;
            }
            
            return false;
        }
    }
}