// https://leetcode.com/problems/is-subsequence/
// title : 392. Is Subsequence
// time taken : 

public class IsSubsequence {
    class Solution {
        public boolean isSubsequence(String s, String t) {
            int len = s.length();
            int before = 0;
            StringBuilder str = new StringBuilder(t);

            for(int i=0;i<len;i++) {
                int check = str.toString().indexOf(s.charAt(i), before);

                if(check == -1) return false;

                str = str.deleteCharAt(check);
                before = check;
            }

            return true;
        }
    }
}
