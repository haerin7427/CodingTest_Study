package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/60059
// title : 자물쇠와 열쇠
// type : 구현
// time : 19m
// Created by haerin on 2023-03-23
public class 자물쇠와열쇠 {
    class Solution {
        public boolean solution(int[][] key, int[][] lock) {
            int k = key.length;
            int l = lock.length;
            
            int len = k+l*2-2;
            int[][] map = new int[len][len];
            
            for(int y=k-1; y<k+l-1; y++){
                for(int x=k-1; x<k+l-1; x++){
                    map[y][x] = lock[y-(k-1)][x-(k-1)];
                }
            }
            
            for(int i=0; i<4; i++){
                if(isCorrect(map, key, l)){
                    return true;
                }
                rotate(key);
            }
            return false;
        }
        
        public boolean isCorrect(int[][] map, int[][] key, int lockLen){
            int keyLen = key.length;
            int mapLen = map.length;
            
            for(int i=0; i<mapLen-keyLen+1; i++){
                for(int j=0; j<mapLen-keyLen+1; j++){
                    
                    
                    for(int k=0; k<keyLen; k++){
                        for(int l=0; l<keyLen; l++){
                            map[i+k][j+l] += key[k][l];
                        }
                    }
                    
                    /* 자물쇠 부분이 모두 1인지 확인 */
                    boolean flag = true;
                    for(int k=keyLen-1; k<keyLen+lockLen-1; k++){
                        for(int l=keyLen-1; l<keyLen+lockLen-1; l++){
                            if(map[k][l] != 1){
                                flag = false;
                                break;
                            }
                        }
                        if(!flag) break;
                    }
                    
                    if(flag) return true;
                    
                    for(int k=0; k<keyLen; k++){
                        for(int l=0; l<keyLen; l++){
                            map[i+k][j+l] -= key[k][l];
                        }
                    }
                    
                }
            }
            
            return false;
        }
        
        public void rotate(int[][] key){
            int keyLen = key.length;
            int[][] tmp = new int[keyLen][keyLen];
            
            for(int y=0; y<keyLen; y++){
                for(int x=0; x<keyLen; x++){
                    tmp[y][x] = key[keyLen-x-1][y];
                }
            }
            
            for(int y=0; y<keyLen; y++){
                for(int x=0; x<keyLen; x++){
                    key[y][x] = tmp[y][x];
                }
            }
        }
    }
}