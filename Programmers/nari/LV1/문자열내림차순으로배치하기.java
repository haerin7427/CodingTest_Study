// https://school.programmers.co.kr/learn/courses/30/lessons/12917
// title : 문자열 내림차순으로 배치하기

import java.util.*;
import java.util.stream.*;

public class 문자열내림차순으로배치하기 {
    // 테스트 케이스 16개 기준 평균 속도 0.52ms
    class Solution1 {
        public String solution(String s) {
            // string을 char 배열로 만든 후, array sort
            char[] charArr = s.toCharArray();
            Arrays.sort(charArr);
            
            StringBuffer strBf = new StringBuffer(String.valueOf(charArr)).reverse();
            String answer = strBf.toString();
            
            return answer;
        }
    }

    // 테스트 케이스 16개 기준 평균 속도 0.49ms
    class Solution2 {
        public String solution(String s) {
            char[] charArr = s.toCharArray();
            Arrays.sort(charArr);
            
            return new StringBuilder(new String(charArr)).reverse().toString();
        }
    }
    
    // 테스트 케이스 16개 기준 평균 속도 3.68ms
    class Solution3 {
        public String solution(String s) {
            return Stream.of(s.split(""))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining());
        }
    }
}