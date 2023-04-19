package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/131129
// title : 카운트 다운
// type : DP
// time : 30m
// Created by haerin on 2023-04-19
public class 카운트다운 {
    class Solution {
        private int[][] dp;
        public int[] solution(int target) {
            // dp[i][0] : 점수 i를 만들 때의 최소 다트 수, dp[i][1] : 최대 싱글/볼 횟수
            dp = new int[target+1][2];
            for(int i=1;i<=target;i++) {
                dp[i][0] = 100001;
            }
            return getDartPoint(target);
        }
        
        private int[] getDartPoint(int score){
            if(dp[score][0] == 100001){
                if(score >= 50) {
                    int[] temp = getDartPoint(score - 50);
                    // 던진 다트 수가 더 적거나, 싱글 또는 볼을 맞힌 수가 많으면 값 업데이트
                    if((temp[0] + 1 < dp[score][0]) || (temp[0] + 1 == dp[score][0] && temp[1] + 1 > dp[score][1])) {
                        dp[score][0] = 1 + temp[0];
                        dp[score][1] = 1 + temp[1];
                    }
                }
                
                // 1 ~ start 값까지 single, double, triple 맞췄을 경우 계산
                int start = score >= 20 ? 20 : score;
                for(int i=start;i>=1;i--) {
                    for(int j=1;j<=3;j++) { 
                        int point = i * j;
                        if(score >= point) {
                            int[] temp = getDartPoint(score - point);
                            // 싱글일 경우 체크
                            int cnt = j == 1 ? 1 : 0; 
                            if((temp[0] + 1 < dp[score][0]) || (temp[0] + 1 == dp[score][0] && temp[1] + cnt > dp[score][1])) {
                                dp[score][0] = 1 + temp[0];
                                dp[score][1] = cnt + temp[1];
                            }
                        }
                        
                    }
                }
            }
            return dp[score];
        }
    }
}
