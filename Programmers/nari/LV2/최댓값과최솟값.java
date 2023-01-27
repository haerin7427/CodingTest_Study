// https://school.programmers.co.kr/learn/courses/30/lessons/12939
// title : 최댓값과 최솟값

public class 최댓값과최솟값 {
    class Solution {
        public String solution(String s) {
            String[] str = s.split(" ");
            int max = Integer.parseInt(str[0]), min = Integer.parseInt(str[0]);
            int n = 0;
            
            for(int i=1;i<str.length;i++) {
                n = Integer.parseInt(str[i]);
                if(max < n) max = n;
                if(min > n) min = n;
            }
            
            return min + " " + max;
        }
    }
}