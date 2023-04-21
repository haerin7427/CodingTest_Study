package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/17676
// title : 추석 트래픽
// type : 구현
// time : ...
// Created by haerin on 2023-04-20
public class 추석트래픽 {
    class Solution {
        public int solution(String[] lines) {
            int[][] ms = new int[lines.length][2];
            for(int i=0; i<lines.length; i++){
                String info[] = lines[i].split(" ");
                int durMs = (int)(Double.parseDouble(info[2].substring(0,info[2].length()-1))*1000);
                int endMs = parseTime(info[1]);
                int startMs = endMs - durMs + 1;
                ms[i][0] = startMs;
                ms[i][1] = endMs;
            }
            
            int answer = 0;
            for(int i = 0 ; i < lines.length ; ++i) {
                int cnt = 0;
                int startOfSection = ms[i][0];
                int endOfSection = startOfSection + 999;
                
                for(int j = 0 ; j < lines.length ; ++j) {
                    if(ms[j][0] >= startOfSection && ms[j][0] <= endOfSection) {
                        cnt++;
                    } else if(ms[j][1] >= startOfSection && ms[j][1] <= endOfSection) {
                        cnt++;
                    } else if(ms[j][0] <= startOfSection && ms[j][1] >= endOfSection) {
                        cnt++;
                    }
                }
    
                answer = cnt > answer ? cnt : answer;
            }
            
            for(int i = 0 ; i < lines.length ; ++i) {
                int cnt = 0;
                int startOfSection = ms[i][1];
                int endOfSection = startOfSection + 999;
                
                for(int j = 0 ; j < lines.length ; ++j) {
                    if(ms[j][0] >= startOfSection && ms[j][0] <= endOfSection) {
                        cnt++;
                    } else if(ms[j][1] >= startOfSection && ms[j][1] <= endOfSection) {
                        cnt++;
                    } else if(ms[j][0] < startOfSection && ms[j][1] > endOfSection) {
                        cnt++;
                    }
                }
    
                answer = cnt > answer ? cnt : answer;
            }
                
                
            return answer;
        }
        
        private int parseTime(String time){
            String[] t = time.split(":");
            float seconds = (Integer.parseInt(t[0])*60 + Integer.parseInt(t[1]))*60 + Float.parseFloat(t[2]);
            int ms = (int)(seconds*1000);
            return ms;
        }
    }    
}
