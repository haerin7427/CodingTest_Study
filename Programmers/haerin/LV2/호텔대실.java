package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/155651
// title : 호텔대실
// type : 구현
// time : 20m
// Created by haerin on 2023-03-02
public class 호텔대실 {
    class Solution {
        private static final int MAX_TIME = 1450; // 24*60 + 10;
        private static final int CLEAN_TIME = 10;
        
        public int solution(String[][] book_time) {
            int answer = 0;
    
            int[] rooms = new int[MAX_TIME];
    
            for (String[] time : book_time) {
                String inTime = time[0];
                String outTime = time[1];
    
                rooms[calTime(inTime)] += 1; 
                rooms[calTime(outTime) + CLEAN_TIME] += -1; 
            }
    
            for (int i = 1; i < MAX_TIME; i++) {
                rooms[i] += rooms[i-1];
                answer = Math.max(answer, rooms[i]);
            }
    
            return answer;
        }
        private int calTime(String time){
            String[] t = time.split(":");
            String hour = t[0];
            String minute = t[1];
            return ((Integer.parseInt(hour) * 60) + Integer.parseInt(minute));
        }
    }
}
