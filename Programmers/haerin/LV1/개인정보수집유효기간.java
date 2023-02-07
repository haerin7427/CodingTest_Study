// https://school.programmers.co.kr/learn/courses/30/lessons/150370
// title : 개인정보 수집 유효기간
// type : 날짜
// time : 21m
// Created by haerin on 2023-02-08
import java.util.*;
import java.time.LocalDate;
public class 개인정보수집유효기간 {
    class Solution {
        public int[] solution(String today, String[] terms, String[] privacies) {
            HashMap<Character, Integer> termMap = new HashMap<>();
            for(String term : terms) {
                termMap.put(term.charAt(0), Integer.valueOf(term.substring(2)));
            }
            
            LocalDate todayDate = LocalDate.of(Integer.valueOf(today.substring(0,4)),Integer.valueOf(today.substring(5,7)),Integer.valueOf(today.substring(8,10)));
            
            ArrayList<Integer> list = new ArrayList<>();
            for(int i=0; i<privacies.length; i++){
                int year = Integer.valueOf(privacies[i].substring(0,4));
                int month = Integer.valueOf(privacies[i].substring(5,7));
                int day = Integer.valueOf(privacies[i].substring(8,10));
                LocalDate targetDate = LocalDate.of(year,month,day);
                
                targetDate = targetDate.plusMonths(termMap.get(privacies[i].charAt(11)));
                if(!targetDate.isAfter(todayDate)) {
                    list.add(i+1);
                }
            }
            int[] answer = new int[list.size()];
            int idx = 0;
            for(int n : list) {
                answer[idx++] = n;
            }
            return answer;
        }
    }
}