// https://leetcode.com/problems/palindrome-partitioning/
// title : 131. Palindrome Partitioning
// time taken : 

import java.util.*;

public class PalindromePartitioning {
    class Solution {
        List<List<String>> list = new ArrayList<>();

        public List<List<String>> partition(String s) {
            backtracking(s, new ArrayList<>());

            return list;
        }

        private void backtracking(String s, ArrayList<String> subList) {
            int len = s.length();

            if(len == 0) {
                list.add(new ArrayList<>(subList));
                return;
            }

            for(int i=1;i<=len;i++) {
                String temp = s.substring(0, i);

                // 좌우 대칭 문자열이 아닌 경우
                if(!isPalindrome(temp)) continue;

                subList.add(temp);

                backtracking(s.substring(i, len), subList);

                subList.remove(subList.size()-1);
            }
        }

        private boolean isPalindrome(String s) {
            int left = 0, right = s.length()-1;

            while(left <= right) {
                // 좌우 문자가 동일하지 않을 경우
                if(s.charAt(left) != s.charAt(right)) return false;

                left++;
                right--;
            }

            return true;
        }
    }
}
