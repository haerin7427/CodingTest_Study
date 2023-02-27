// https://school.programmers.co.kr/learn/courses/30/lessons/60057
// title : 문자열 압축

public class 문자열압축 {
    class Solution {
        public int solution(String s) {
            // 최솟값 return -> 초기값은 최댓값으로 설정 = 압축되지 않는 문자열 길이
            int answer = s.length();
            
            // 최대 s 길이의 절반으로 압축할 수 있기 때문에
            for(int i=1;i<=s.length()/2;i++) {
                // 연속되는 갯수
                int cnt = 1;
                // 생성된 문자열
                StringBuilder sb = new StringBuilder();
                // 반복되는지 비교될 문자열
                String cur = s.substring(0, i);
                
                for(int j=i;j<=s.length();j+=i) {
                    // 처음 생성된 문자열 이후부터 다시 substring
                    String next = s.substring(j, j+i > s.length() ? s.length() : i+j);
                    
                    // 반복되는 문자가 나온 경우
                    if(cur.equals(next)) cnt++;
                    
                    // 아닐 경우
                    else {
                        // 연속되는 갯수(cnt)가 1일 경우, 생략
                        if(cnt > 1) sb.append(cnt);

                        sb.append(cur);
                        cur = next;
                        cnt = 1;
                    }
                }
                
                // 마지막 인덱스 경우, 돌지 못하고 나오기 때문에 
                if(cnt > 1) sb.append(cnt);
                sb.append(cur);
                
                answer = Math.min(answer, sb.length());
            }
            
            return answer;
        }
    }
}