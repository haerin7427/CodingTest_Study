// https://school.programmers.co.kr/learn/courses/30/lessons/12945
// title : 피보나치 수

public class 피보나치수 {
    class Solution {
        public int solution(int n) {
            int answer = 0;
            int[] nums = new int[n+1];
            
            nums[0] = 0;
            nums[1] = 1;
            
            for(int i=2;i<=n;i++) {
                // n이 매우 큰 경우, 
                // n번째 피보나치 수는 언어가 표현할 수 있는 자료형의 범위를 넘어가서
                // 오버플로우가 나는 경우 존재
                nums[i] = (nums[i-2] + nums[i-1]) % 1234567;
            }
            
            return nums[n];
        }
    }
}