package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/42746
// title : 가장 큰 수 
// type : 정렬
// time : 15m
// Created by haerin on 2023-02-18
import java.util.*;
public class 가장큰수 {
    class Solution {
        public String solution(int[] numbers) {
            String[] str = new String[numbers.length];
            int idx = 0;
            for(int num : numbers){
                str[idx++] = Integer.toString(num);
            }
            
            Arrays.sort(str, new Comparator<String>(){
                @Override
                public int compare (String o1, String o2){
                    String num1 = o1 + o2;
                    String num2 = o2 + o1;
                    return num2.compareTo(num1);
                }
            });
            
            StringBuilder sb = new StringBuilder();
            for(String s : str){
                sb.append(s);
            }
            return sb.toString().matches("[0]{2,}") ? "0" : sb.toString();
        }
    }
}
