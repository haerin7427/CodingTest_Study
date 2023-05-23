// https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/
// title : 1689. Partitioning Into Minimum Number Of Deci-Binary Numbers
// time taken : -

public class PartitioningIntoMinimumNumberOfDeciBinaryNumbers {
    class Solution {
        public int minPartitions(String n) {
            // n = "153"
            // 1 - 1 0 0 0 0
            // 5 - 1 1 1 1 1
            // 3 - 1 1 1 0 0
            // 111 + 011 + 011 + 010 + 010 = 153 => 5

            // n = "3271"
            // 3 - 1 1 1 0 0 0 0
            // 2 - 1 1 0 0 0 0 0
            // 7 - 1 1 1 1 1 1 1
            // 1 - 1 0 0 0 0 0 0
            // 1111 + 1110 + 1010 + 0010 + 0010 + 0010 + 0010 = 3271 => 7

            // n에 존재하는 최대 숫자

            int max = 0;
            int len = n.length();

            for(int i=0;i<len;i++) {
                max = Math.max(max, n.charAt(i)-'0');
            }

            return max;
        }
    }
}
