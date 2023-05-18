// https://leetcode.com/problems/maximum-subarray/
// title : 53. Maximum Subarray
// time taken : 9 m 28 s

public class MaximumSubarray {
    // Time Limit Exceeded
    class Solution1 {
        public int maxSubArray(int[] nums) {
            int len = nums.length;
            int[] dp = new int[len];
            int max = Integer.MIN_VALUE;

            dp = nums.clone();

            for(int i=2;i<=len;i++) {
                for(int j=0;j<len;j++) {
                    int cnt = 0, idx = j, sum = 0;

                    while(cnt < i && idx < len) {
                        sum += nums[idx++];
                        cnt++;
                    }

                    dp[j] = Math.max(dp[j], sum);
                }
            }

            for(int i=0;i<len;i++) {
                max = Math.max(max, dp[i]);
            }

            return max;
        }
    }

    class Solution2 {
        public int maxSubArray(int[] nums) {
            int len = nums.length;
            int max = Integer.MIN_VALUE, sum = 0;
            
            for(int i=0;i<len;i++) {
                sum += nums[i];
                max = Math.max(sum, max);
                
                if(sum < 0) sum = 0;
            }

            return max;
        }
    }
}
