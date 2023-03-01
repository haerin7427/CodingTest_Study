package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/17683
// title : [3차]방금그곡
// type : 구현
// time : 33m + ...
// Created by haerin on 2023-03-01
import java.util.*;
public class 삼차방금그곡 {
    // 실패 -> m : ABC 이고 악보가 ABC# 일 때, 기억하는 음(m)이 악보와 다르더라도 contains함수를 사용해 true 리턴
    class Solution {
        class Song{
            String title;
            int time;
            
            Song(String title, int time){
                this.title = title;
                this.time = time;
            }
        }
        public String solution(String m, String[] musicinfos) {
            String answer = "";
            List<Song> ans = new ArrayList<>();
            for(int i=0; i<musicinfos.length; i++){
                String[] info = musicinfos[i].split(",");
                int playTime = getPlayTime(info[0], info[1]);
                
                int len = info[3].replaceAll("[#]","").length();
                String[] str = new String[len];
                int idx = -1;
                for(char c : info[3].toCharArray()){
                    if(c == '#'){
                        str[idx] += Character.toString(c);
                    }else{
                        str[++idx] = Character.toString(c);
                    }
                }
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<playTime; j++){
                    sb.append(str[j%len]);
                }
                
                if(sb.toString().contains(m)){
                    ans.add(new Song(info[2], playTime));
                }
            }
            
            if(ans.size() == 0){
                return "(None)";
            }
            
            if(ans.size() > 1){
                Collections.sort(ans, new Comparator<Song>(){
                    @Override
                    public int compare(Song s1, Song s2){
                        if(s1.time >= s2.time){
                            return 1;
                        }else {
                            return -1;
                        }
                    }
                });
            }
            return ans.get(0).title;
        }
        
        private int getPlayTime(String startTime, String endTime){
            String[] s = startTime.split(":");
            String[] e = endTime.split(":");
            return (Integer.parseInt(e[0]) - Integer.parseInt(s[0])) * 60 + (Integer.parseInt(e[1]) - Integer.parseInt(s[1]));
        }
        
    }
    // 통과
    class Solution2 {
        public String solution(String m, String[] musicinfos) {
            String title = "";
            int maxPlayTime = -1;
            m = reverseMusic(m);
            for(int i=0; i<musicinfos.length; i++){
                String[] info = musicinfos[i].split(",");
                info[3] = reverseMusic(info[3]);
                int playTime = getPlayTime(info[0], info[1]);
    
                StringBuilder sb = new StringBuilder();
                int p = playTime;
                while(p >= info[3].length()){
                    sb.append(info[3]);
                    p -= info[3].length();
                }
                sb.append(info[3].substring(0,p));
                
                if(sb.toString().contains(m) && maxPlayTime < playTime){
                    maxPlayTime = playTime;
                    title = info[2];
                }
            }
    
            return maxPlayTime == -1 ? "(None)" : title;
        }
        
        private String reverseMusic(String m){
            return m.replaceAll("C#", "c").replaceAll("D#", "d").replaceAll("F#", "f").replaceAll("G#", "g").replaceAll("A#", "a");
        }
        
        private int getPlayTime(String startTime, String endTime){
            String[] s = startTime.split(":");
            String[] e = endTime.split(":");
            return (Integer.parseInt(e[0]) - Integer.parseInt(s[0])) * 60 + (Integer.parseInt(e[1]) - Integer.parseInt(s[1]));
        }
        
    }
}
