// https://school.programmers.co.kr/learn/courses/30/lessons/159994
// title : 카드 뭉치
// type : 문자열
// time : 3m
// Created by haerin on 2023-03-14
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
}
