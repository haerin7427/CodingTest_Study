// https://leetcode.com/problems/number-of-good-ways-to-split-a-string/
// title : 1525. Number of Good Ways to Split a String
// time taken : 

import java.util.*;

public class NumberofGoodWaystoSplitaString {
    class Solution {
        public int numSplits(String s) {
            HashMap<Character, Integer> left = new HashMap<>(); 
            HashMap<Character, Integer> right = new HashMap<>();
            int len = s.length();
            int cnt = 0;

            for(int i=0;i<len;i++) {
                right.put(s.charAt(i), right.getOrDefault(s.charAt(i), 0) + 1); 
            }

            for(int i=0;i<len;i++) {
                char ch = s.charAt(i);

                left.put(ch, left.getOrDefault(ch, 0) + 1);
                right.put(ch, right.getOrDefault(ch, 0) - 1);

                if(right.get(ch) <= 0) right.remove(ch);

                // key 갯수가 동일한 경우
                if(left.size() == right.size()) cnt++;
            }

            return cnt;
        }
    }
}
