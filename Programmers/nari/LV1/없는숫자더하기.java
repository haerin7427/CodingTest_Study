// https://school.programmers.co.kr/learn/courses/30/lessons/86051
// title : 없는 숫자 더하기

import java.util.*;

public class 없는숫자더하기 {
    // 테스트 케이스 9개 기준 평균 속도 약 0.38ms
    class Solution1 {
        public int solution(int[] numbers) {
            int answer = 0;
            
            // 적용하기 전에 배열이 정렬되면 작동
            Arrays.sort(numbers);
            for(int i=0;i<10;i++) {
                if(Arrays.binarySearch(numbers, i) < 0) answer += i;
            }
            
            return answer;
        }
    }

    // 테스트 케이스 9개 기준 평균 속도 약 0.02ms
    class Solution {
        public int solution(int[] numbers) {
            int answer = 45;
            
            for (int i : numbers) {
                answer -= i;
            }
            
            return answer;
        }
    }

    // 테스트 케이스 9개 기준 평균 속도 약 0.73ms
    class Solution {
        public int solution(int[] numbers) {
            return 45 - Arrays.stream(numbers).sum();
        }
    }
}