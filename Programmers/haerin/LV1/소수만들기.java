// https://school.programmers.co.kr/learn/courses/30/lessons/12977
// title : 소수 만들기
// time : 4m
// Created by haerin on 2023-01-28
public class 소수만들기 {
    class Solution {
        public int solution(int[] nums) {
            int answer = 0;
            for(int x=0; x<nums.length-2; x++) {
                for(int y=x+1; y<nums.length-1; y++) {
                    for(int z=y+1; z<nums.length; z++) {
                        int temp = nums[x] + nums[y] + nums[z];
                        if(isPrime(temp)) {
                            answer += 1;
                        }
                    }
                }
            }
            return answer;
        }
        
        private boolean isPrime(int num) {
            for(int i=2; i<=Math.sqrt(num); i++) {
                if(num % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
