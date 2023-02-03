// https://school.programmers.co.kr/learn/courses/30/lessons/42862
// title : 체육복
// type : HashMap
// time : 21m
// Created by haerin on 2023-02-02
import java.util.*;
public class 체육복 {
    class Solution {
        public int solution(int n, int[] lost, int[] reserve) {
            HashMap<Integer,Integer> reserveMap = new HashMap<>();
            List<Integer> lostList = new ArrayList<>();

            for(int r : reserve) {
                reserveMap.put(r,1);
            }
            for(int l : lost) {
                if(reserveMap.get(l) != null) {
                    reserveMap.remove(l);
                }else {
                    lostList.add(l);
                }
            }
            int answer = n - lostList.size(); 
            Collections.sort(lostList);
            for(int student : lostList) {
                if(student > 1 && reserveMap.get(student-1) != null) {
                    reserveMap.remove(student-1);
                    answer += 1;
                }else if(student < n && reserveMap.get(student+1) != null) {
                    reserveMap.remove(student+1);
                    answer += 1;
                }
            }
            return answer;
        }
    }
}
