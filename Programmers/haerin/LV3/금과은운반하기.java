package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/86053
// title : 금과 은 운반하기
// type : 이분탐색
// time : 20m
// Created by haerin on 2023-04-19
public class 금과은운반하기 {
    // Key point! > 금과 은을 옮길 수 있는 최단 시간 구하기 -> k시간 안에 옮길 수 있는 금과 은의 양을 구하기 로 문제를 변환해서 생각!!
    class Solution {
        public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
            long answer = (long) (10e9 * 2 * 10e5 * 2);
            int C = g.length;
            long start = 0; // start : 최선의 경우 걸리는 시간
            long end = (long) (10e9 * 2 * 10e5 * 2); 
            // end : 최악의 경우 걸리는 시간 : 최대 시간 (금의 양+은의 양) / 한번에 옮길 수 있는 무게 * (옮기는데 걸리는 시간 * 2)
            
            while(start <= end){
                long mid = (start+end) / 2;
                int gold = 0;
                int silver = 0;
                int add = 0;
                
                for(int i=0; i<C; i++){
                    int nGold = g[i];
                    int nSilver = s[i];
                    int nWeight = w[i];
                    int nTime = t[i];
                    
                    long moveCount = mid / (nTime * 2);
                    if (mid % (nTime * 2) >= nTime) {
                        moveCount += 1;
                    }
                    
                    gold += Math.min(nGold, moveCount * nWeight);
                    silver += Math.min(nSilver, moveCount * nWeight);
                    add += Math.min(nGold + nSilver, moveCount * nWeight);
                }
                
                if (a <= gold && b <= silver && a + b <= add) {
                    end = mid - 1;
                    answer = Math.min(mid, answer);
                }else{
                    start = mid + 1;
                }
            }
            
            return answer;
        }
    }
}
