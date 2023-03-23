package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/12971
// title : 스티커모으기(2)
// type : DP
// time : 30m
// Created by haerin on 2023-03-23
public class 스티커모으기투 {
    class Solution {
        public int solution(int sticker[]) {
            int N = sticker.length;
            if(N==1) return sticker[0];
            
            // 첫번째 스티커를 떼는 방법
            int[] dp1 = new int[N];
            dp1[0] = sticker[0];
            dp1[1] = sticker[0];
            for(int i=2; i<N-1; i++){
                dp1[i] = Math.max(dp1[i-1], dp1[i-2]+sticker[i]);
            }
            
            // 첫번째 스티커를 떼지 않는 방법
            int[] dp2 = new int[N];
            dp2[0] = 0;
            dp2[1] = sticker[1];
            for(int i=2; i<N; i++){
                dp2[i] = Math.max(dp2[i-1], dp2[i-2]+sticker[i]);
            }

            int answer = 0;
            answer = Math.max(dp1[N-2],dp2[N-1]);
            return answer;
        }
    }
}
