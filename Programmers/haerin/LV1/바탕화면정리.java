// https://school.programmers.co.kr/learn/courses/30/lessons/161990
// title : 바탕화면 정리
// type : min, max 값 찾기
// time : 21m
// Created by haerin on 2023-03-11
public class 바탕화면정리 {
    class Solution {
        public int[] solution(String[] wallpaper) {
            int lux = Integer.MAX_VALUE;
            int luy = Integer.MAX_VALUE;
            int rdx = 0;
            int rdy = 0;
            
            for(int x=0; x<wallpaper.length; x++){
                for(int y=0; y<wallpaper[0].length(); y++){
                    if(wallpaper[x].charAt(y) =='#'){
                        // lux = Math.min(lux,x);
                        // luy = Math.min(luy,y);
                        // rdx = Math.max(rdx,x+1);
                        // rdy = Math.max(rdy,y+1);
                        if(lux > x){
                            lux = x;
                        }
                        if(luy > y){
                            luy = y;
                        }
                        if(rdx < x+1){
                            rdx = x+1;
                        }
                        if(rdy < y+1){
                            rdy = y+1;
                        }
                    }
                }
            }
            return new int[]{lux, luy, rdx, rdy};
        }
    }
}
