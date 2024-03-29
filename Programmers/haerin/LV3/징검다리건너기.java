package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/64062
// title : 징검다리건너기
// type : 이분탐색
// time : 21m, 12m
// Created by haerin on 2023-03-22, 2023-05-03
import java.util.*;
;public class 징검다리건너기 {
    // 효율성 테스트 실패
    class Solution {
        public int solution(int[] stones, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for(int i=0; i<k; i++){
                pq.add(stones[i]);
            }
            int answer = pq.peek();
            for(int i=1; i<=stones.length-k; i++){
                pq.remove(stones[i-1]);
                pq.add(stones[i+k-1]);
                answer = Math.min(answer, pq.peek());
            }
            return answer;
        }
    }
    // 효율성 테스트 통과
    class Solution2 {
        public int solution(int[] stones, int k) {
            int answer = 0;
            int left = 0;
            int right = Integer.MAX_VALUE;
            while(left <= right){
                int mid = (left+right)/2;
                if(isPossible(mid, k, stones)){
                    left = mid+1;
                    answer = mid;
                }else{
                    right = mid-1;
                }
            }
            return answer;
        }
        public boolean isPossible(int mid, int k, int[] stones) {
            int count = 0;
            for(int s : stones){
                if(s < mid){
                    count += 1;
                    if(count == k) return false;
                }else{
                    count = 0;
                }
            }
            return true;
        }
    }
    class Solution3 {
        public int solution(int[] stones, int k) {
            int answer = 0;
            int left = 1; // 통과 가능한 최소한 사람의 수
            int right = 200000000; // 통과 가능한 최대 사람 수
            while(left <= right){
                int mid = (left + right) / 2;
                
                if(isPossible(stones, k, mid)){
                    left = mid + 1;
                    answer = mid;
                }else{
                    right = mid - 1;
                }
            }
            
            return answer;
        }
        
        private boolean isPossible(int[] arr, int k, int people){
            int cnt = 0;
            for(int num : arr){
                if(num < people){
                    cnt += 1;
                    if(k == cnt) return false;
                }else{
                    cnt = 0;
                }
            }
            return true;
        }
    }
}
