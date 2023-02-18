package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/92341#
// title : 주차 요금 정산
// type : 구현
// time : 1h +
import java.util.*;
public class 주차요금계산 {
    class Solution {
        class Car{
            private int inHour;
            private int inMinute;
            private int outHour;
            private int outMinute;
            
            Car(String inTime){
                this.inHour = Integer.parseInt(inTime.substring(0,2));
                this.inMinute = Integer.parseInt(inTime.substring(3));
            }
            private void setOutTime(String outTime){
                this.outHour = Integer.parseInt(outTime.substring(0,2));
                this.outMinute = Integer.parseInt(outTime.substring(3));
            }
            private int getParkingTime(){
                int inTimeMin= inHour*60 + inMinute;
                int outTimeMin= outHour*60 + outMinute;
                return outTimeMin-inTimeMin;
            }
        }
        public int[] solution(int[] fees, String[] records) {
            Map<String, Car> park = new HashMap<>();
            Map<String, Integer> record = new TreeMap<>();
            
            for(String s : records) {
                String[] info = s.split(" ");
                if(info[2].equals("IN")){
                    park.put(info[1], new Car(info[0]));
                }else{
                    Car car = park.get(info[1]);
                    car.setOutTime(info[0]);
                    park.remove(info[1]);
                    record.put(info[1], record.getOrDefault(info[1], 0) + car.getParkingTime());
                }
            }

            for(String key : park.keySet()){
                Car car = park.get(key);
                car.setOutTime("23:59");
                record.put(key, record.getOrDefault(key, 0) + car.getParkingTime());
            }
            
            int[] answer = new int[record.size()];
            int idx=0;
            for(int time : record.values()){  
                if(time > fees[0]){
                    answer[idx] = fees[3] * (int) Math.ceil((time - fees[0]) / (float) fees[2]);
                }
                answer[idx++] += fees[1];
            }
            return answer;
        }
    }
}
