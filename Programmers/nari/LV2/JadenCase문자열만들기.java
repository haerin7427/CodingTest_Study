// https://school.programmers.co.kr/learn/courses/30/lessons/12951
// title : JadenCase 문자열 만들기

public class JadenCase문자열만들기 {
    class Solution1 {
        public String solution(String s) {
            StringBuilder sb = new StringBuilder();
            boolean space = true;
            
            for(int i=0;i<s.length();i++) {
                if(s.charAt(i) == ' ') {
                    space = true;
                    sb.append(" ");
                }
                else if(space && Character.isLowerCase(s.charAt(i))) {
                    space = false;
                    sb.append(Character.toUpperCase(s.charAt(i)));
                }
                else if(!space && Character.isUpperCase(s.charAt(i))) {
                    sb.append(Character.toLowerCase(s.charAt(i)));
                }
                else if(space) {
                    space = false;
                    sb.append(s.charAt(i));
                }
                else sb.append(s.charAt(i));
            }
            
            return sb.toString();
        }
    }

    // 1보다 느림 -> 약 0.3~0.4ms 정도 차이?
    class Solution2 {
        public String solution(String s) {
            String[] str = s.toLowerCase().split("");
            StringBuilder sb = new StringBuilder();
            boolean space = true;

            for(String ss : str) {
                sb.append(space ? ss.toUpperCase() : ss);
                space = ss.equals(" ") ? true : false;
            }
            
            return sb.toString();
        }
    }
}