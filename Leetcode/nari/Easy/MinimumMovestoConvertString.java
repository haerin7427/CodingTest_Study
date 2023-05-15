// https://leetcode.com/problems/minimum-moves-to-convert-string/
// title : 2027. Minimum Moves to Convert String
// time taken : 7 m 7 s

public class MinimumMovestoConvertString {
    class Solution {
        public int minimumMoves(String s) {
            // X가 존재하지 않는 경우, 0 return
            if(s.indexOf("X") == -1) return 0;

            int cnt = 0;
            int len = s.length();

            for(int i=0;i<len;i++) {
                if(s.charAt(i) == 'O') continue;

                cnt++;
                i += 2;
            }

            return cnt;
        }
    }
}