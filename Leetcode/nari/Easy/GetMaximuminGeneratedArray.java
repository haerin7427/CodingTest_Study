// https://leetcode.com/problems/get-maximum-in-generated-array/
// title : 1646. Get Maximum in Generated Array
// time taken : 

public class GetMaximuminGeneratedArray {
    class Solution {
        public int getMaximumGenerated(int n) {
            if(n < 2) return n;

            int[] num = new int[n+1];
            int max = 0;

            num[0] = 0;
            num[1] = 1;

            for(int i=2;i<=n;i++) {
                // 짝수인 경우
                if(i%2 == 0) num[i] = num[i/2];
                // 홀수인 경우
                else num[i] = num[i/2] + num[i/2+1];

                max = Math.max(max, num[i]);
            }

            return max;
        }
    }
}
