package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/150368
// title : 이모티콘 할인행사
// type : dfs
// time : 39m
// Created by haerin on 2023-03-10
import java.util.*;
public class 이모티콘할인행사 {
    class Solution {
        public int[] discountType = {10,20,30,40}; // 할인율
        public int[] discount; // 이모티콘 별 설정한 할인율
        public List<int[]> list; // 모든 이모티콘 별 할인율에 따른 [서비스 가입자 수, 이모티콘 매출액]
        public int[] solution(int[][] users, int[] emoticons) {
            discount = new int[emoticons.length];
            list = new ArrayList<>();
            
            dfs(users, emoticons, 0);
            Collections.sort(list, (a, b) -> b[0] == a[0] ? b[1]-a[1] : b[0]-a[0]);
            
            return list.get(0);
        }
        
        // idx : 할인율을 설정한 이모티콘 index
        public void dfs(int[][] users, int[] emoticons, int idx){
            
            if(emoticons.length == idx){
                int[] info = getResult(users, emoticons);
                list.add(info);
                return;
            }
            
            for(int d=0; d<discountType.length; d++){
                discount[idx] = discountType[d];
                dfs(users, emoticons, idx+1);
            }
        }
        
        public int[] getResult(int[][] users, int[] emoticons){
            int totalPrice = 0;
            int numEmoticonPlus = 0;
            for(int[] user : users){
                int price = 0;
                for(int i=0; i<emoticons.length; i++){
                    if(discount[i] < user[0]) continue;
                    price += emoticons[i] / 100 * (100-discount[i]);
                    if(price >= user[1]){
                        price = 0;
                        numEmoticonPlus += 1;
                        break;
                    }
                }
                totalPrice += price;
            }
            return new int[]{numEmoticonPlus, totalPrice};
        }
    }
}
