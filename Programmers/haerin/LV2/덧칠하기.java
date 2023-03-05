package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/161989
// title : 덧칠하기
// type : 구현
// time : 7m
// Created by haerin on 2023-03-05
import java.util.*;
public class 덧칠하기 {
    class Solution {
        public int solution(int n, int m, int[] section) {
            Arrays.sort(section);
            Queue<Integer> q = new LinkedList<>();
            for(int s : section){
                q.add(s);
            }
            
            int answer = 0;
            while(!q.isEmpty()){
                int num = q.remove();
                answer += 1;
                while(!q.isEmpty() && q.peek() < num+m){
                    q.remove();
                }
            }
            return answer;
        }
    }
    class Solution2 {
        public int solution(int n, int m, int[] section) {
            int roller = section[0];
            int cnt = 1;
            for(int i = 1; i < section.length; i++) {
                if(roller + m - 1 < section[i]) {
                    cnt++;
                    roller = section[i];
                }
            }
            return cnt;
        }
    }
}
