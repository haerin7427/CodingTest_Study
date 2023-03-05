package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/134239
// title : 우박수열 정적분
// time : 50m
// Created by haerin on 2023-03-05
import java.util.*;
public class 우박수열정적분 {
    class Solution {
        public double[] solution(int k, int[][] ranges) {
            Map<Integer, Integer> map = new HashMap<>();
            // 콜라츠 추측 그래프 값 저장
            int cnt = makeMap(map, k);
            
            // 넓이의 누적합 구하기 ex. ans[i]는 x에 대한 범위가 [0,i+1]인 공간의 면적
            double[] ans = new double[cnt];
            for(int x=0; x<ans.length; x++){
                if(x > 0){
                    ans[x] += ans[x-1];
                }
                ans[x] += getArea(map.get(x), map.get(x+1));
            }
            
            double[] answer = new double[ranges.length];
            for(int i=0; i<ranges.length; i++){
                int a = 0 + ranges[i][0];
                int b = cnt + ranges[i][1];
                if(a>b) {
                    answer[i] = -1.0;
                }else if(a == b){
                    answer[i] = 0.0;
                }else{
                    answer[i] = ans[b-1];
                    if(a>0)
                        answer[i] -= ans[a-1];
                }
            }
            return answer;
        }
    
        // key : x값, value : y값
        private int makeMap(Map<Integer, Integer> map, int K){
            int cnt=0;
            map.put(cnt, K);
            while(K > 1){
                if(K % 2 == 0){
                   K /= 2; 
                }else{
                    K = K*3 + 1;
                }
                cnt += 1;
                map.put(cnt, K);
            }
            return cnt;
        }
        
        private double getArea (int y1, int y2){
            return (y1+y2) / 2.0; 
        }
    }
}
