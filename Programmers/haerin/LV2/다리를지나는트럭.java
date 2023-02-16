package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/42583
// title : 다리를 지나는 트럭
// type : Queue
// time : 13m
// Created by haerin on 2023-02-16
import java.util.*;
public class 다리를지나는트럭 {
    class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            Queue<Integer> bridge = new LinkedList<>();
            for(int i=0; i<bridge_length; i++){
                bridge.add(0);
            }
            
            int sumWeight = 0;
            int time = 0;
            for(int i=0; i<truck_weights.length; i++){
                time += 1;
                sumWeight -= bridge.remove();
                
                while(sumWeight + truck_weights[i] > weight){
                    bridge.add(0); // 빈 자리 차지
                    time += 1; // 1초 시간 흐름
                    sumWeight -= bridge.remove(); // 시간 흐름에 따라 다리를 지난 트럭
                }

                sumWeight += truck_weights[i];
                bridge.add(truck_weights[i]);
            }
            
            return time + bridge_length; // 모든 트럭이 다리에 올라가는 데 걸린 시간 + 마지막 트럭이 다리를 지난 시간
        }
    }
}
