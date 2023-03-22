package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/17678
// title : 셔틀버스
// type : 구현
// time : 1h 10m
// Created by haerin on 2023-03-22
import java.util.*;
public class 셔틀버스 {
    class Solution {
        class Time{
            int hour;
            int minute;
            
            Time(String s){
                String[] info = s.split(":");
                hour = Integer.parseInt(info[0]);
                minute = Integer.parseInt(info[1]);
            }
            
            Time(int n, int t){
                int m = (n-1) * t;
                int h = m / 60;
                m %= 60;
                hour = 9+h;
                minute = m;
            }
            public void plusTime(int m){
                hour += m/60;
                minute += m%60;
            }
            public void minusTime(int m){
                if(minute < m%60){
                    minute = 60 - (m%60 - minute);
                    hour -= 1;
                }else{
                    minute -= m%60;
                }
                hour -= m/60;
            }
            public boolean isBeforeOrEqual(Time t){
                if(hour < t.hour){
                    return false;
                }else if(hour == t.hour && minute < t.minute){
                    return false;
                }
                return true;
            }
            
            public String timeToString(){
                return String.format("%02d", hour) + ":" + String.format("%02d", minute);
            }
        }
        public String solution(int n, int t, int m, String[] timetable) {
            Arrays.sort(timetable);
            
            Queue<Time> queue = new LinkedList<>();
            for(int i=0; i<timetable.length; i++){
                queue.add(new Time(timetable[i]));
            }

            // 이전 버스를 탑승하는 사람 제외시키기
            Time busTime = new Time("09:00");
            for(int N=0; N<n-1; N++){
                int count=0;
                while(count<m && !queue.isEmpty() && busTime.isBeforeOrEqual(queue.peek())){
                    queue.remove();
                    count +=1;
                }
                busTime.plusTime(t);
            }
    
            // 콘이 타야하는 셔틀 버스 자리 확인
            if(queue.size() < m){
                return busTime.timeToString();
            }else{
                // 마지막 승객 탑승 시간
                Time lastTime = queue.peek().timeToString().compareTo(busTime.timeToString()) < 0 ? queue.peek() : busTime;
                for(int M=0; M<m; M++){
                    if(!queue.isEmpty() && busTime.isBeforeOrEqual(queue.peek())){
                        lastTime = queue.remove();
                    }else{
                        // 이 버스에는 자리가 있음
                        return lastTime.timeToString();
                    }
                }
                
                // 마지막 순서로 타야할 때
                lastTime.minusTime(1);
                return lastTime.timeToString();
            }
        }
        
    }
}
