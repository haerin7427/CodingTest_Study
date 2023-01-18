// https://school.programmers.co.kr/learn/courses/30/lessons/12906
// title : 같은 숫자는 싫어

import java.util.*;

public class 같은숫자는싫어 {
    // 정확성: 테스트 케이스 17개 기준 평균 속도 0.09ms
    // 효율성: 테스트 케이스 4개 기준 평균 속도 28.59ms
    public class Solution {
        public int[] solution(int []arr) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            int cnt = 0;
            
            list.add(arr[0]);
            for(int i=1;i<arr.length;i++) {
                if(list.get(cnt) == arr[i]) continue;
                else {
                    list.add(arr[i]);
                    cnt++;
                }
            }
            
            int[] answer = new int[list.size()];
            for(int i=0;i<list.size();i++) {
                answer[i] = list.get(i);
            }

            return answer;
        }
    }
}