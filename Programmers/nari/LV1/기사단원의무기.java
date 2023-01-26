// https://school.programmers.co.kr/learn/courses/30/lessons/136798
// title : 기사단원의 무기

public class 기사단원의무기 {
    class Solution1 {
        public int solution(int number, int limit, int power) {
            int answer = 0;
            int[] nums = new int[number];
            
            for(int i=1;i<=number;i++) {
                for(int j=1;j<=Math.sqrt(i);j++){
                    if(i % j == 0) {
                        nums[i-1]++;
                        if(i / j != j) nums[i-1]++;
                    }
                }
                
                if(nums[i-1] > limit) answer += power;
                else answer += nums[i-1];
            }
            
            return answer;
        }
    }

    // 1보다 빠름
    class Solution2 {
        public int solution(int number, int limit, int power) {
            int answer = 0;
            int[] nums = new int[number+1];
            
            for(int i=1;i<=number;i++) {
                for (int j=1;j<=number/i;j++) {
                    nums[i*j]++;
                }
            }
            // 1 -> number까지 -> nums[각 number]
            // 2 -> number/2까지 -> nums[2의 배수]
            // ...
            
            for (int i=1;i<=number;i++) {
                if (nums[i] > limit) answer += power;
                else answer += nums[i];
            }
            
            return answer;
        }
    }
}