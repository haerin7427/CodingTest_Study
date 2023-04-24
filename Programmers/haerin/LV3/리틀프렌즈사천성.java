package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/1836
// title : 리틀 프렌즈 사천성
// type : 구현
// time : ...
// Created by haerin on 2023-04-24
import java.util.*;
public class 리틀프렌즈사천성 {
    class Solution {
        class Tile implements Comparable<Tile>{
            int c;
            int y;
            int x;
            
            Tile(int c, int y, int x){
                this.c = c;
                this.y = y;
                this.x = x;
            }
            
            @Override
            public int compareTo(Tile o) {
                // 알파벳, x좌표, y좌표 순으로 정렬
                if(this.c != o.c) {
                    return this.c - o.c;
                }else if(this.x != o.x) {
                    return this.x - o.x;
                }else{
                    return this.y - o.y;
                }
            }
        }
        private String answer;
        private List<Tile> tileList;
        private char[][] boardChar;
        public String solution(int m, int n, String[] board) {
            answer = "";
            tileList = new ArrayList<>();
            boardChar = new char[m][n];
            for(int i = 0; i < board.length ; i++){
                boardChar[i] = board[i].toCharArray();
            }
    
            for(int i = 0 ; i < m ; i++){
                for(int j = 0 ; j < n ; j++){
                    char c = boardChar[i][j];
                    if('A' <= c && c <= 'Z'){
                        tileList.add(new Tile(c, i, j));
                    }
                }
            }
            Collections.sort(tileList);
            
            for(int i=0; i<tileList.size(); i+=2){
                Tile t1 = tileList.get(i);
                Tile t2 = tileList.get(i+1);
                
                if(isDelete(t1, t2)){
                    answer += (char) t1.c;
                    boardChar[t1.y][t1.x] = '.';
                    boardChar[t2.y][t2.x] = '.';
                    tileList.remove(t1);
                    tileList.remove(t2);
                    i = -2;
                }
            }
            return tileList.size() == 0 ? answer : "IMPOSSIBLE";
        }
        
        private boolean isDelete (Tile t1, Tile t2){
            if(t1.y == t2.y){
                for(int x = t1.x+1; x < t2.x; x++){
                    if(boardChar[t1.y][x] != '.'){
                        return false;
                    }
                }
                return true;
            }else if(t1.x == t2.x){
                for(int y=t1.y+1; y < t2.y; y++){
                    if(boardChar[y][t1.x]  != '.'){
                        return false;
                    }
                }
                return true;
            }else{
                boolean flag1 = true, flag2 = true;
                if(t1.y > t2.y){
                    // 우상
                    for(int x = t1.x+1; x<=t2.x; x ++){
                        if(boardChar[t1.y][x] != '.'){
                            flag1 = false;
                            break;
                        }
                    }
                    for(int y = t1.y-1; y > t2.y; y--){
                        if(boardChar[y][t2.x] != '.'){
                            flag1 = false;
                            break;
                        }
                    }
                    
                    // 상우
                    for(int y = t1.y-1; y > t2.y; y--){
                        if(boardChar[y][t1.x] != '.'){
                            flag2 = false;
                            break;
                        }
                    }
                    for(int x = t1.x; x<t2.x; x++){
                        if(boardChar[t2.y][x] != '.'){
                            flag2 = false;
                            break;
                        }
                    }
                }else{
                    // 우하
                    for(int x = t1.x+1; x<=t2.x; x ++){
                        if(boardChar[t1.y][x] != '.'){
                            flag1 = false;
                            break;
                        }
                    }
                    for(int y = t1.y+1; y < t2.y; y++){
                        if(boardChar[y][t2.x] != '.'){
                            flag1 = false;
                            break;
                        }
                    }
                    // 하우
                    for(int y = t1.y+1; y < t2.y; y++){
                        if(boardChar[y][t1.x] != '.'){
                            flag2 = false;
                            break;
                        }
                    }
                    for(int x = t1.x; x<t2.x; x ++){
                        if(boardChar[t2.y][x] != '.'){
                            flag2 = false;
                            break;
                        }
                    }
                }
                return flag1 || flag2;
            } 
        }
    }
}
