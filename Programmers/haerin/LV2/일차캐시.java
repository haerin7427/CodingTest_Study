package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/17680
// title: [1차]캐시
// type : 문자열
// time : 11m
// Created by haerin on 2023-02-08
import java.util.LinkedList;
public class 일차캐시 {
    class Solution {
        public int solution(int cacheSize, String[] cities) {
            LinkedList<String> list = new LinkedList<>();
            int time = 0;
            for(String city : cities) {
                city = city.toLowerCase();
                if(list.contains(city)) {
                    time += 1;
                    list.remove(city);
                    list.addFirst(city);
                }else{
                    time += 5;
                    list.addFirst(city);
                    if(list.size() > cacheSize) {
                        list.removeLast();
                    }
                }
            }
            
            return time;
        }
    }
}
