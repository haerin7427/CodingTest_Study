import java.util.*;

public class 자릿수더하기 {
    public class Solution {
        public int solution(int n) {
            int answer = 0;
            
            // int형을 string형으로 변환
            // 문자 하나씩 int로 변환해서 answer에 더하기
            
            String num = Integer.toString(n);
            
            for(int i=0;i<num.length();i++) {
                // System.out.println(num.charAt(i));
                answer += Character.getNumericValue(num.charAt(i));
            }

            return answer;
        }
    }
}