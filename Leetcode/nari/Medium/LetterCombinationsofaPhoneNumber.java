// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
// title : 17. Letter Combinations of a Phone Number
// time taken : 

import java.util.*;

public class LetterCombinationsofaPhoneNumber {
    class Solution {
        String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> list = new ArrayList<>();
        int len = 0;
        String Digits;

        public List<String> letterCombinations(String digits) {
            if(digits.equals("")) return list;

            len = digits.length();
            Digits = digits;

            backtracking(new StringBuilder(), 0);

            return list;
        }

        private void backtracking(StringBuilder sb, int idx) {
            if(sb.length() == len) {
                list.add(sb.toString());
                return;
            }

            String str = letters[Digits.charAt(idx) - '0'];

            for(int i=0;i<str.length();i++) {
                StringBuilder newsb = new StringBuilder(sb);
                newsb.append(str.charAt(i));

                backtracking(newsb, idx+1);
            }
        }
    }
}
