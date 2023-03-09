package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/147354
// title : 테이블 해시 함수
// type : 정렬
// time : 16m
// Created by haerin on 2023-03-08
import java.util.*;
public class 테이블해시함수 {
    class Solution {
        public int solution(int[][] data, int col, int row_begin, int row_end) {
            Arrays.sort(data, (o1, o2) -> {
                if(o1[col-1] == o2[col-1])
                    return Integer.compare(o2[0], o1[0]);
                else
                    return Integer.compare(o1[col-1], o2[col-1]);
            });
            
            int answer = 0;
            for(int i=row_begin-1; i<row_end; i++){
                int S_i = 0;
                for(int value : data[i]){
                    S_i += value % (i+1);
                }
                answer = (answer ^ S_i);
            }
            return answer;
        }
    }
}
