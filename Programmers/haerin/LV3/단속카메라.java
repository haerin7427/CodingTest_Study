package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/42884
// title : 단속카메라
// type : 그리디(Greedy)
// time : 18m
// Created by haerin on 2023-03-21
import java.util.*;
public class 단속카메라 {
    class Solution {
        public int solution(int[][] routes) {
            Arrays.sort(routes, (o1, o2) -> o1[0]-o2[0]);
            int answer = 0;
            int section_end = -30001;
            int section_start = -30001;
            for(int[] r : routes){
                if(section_end < r[0]){ // 단속용 카메라 설치가 필요한 경우
                    answer += 1;
                    section_start = r[0];
                    section_end = r[1];
                }else{
                    section_start = Math.max(section_start, r[0]);
                    section_end = Math.min(section_end, r[1]);
                }
            }
            return answer;
        }
    }
    class Solution2 {
        public int solution(int[][] routes) {
            Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
            int ans = 0;
            int last_camera = Integer.MIN_VALUE;
            for (int[] a : routes) {
                if (last_camera < a[0]) {
                    ++ans;
                    last_camera = a[1];
                }
            }
            return ans;
        }
    }
}
