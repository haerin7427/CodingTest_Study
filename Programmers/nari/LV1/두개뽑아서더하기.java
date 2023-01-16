// https://school.programmers.co.kr/learn/courses/30/lessons/68644
// title : 두 개 뽑아서 더하기

import java.util.*;

public class 두개뽑아서더하기 {
    // 테스트 7 〉	8.20ms
    // 테스트 8 〉	2.06ms
    // 테스트 케이스 7개 기준 평균 속도 약 0.5ms (테스트 2개 제외)
    class Solution {
        public int[] solution(int[] numbers) {
            ArrayList<Integer> intArr = new ArrayList<Integer>();

            for(int i=0;i<numbers.length;i++) {
                if(i != numbers.length-1) {
                    for(int j=i+1;j<numbers.length;j++) {
                        int num = numbers[i] + numbers[j];
                        if(!intArr.contains(num)) intArr.add(num);
                    }
                }
            }
            
            int[] answer = new int[intArr.size()];
            
            for(int i=0;i<intArr.size();i++) {
                answer[i] = intArr.get(i).intValue();
            }
            
            Arrays.sort(answer);
            
            return answer;
        }
    }
}