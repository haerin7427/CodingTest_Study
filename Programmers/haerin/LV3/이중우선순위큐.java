package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/42628
// title : 이중우선순위큐
// type : PriorityQueue
// time : 11m
// Created by haerin on 2023-03-16
import java.util.*;
public class 이중우선순위큐 {
    class Solution {
        public int[] solution(String[] operations) {
            PriorityQueue<Integer> ascpq = new PriorityQueue<>();
            PriorityQueue<Integer> descpq = new PriorityQueue<>(Collections.reverseOrder());
            
            int[] answer = new int[]{0,0};
            for(String op : operations){
                String[] s = op.split(" ");
                if(s[0].equals("I")){
                    ascpq.add(Integer.valueOf(s[1]));
                    descpq.add(Integer.valueOf(s[1]));
                }else if(!ascpq.isEmpty()){
                    int value = 0;
                    if(Integer.valueOf(s[1]) > 0){
                        value = descpq.peek();
                    }else if(!descpq.isEmpty()){
                        value = ascpq.peek();
                    }
                    ascpq.remove(value);
                    descpq.remove(value);
                }
            }
            
            if(!ascpq.isEmpty()){
                answer[0] = descpq.peek();
                answer[1] = ascpq.peek();
            }
            
            return answer;
        }
    }
}
