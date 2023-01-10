// https://school.programmers.co.kr/learn/courses/30/lessons/12903
// title : 가운데글자가져오기
// time : 4m
// 유형 : 문자열 처리
public class 가운데글자가져오기 {
    // 속도는 비슷
    class Solution {
        public String solution(String s) {
            if(s.length()%2 == 0) {
                return s.substring(s.length()/2-1, s.length()/2+1);
            } else {
                return s.substring(s.length()/2, s.length()/2+1);
            }
        }
    }
    class Solution2 {
        public String solution(String s) {
            return s.equals("") ? s : s.substring((s.length()-1)/2, s.length()/2+1);
        }
    }
}
