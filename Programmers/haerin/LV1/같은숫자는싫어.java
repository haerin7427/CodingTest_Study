// https://school.programmers.co.kr/learn/courses/30/lessons/12906
// title : 같은 숫자는 싫어
// time : 7m
// type : LIST
// Created by haerin on 2023/01/18
import java.util.*;
public class 같은숫자는싫어 {
    public class Solution {
        public int[] solution(int []arr) {
            ArrayList<Integer> list = new ArrayList<>();
            for(int num : arr) {
                if(list.isEmpty() || list.get(list.size()-1) != num) {
                    list.add(num);
                }
            }
            
            int[] answer = new int[list.size()];
            for(int i=0; i<answer.length; i++) {
                answer[i] = list.get(i);
            }
            return answer;
        }
    }
}
