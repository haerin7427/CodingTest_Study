// https://school.programmers.co.kr/learn/courses/30/lessons/17676
// title : [1차] 추석 트래픽

import java.text.SimpleDateFormat;
import java.util.*;

public class 추석트래픽 {
    class Solution {
        public int solution(String[] lines) throws Exception {
            int answer = 0;
            int len = lines.length;
            SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss.SSS");
            int[] cnt = new int[len];
            
            for(int i=0;i<len;i++) {
                String[] time1 = lines[i].split(" ");
                Date endDate = format.parse(time1[1]);
                long end = endDate.getTime();
                
                // 자기자신도 아직 체크를 하지 않은 상태이기 때문에
                for(int j=i;j<len;j++) {
                    String[] time2 = lines[j].split(" ");
                    Date nextEndDate = format.parse(time2[1]);
                    // 처리 시간
                    double T = Double.parseDouble(time2[2].substring(0, time2[2].length()-1));
                    // 소수점 셋째 자리 제거
                    long nextStart = (long) (nextEndDate.getTime() - T*1000 + 1);
                    
                    // 현재 끝나는 시간에서 1초 지난 것이 다음 시작하는 시간보다 큰 경우
                    if(end + 1000 > nextStart) {
                        cnt[i] += 1;
                        answer = Math.max(answer, cnt[i]);
                    }
                }
            }
            
            return answer;
        }
    }
}