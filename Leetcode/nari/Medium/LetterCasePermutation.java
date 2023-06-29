// https://leetcode.com/problems/letter-case-permutation/
// title : 784. Letter Case Permutation
// time taken : 

import java.util.*;

public class LetterCasePermutation {
    class Solution {
        List<String> list = new ArrayList<>();
        int len = 0;

        public List<String> letterCasePermutation(String s) {
            len = s.length();

            backtracking(s, 0);

            return list;
        }

        private void backtracking(String s, int idx) {
            list.add(s);

            for(int i=idx;i<len;i++) {
                char ch = s.charAt(i);

                if(Character.isDigit(ch)) continue;

                if(Character.isUpperCase(ch)) ch = Character.toLowerCase(ch);
                else ch = Character.toUpperCase(ch);

                String newStr = new String(s.substring(0, i) + ch + s.substring(i+1));

                backtracking(newStr, i+1);
            }
        }
    }
}
