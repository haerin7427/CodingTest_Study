// https://school.programmers.co.kr/learn/courses/30/lessons/17683
// title : [3차] 방금그곡

public class 방금그곡 {
    class Solution {
        public String solution(String m, String[] musicinfos) {
            String answer = "(None)";
            // 최대 재생 시간 (분)
            int maxTime = 0;
            
            // # 치환
            m = change(m);
            
            for (String musicInfo : musicinfos) {
                String[] info = musicInfo.split(",");
                
                String[] startTime = info[0].split(":");
                String[] endTime = info[1].split(":");
                String music = change(info[3]);
                
                // 분단위로
                int start = Integer.valueOf(startTime[0]) * 60 + Integer.valueOf(startTime[1]);
                int end = Integer.valueOf(endTime[0]) * 60 + Integer.valueOf(endTime[1]);
                
                // 재생 시간 (분)
                int play = end - start;
                
                // 음악 길이보다 재생 시간이 길 때
                if(play > music.length()) {
                    StringBuilder newMusic = new StringBuilder();
                    
                    // 몫만큼 악보 반복
                    for (int i=0;i<play/music.length();i++) {
                        newMusic.append(music);
                    }
                    
                    // 나머지만큼 악보에서 잘라서 붙이기
                    newMusic.append(music.substring(0, play % music.length()));
                    
                    music = newMusic.toString();
                }
                // 음악 길이보다 재생 시간이 짧을 때
                else if(play < music.length()) {
                    // 재생 지속 시간 만큼만 재생
                    music = music.substring(0, play);
                }
                
                // 조건이 일치하는 음악이 여러 개일 때에는 재생된 시간이 제일 긴 음악 제목을 반환
                //   -> 재생 시간가지 비교
                if (music.contains(m) && play > maxTime) {
                    answer = info[2];
                    maxTime = play;
                }
            }
            
            return answer;
        }
        
        String change(String m) {
            m = m.replace("C#","c");
            m = m.replace("D#","d");
            m = m.replace("F#","f");
            m = m.replace("G#","g");
            m = m.replace("A#","a");
            
            return m;
        }
    }
}