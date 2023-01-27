// https://school.programmers.co.kr/learn/courses/30/lessons/12977
// title : 소수 만들기

public class 소수만들기 {
    class Solution {
        public int solution(int[] nums) {
            int answer = 0;

            for(int i=0;i<nums.length-2;i++) {
                for(int j=i+1;j<nums.length-1;j++) {
                    for(int k=j+1;k<nums.length;k++) {
                        if(divisor(nums[i] + nums[j] + nums[k])) answer++;
                    }
                }
            }

            return answer;
        }
        
        boolean divisor(int n) {
            for(int i=2; i<=Math.sqrt(n); i++){
                if(n % i == 0) return false;
            }
            
            return true;
        }
    }
}