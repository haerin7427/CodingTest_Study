// https://school.programmers.co.kr/learn/courses/30/lessons/12910
// title : 나누어 떨어지는 숫자 배열

import java.util.*;

public class 나누어떨어지는숫자배열 {
    // 테스트 케이스 16개 기준 평균 속도 약 0.81ms
    class Solution1 {
        public int[] solution(int[] arr, int divisor) {
            ArrayList<Integer> intArr = new ArrayList<Integer>();
            
            for(int i: arr) {
                if(i%divisor == 0) intArr.add(i);
            }
            
            int[] answer = new int[intArr.size()==0 ? 1 : intArr.size()];
            
            if(intArr.size()==0) answer[0] = -1;
            else {
                for (int i=0;i<intArr.size();i++) {
                    answer[i] = intArr.get(i).intValue();
                }
                Arrays.sort(answer);
            }
            
            return answer;
        }
    }

    // 테스트 케이스 16개 기준 평균 속도 약 2~3ms
    class Solution2 {
        public int[] solution(int[] arr, int divisor) {
            int[] answer = Arrays.stream(arr).filter(factor -> factor % divisor == 0).toArray();
            
            if(answer.length == 0) answer = new int[] {-1};
            else Arrays.sort(answer);
            
            return answer;
        }
    }
}