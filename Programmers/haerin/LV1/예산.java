// https://school.programmers.co.kr/learn/courses/30/lessons/12982
// title : 예산
// time : 5m
// type : 배열
// Created by haerin on 2023-01-21
import java.util.*;
public class 예산 {
    class Solution {
        public int solution(int[] d, int budget) {
            int answer = d.length;
            Arrays.sort(d);
            for(int i=0; i<d.length; i++) {
                if(budget < d[i]){
                    answer = i;
                    break;
                }
                budget -= d[i];
            }
            return answer;
        }
    }
}
