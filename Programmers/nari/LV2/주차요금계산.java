// https://school.programmers.co.kr/learn/courses/30/lessons/92341
// title : 주차 요금 계산

import java.util.*;

public class 주차요금계산 {
    class Solution {
        public int[] solution(int[] fees, String[] records) {
            // 차량 번호, 입차 시간
            HashMap<String, Integer> recordMap = new HashMap<>();
            // 차량 번호, 누적 시간
            HashMap<String, Integer> totalMap = new HashMap<>();
            
            for(String record : records) {
                String[] str = record.split(" ");
                
                // 입차된 기록이 있는 경우
                if(recordMap.containsKey(str[1])) {
                    String[] time = str[0].split(":");
                    // 입차 시간
                    int inTime = recordMap.get(str[1]);
                    // 출차 시간
                    int outTime = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
                    // 누적 주차 시간
                    int totalTime = outTime - inTime;
                    
                    totalMap.put(str[1], totalMap.getOrDefault(str[1], 0) + totalTime);
                    
                    // 출차했으면, 삭제
                    recordMap.remove(str[1]);
                }
                // 입차
                else {
                    String[] time = str[0].split(":");
                    // 분 단위로 바꿔주기
                    int min = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
                    
                    recordMap.put(str[1], min);
                }
            }
            
            // 출차 기록이 없는 경우, 23:59 출차
            int lastTime = 23 * 60 + 59;
            for (String key : recordMap.keySet()) {
                int inTime = recordMap.get(key);
                int totalTime = lastTime - inTime;
                
                totalMap.put(key, totalMap.getOrDefault(key, 0) + totalTime);
            }
            
            int[] answer = new int[totalMap.size()];
            int idx = 0;
            ArrayList<String> keySet = new ArrayList<>(totalMap.keySet());

            // 키 값으로 오름차순 정렬
            Collections.sort(keySet);

            for (String key : keySet) {
                int time = totalMap.get(key);
                
                // 기본 시간보다 누적 주차 시간이 같거나 적은 경우, 기본 요금
                if(time <= fees[0]) answer[idx++] = fees[1];
                // 기본 시간보다 누적 주차 시간이 큰 경우
                else {
                    // 기본 요금 + [(누적 시간 - 기본 시간) / 단위 시간] * 단위 요금
                    // 초과한 시간이 단위 시간으로 나누어 떨어지지 않으면, 올림
                    int fee = fees[1] + (int) Math.ceil((double) (time - fees[0]) / fees[2]) * fees[3];
                    answer[idx++] = fee;
                }
            }
            
            return answer;
        }
    }
}