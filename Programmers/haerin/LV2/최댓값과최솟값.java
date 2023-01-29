package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/12939
// title : 최댓값과 최솟값
// time : 9m
// type : 문자열
// Created by haerin on 2023-01-29
import java.util.*;
public class 최댓값과최솟값 {
    class Solution {
        public String solution(String s) {
            String[] str = s.split(" ");
            int min = Integer.parseInt(str[0]);
            int max = Integer.parseInt(str[0]);
            for(String num : str) {
                if(min > Integer.parseInt(num)) {
                    min = Integer.parseInt(num);
                }
                if(max < Integer.parseInt(num)) {
                    max = Integer.parseInt(num);
                }
            }
            return min + " " + max;
        }
    }
}
