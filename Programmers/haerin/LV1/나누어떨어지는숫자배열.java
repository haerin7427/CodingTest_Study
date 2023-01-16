// https://school.programmers.co.kr/learn/courses/30/lessons/12910
// title : 나누어 떨어지는 숫자 배열
// time : 5m
// type : 정수 배열
// Created by haerin on 2023/01/16
import java.util.*;
public class 나누어떨어지는숫자배열 {
    class Solution {
        public int[] solution(int[] arr, int divisor) {
            ArrayList<Integer> list = new ArrayList<>();
            for(int num : arr) {
                if(num % divisor == 0) {
                    list.add(num);
                }
            }
            if(list.size() == 0) return new int[]{-1};
            
            
            Collections.sort(list);
            int[] answer = new int[list.size()];
            int idx = 0;
            for(int num : list) {
                answer[idx++] = num;
            }
            return answer;
        }
    }
}
