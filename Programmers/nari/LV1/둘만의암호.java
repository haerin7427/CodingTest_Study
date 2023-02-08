// https://school.programmers.co.kr/learn/courses/30/lessons/155652
// title : 둘만의 암호

public class 둘만의암호 {
    // ASCII 코드 사용
    class Solution {
        public String solution(String s, String skip, int index) {
            StringBuilder answer = new StringBuilder();
                
            for(int i=0;i<s.length();i++) {
                char c = s.charAt(i);
                int num = (int) c;
                    
                // a = 97 | z = 122
                for(int j=1;j<=index;j++) {
                    // num 증가
                    num++;
                        
                    // z를 넘어가면 a로
                    if(num > 122) num = 97;
                        
                    // list에 포함되어 있으면 pass
                    String str = Character.toString((char) num);
                    if(skip.contains(str)) j--;
                }
                    
                answer.append((char) num);
            }
            
            return answer.toString();
        }
    }

    // char 사용
    class Solution {
        public String solution(String s, String skip, int index) {
            StringBuilder answer = new StringBuilder();
            
            for(int i=0;i<s.length();i++) {
                char c = s.charAt(i);
                
                for(int j=1;j<=index;j++) {
                    c = c=='z' ? 'a' : (char) (c+1);
                    
                    String str = Character.toString(c);
                    if(skip.contains(str)) j--;
                }
                
                answer.append(c);
            }
            
            return answer.toString();
        }
    }
}