// https://school.programmers.co.kr/learn/courses/30/lessons/12916
// title : 문자열 내 p와 y의 개수

public class 문자열내p와y의개수 {
    class Solution {
        boolean solution(String s) {
            int pCnt = 0, yCnt = 0;
            
            for(int i=0;i<s.length();i++) {
                if(s.charAt(i) == 'p' || s.charAt(i) == 'P') pCnt++;
                else if(s.charAt(i) == 'y' || s.charAt(i) == 'Y') yCnt++;
            }

            return pCnt == yCnt;
        }
    }
}