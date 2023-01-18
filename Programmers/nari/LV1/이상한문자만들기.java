// https://school.programmers.co.kr/learn/courses/30/lessons/12930
// title : 이상한 문자 만들기

public class 이상한문자만들기 {
    class Solution1 {
        public String solution(String s) {
            String[] str = s.split("");
            StringBuffer sb = new StringBuffer();
            int cnt = 0;
            
            for(int i=0;i<str.length;i++) {
                if(str[i].equals(" ")) {
                    if(cnt != 0) cnt = 0;
                    sb.append(" ");
                }
                else {
                    if(cnt%2==0) sb.append(str[i].toUpperCase());
                    else sb.append(str[i].toLowerCase());
                    cnt++;
                }
            }
            
            return sb.toString();
        }
    }

    // 속도면에서 1과 크게 차이 나지 않음
    class Solution2 {
        public String solution(String s) {
            String[] str = s.split("");
            StringBuffer sb = new StringBuffer();
            int cnt = 0;
            
            for(String ss : str) {
                cnt = ss.contains(" ") ? 0 : cnt+1;
                sb.append(cnt%2 == 0 ? ss.toLowerCase() : ss.toUpperCase()); 
            }
            
            return sb.toString();
        }
    }

    // 제일 빠름
    class Solution3 {
        public String solution(String s) {
            char[] chars = s.toCharArray();
            int cnt = 0;

            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == ' ') cnt = 0;
                else
                    chars[i] = (cnt++ % 2 == 0 ? Character.toUpperCase(chars[i]) : Character.toLowerCase(chars[i]));
            }

            return String.valueOf(chars);
        }
    }
}