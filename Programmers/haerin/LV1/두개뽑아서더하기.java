// https://school.programmers.co.kr/learn/courses/30/lessons/68644
// title : 두 개 뽑아서 더하기
// time : 14m
// type : SET
// Created by haerin on 2023/01/16
import java.util.*;
public class 두개뽑아서더하기 {
    class Solution {
        public int[] solution(int[] numbers) {
            HashSet<Integer> hashSet = new HashSet<>();
            for(int i=0; i<numbers.length-1; i++) {
                for(int j=i+1; j<numbers.length; j++) {
                    hashSet.add(numbers[i]+numbers[j]);
                }
            }
            

            int[] answer = new int[hashSet.size()];
            int idx = 0;
            for(int num : hashSet) {
                answer[idx++] = num;
            }
            Arrays.sort(answer);
            return answer;
        }
    }
}
