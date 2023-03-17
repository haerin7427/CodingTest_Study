// https://school.programmers.co.kr/learn/courses/30/lessons/159994
// title : 카드 뭉치
// type : 문자열
// time : 3m, 4m
// Created by haerin on 2023-03-14, 2023-03-17
import java.util.*;
public class 카드뭉치 {
    class Solution {
        public String solution(String[] cards1, String[] cards2, String[] goal) {
            int idx1=0, idx2=0;
            for(String word : goal){
                if(idx1 < cards1.length && cards1[idx1].equals(word)){
                    idx1 += 1;
                }else if(idx2 < cards2.length && cards2[idx2].equals(word)){
                    idx2 += 1;
                }else
                    return "No";
            }
            return "Yes";
        }
    }
    class Solution2 {
        public String solution(String[] cards1, String[] cards2, String[] goal) {
            Queue<String> q1 = new LinkedList<>();
            Queue<String> q2 = new LinkedList<>();
            for(String card : cards1){
                q1.add(card);
            }
            for(String card : cards2){
                q2.add(card);
            }
            
            for(String word : goal){
                if(!q1.isEmpty() && q1.peek().equals(word)){
                    q1.remove();
                }else if(!q2.isEmpty() && q2.peek().equals(word)){
                    q2.remove();
                }else
                    return "No";
            }
            return "Yes";
        }
    }
}
