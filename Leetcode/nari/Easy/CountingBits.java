// https://leetcode.com/problems/counting-bits/
// title : 338. Counting Bits
// time taken : 4 m 17 s

public class CountingBits {
    class Solution {
        public int[] countBits(int n) {
            int[] answer = new int[n+1];

            for(int i=0;i<=n;i++) {
                String bits = Integer.toBinaryString(i);
                int len = bits.length();

                bits = bits.replaceAll("1", "");

                answer[i] = len - bits.length();
            }

            return answer;
        }
    }
}
