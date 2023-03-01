package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/131130
// title : 혼자 놀기의 달인
// type : 구현
// time : 26m
// Created by haerin on 2023-03-01
import java.util.*;
public class 혼자놀기의달인 {
    //  점수 구하는 방법 : 모든 그룹의 박스 수를 곱하는 것이 아니라, 상자 그룹 2개를 골라 해당 박스 수를 곱하는 방식
    class Solution {
        public int solution(int[] cards) {
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<cards.length; i++){
                if(cards[i] == 0) continue;
                int cnt=0, idx = i;
                while(cards[idx] != 0){
                    cnt += 1;
                    int newIdx = cards[idx]-1;
                    cards[idx] = 0;
                    idx = newIdx;
                }
                list.add(cnt);
            }
            
            if(list.size() < 2) return 0;
            Collections.sort(list, Collections.reverseOrder());
            return list.get(0) * list.get(1);
        }
    }
}
