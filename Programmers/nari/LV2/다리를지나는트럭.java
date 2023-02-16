// https://school.programmers.co.kr/learn/courses/30/lessons/42583
// title : 다리를 지나는 트럭

import java.util.*;

public class 다리를지나는트럭 {
    class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            int answer = 0;
            Queue<Integer> queue = new LinkedList<>();
            int weights_in_bridge = 0, time = 0;
            
            for(int truck : truck_weights) { 
                while(true) {
                    // 큐에 아무것도 없는 경우 -> 트럭이 다리 위에 없는 경우
                    if(queue.isEmpty()) { 
                        queue.add(truck);
                        weights_in_bridge += truck;
                        time++;
                        break;
                    }
                    // 큐에 다리 길이만큼 트럭이 다 찬 경우 
                    else if(queue.size() == bridge_length) { 
                        weights_in_bridge -= queue.poll();
                    }
                    else { 
                        // 트럭이 다리에 올라올 때, weight를 넘지 않는 경우
                        if(weights_in_bridge + truck <= weight) {
                            queue.add(truck);
                            weights_in_bridge += truck;
                            time++;
                            break;
                        } 
                        // 넘는다면, 0을 넣어주기
                        else {
                            queue.add(0);
                            time++;
                        }
                    }
                }
            }
            
            // 마지막 트럭이 다리에 올라오면 break
            return time + bridge_length;
        }
    }
}