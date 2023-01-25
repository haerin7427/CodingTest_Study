// https://school.programmers.co.kr/learn/courses/30/lessons/12926
// title : 시저 암호

public class 시저암호 {
    // 테스트 13 〉	통과 (1.40ms, 77.6MB)
    // 테스트 케이스 12개 기준 평균 속도 약 0.04ms (1개의 테스트 제외)
    class Solution1 {
        public String solution(String s, int n) {
            char[] arr = s.toCharArray();
            StringBuilder sb = new StringBuilder();

            for(char c : arr) {
                int i = 0;
                
                if(c == ' ') sb.append(' ');
                else if(c < 97 && c+n > 90) {
                    i = 64+((int)c+n-90);
                    char ch = (char) i;
                    sb.append(ch);
                }
                else if(c > 97 && c+n > 122) {
                    i = 96+((int)c+n-122);
                    char ch = (char) i;
                    sb.append(ch);
                }
                else {
                    i = (int) c+n;
                    char ch = (char) i;
                    sb.append(ch);
                }
            }
            
            return sb.toString();
        }
    }

    // 1보다 느림
    class Solution2 {
        public String solution(String s, int n) {
            char[] arr = s.toCharArray();
            StringBuilder sb = new StringBuilder();

            n = n % 26;
            
            for(int i=0;i<s.length();i++) {
                char ch = s.charAt(i);
                
                if (Character.isLowerCase(ch))
                    ch = (char) ((ch - 'a' + n) % 26 + 'a');
                else if (Character.isUpperCase(ch))
                    ch = (char) ((ch - 'A' + n) % 26 + 'A');

                sb.append(ch);
            }
            
            return sb.toString();
        }
    }
}