// https://school.programmers.co.kr/learn/courses/30/lessons/12947
// title : 하샤드 수

import java.util.Arrays;
import java.util.stream.Stream;

public class 하샤드수 {
    // 테스트 케이스 17개 기준 평균 속도 2.36ms
    class Solution1 {
        public boolean solution(int x) {
            // x를 int 배열로 변환
            int[] digits = Stream.of(String.valueOf(x).split("")).mapToInt(Integer::parseInt).toArray();
            int sum = 0;
            
            for(int d : digits) {
                sum += d;
            }
            
            return x%sum == 0;
        }
    }

    // 테스트 케이스 17개 기준 평균 속도 0.05ms
    class Solution2 {
        public boolean solution(int x) {
            // x를 string으로 변환
            String digit = Integer.toString(x);
            int sum = 0;
            
            // for(char d : digit.toCharArray()) {
            //     sum += Character.getNumericValue(d);
            for(int i=0;i<digit.length();i++) {
                sum += Character.getNumericValue(digit.charAt(i));
            }
            
            return x%sum == 0;
        }
    }
}