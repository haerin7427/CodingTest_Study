package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/42586
// title : 기능개발
// type : Queue
// time : 16m
// Created by haerin on 2023-02-14
import java.util.*;
public class 기능개발 {
    class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            List<Integer> ans = new ArrayList<>();
            int idx = 0, day = 0;
            while(idx < progresses.length){
                int cnt = 0;
                day += 1;
                while(idx < progresses.length && (progresses[idx] + day * speeds[idx]) >= 100 ){
                    cnt += 1;
                    idx += 1;
                }
    
                if(cnt > 0){
                    ans.add(cnt);
                }
            }
            
            int[] answer = new int[ans.size()];
            int answerIdx = 0;
            for(int num : ans){
                answer[answerIdx++] = num;
            }
            return answer;
        }
    }
}
