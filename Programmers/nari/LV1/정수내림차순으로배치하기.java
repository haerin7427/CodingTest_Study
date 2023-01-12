// https://school.programmers.co.kr/learn/courses/30/lessons/12933
// title : 정수 내림차순으로 배치하기

import java.util.*;

public class 정수내림차순으로배치하기 {
    // 테스트 케이스 16개 기준 평균 속도 0.68ms
    class Solution1 {
        public long solution(long n) {
            String str = Long.toString(n);
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);

            return Long.parseLong(new StringBuilder(new String(charArr)).reverse().toString());
        }
    }

    // 테스트 케이스 16개 기준 평균 속도 0.42ms
    class Solution2 {
        public long solution(long n) {
            String[] strArr = String.valueOf(n).split("");
            Arrays.sort(strArr);
            
            StringBuilder sb = new StringBuilder();
            for (String str : strArr) sb.append(str);

            return Long.parseLong(sb.reverse().toString());
        }
    }
}