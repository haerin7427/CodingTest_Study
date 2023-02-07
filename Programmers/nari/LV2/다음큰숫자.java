// https://school.programmers.co.kr/learn/courses/30/lessons/12911
// title : 다음 큰 숫자

public class 다음큰숫자 {
    class Solution {
        public int solution(int n) {
            int answer = n;
            
            String s = Integer.toBinaryString(n);
            int cnt = 0;
                
            for(int i=0;i<s.length();i++) {
                if(s.charAt(i) == '1') cnt++;
            }
            
            while(true) {
                answer++;
                
                s = Integer.toBinaryString(answer);
                int zeroCnt = 0;
                
                for(int i=0;i<s.length();i++) {
                    if(s.charAt(i) == '1') zeroCnt++;
                }
                
                if(cnt == zeroCnt) break;
            }
            
            return answer;
        }
    }
}