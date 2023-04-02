package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/72414
// title : 광고 삽입
// type : 누적합
// time : 28m
// Created by haerin on 2023-04-02
public class 광고삽입 {
    class Solution {
        public String solution(String play_time, String adv_time, String[] logs) {
            if(play_time.equals(adv_time)) return "00:00:00";
            
            int[] times = new int[stringToTime(play_time)+1];
            for(String log : logs){
                String[] splitLog = log.split("-");
                int startTime = stringToTime(splitLog[0]);
                int endTime = stringToTime(splitLog[1]);
                for (int i = startTime; i < endTime; i++) {
                    times[i]++;
                }
            }
            
            int playTime = stringToTime(play_time);
            int advTime = stringToTime(adv_time);
            int maxIdx = 0;
            long totalTime = 0;
            // 광고 누적 재생 시간 값을 00:00:00에 광고를 시작했을 경우로 초기화
            for (int i = 0; i < advTime; i++) { 
                totalTime += times[i];
            }
            // 광고 시작 시간을 1초씩 미루면서 광고 누적 재생 시간 값 업데이트
            // 누적 재생 시간 값을 업데이트하면서 최대 누적 재생 시간 값과 시작 시간 기록
            long maxTotalTime = totalTime;
            for (int i = advTime; i < playTime; i++) {
                totalTime += times[i] - times[i - advTime];
                if (totalTime > maxTotalTime) {
                    maxTotalTime = totalTime;
                    maxIdx = i - advTime + 1;
                }
            }
    
            return timeToString(maxIdx);
        }
        
        public String timeToString(int time){
            int H = time / 3600;
            int M = (time % 3600) / 60;
            int S = time % 3600 % 60;
            
            return (H < 10 ? "0" : "") + H + ":" +
                (M < 10 ? "0" : "") + M + ":" +
                (S < 10 ? "0" : "") + S;
        }
        
        public int stringToTime(String s){
            int hour = Integer.parseInt(s.substring(0,2));
            int minute = Integer.parseInt(s.substring(3,5));
            int second = Integer.parseInt(s.substring(6,8));
            
            return hour * 3600 + minute * 60 + second;
        }
    }
}
